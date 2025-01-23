package com.qualitas.portal.fraudes.account.application.service.impl;

import com.qualitas.portal.fraudes.account.application.service.CorreoService;
import org.springframework.stereotype.Service;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

@Service
public class CorreoServiceImpl implements CorreoService {

    private final String host = "smtp.gmail.com";
    private final String port = "465";
    private String fromEmail = "rodrigorafaelchipacheco@gmail.com";
    private String password = "rzlgjdhkkrflvuus";


    public boolean enviarCorreo(String toEmail, String nombreUsuario, String contrasena) {

        System.setProperty("https.protocols", "TLSv1.2");

        // Configuración de las propiedades para el servidor SMTP
        Properties properties = new Properties();
        properties.put("mail.smtp.host", host);
        properties.put("mail.smtp.port", port);
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.ssl.enable", "true");
        properties.put("mail.smtp.ssl.protocols", "TLSv1.2");

        // Crear una nueva sesión con autenticación
        Session session = Session.getInstance(properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(fromEmail, password);
            }
        });

        try {
            // Crear el mensaje
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(fromEmail));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(toEmail));
            message.setSubject("¡Bienvenido(a) a nuestra plataforma de Fraudes!");

            // Contenido del correo en formato HTML
            String contenidoHTML = "<html>" +
                    "<body>" +
                    "<h3>Estimado(a) " + nombreUsuario + ",</h3>" +
                    "<p>¡Bienvenido(a) a nuestra plataforma de Fraudes!</p>" +
                    "<p>A continuación, encontrarás tus credenciales de acceso:</p>" +
                    "<ul>" +
                    "<li><strong>Usuario:</strong> " + toEmail + "</li>" +
                    "<li><strong>Contraseña:</strong> " + contrasena + "</li>" +
                    "</ul>" +
                    "<p>Por favor, accede a la plataforma en el siguiente enlace:</p>" +
                    "<a href='https://tuplataforma.com'>https://tuplataforma.com</a>" +
                    "<p>Si tienes alguna duda o necesitas asistencia, no dudes en contactarnos. Estamos aquí para apoyarte.</p>" +
                    "<p>Gracias,<br>Equipo Qualitas</p>" +
                    "</body>" +
                    "</html>";

            // Adjuntar el contenido HTML al mensaje
            message.setContent(contenidoHTML, "text/html; charset=utf-8");

            // Enviar el mensaje
            Transport.send(message);
            System.out.println("Correo enviado exitosamente.");
            return true;

        } catch (MessagingException e) {
            System.err.println("Error al enviar el correo a: " + toEmail);
            e.printStackTrace();
            return false;
        }
    }

    // Correo de restablecimiento de contraseña
    public boolean enviarCorreoRestablecimiento(String toEmail, String nombreUsuario, String codigo) {
        System.setProperty("https.protocols", "TLSv1.2");

        // Configuración de las propiedades para el servidor SMTP
        Properties properties = new Properties();
        properties.put("mail.smtp.host", host);
        properties.put("mail.smtp.port", port);
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.ssl.enable", "true");
        properties.put("mail.smtp.ssl.protocols", "TLSv1.2");

        // Crear una nueva sesión con autenticación
        Session session = Session.getInstance(properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(fromEmail, password);
            }
        });

        try {
            // Crear el mensaje
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(fromEmail));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(toEmail));
            message.setSubject("Código de Restablecimiento de Contraseña");

            // Contenido del correo en formato HTML
            String contenidoHTML = "<html>" +
                    "<body>" +
                    "<h3>Estimado(a) " + nombreUsuario + ",</h3>" +
                    "<p>Hemos recibido una solicitud para restablecer tu contraseña.</p>" +
                    "<p>Tu código de verificación es: <strong>" + codigo + "</strong></p>" +
                    "<p>Este código es válido por 15 minutos.</p>" +
                    "<p>Gracias,<br>Equipo Qualitas</p>" +
                    "</body>" +
                    "</html>";

            // Adjuntar el contenido HTML al mensaje
            message.setContent(contenidoHTML, "text/html; charset=utf-8");

            // Enviar el mensaje
            Transport.send(message);
            System.out.println("Correo de restablecimiento enviado exitosamente.");
            return true;

        } catch (MessagingException e) {
            System.err.println("Error al enviar el correo de restablecimiento a: " + toEmail);
            e.printStackTrace();
            return false;
        }
    }



}
