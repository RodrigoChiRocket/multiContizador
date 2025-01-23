package com.qualitas.portal.fraudes.account.application.service.impl;

import com.qualitas.portal.fraudes.account.application.service.CodigoEmailService;
import com.qualitas.portal.fraudes.account.application.service.CorreoService;
import com.qualitas.portal.fraudes.account.application.service.RestablecerContrasenaService;
import com.qualitas.portal.fraudes.account.application.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.SecureRandom;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@Service
public class CodigoEmailServiceImpl implements CodigoEmailService {

    @Autowired
    private CorreoService correoService;


    @Autowired
    private RestablecerContrasenaService restablecerContrasenaService;  // Inyectamos el nuevo servicio


    @Autowired
    private UsuarioService usuarioService;

    private final Map<String, CodigoRestablecimiento> codigosRestablecimiento = new HashMap<>();

    @Override
    public void generarCodigoParaRestablecimiento(String email) {
        if (!usuarioService.existeUsuarioenDB(email)) {
            throw new RuntimeException("No existe un usuario con este email: " + email);
        }

        String codigo = generarCodigoRestablecimiento();
        LocalDateTime expiracion = LocalDateTime.now().plusMinutes(15);  // Código válido por 15 minutos
        codigosRestablecimiento.put(email, new CodigoRestablecimiento(codigo, expiracion));

        // Enviar el código al correo del usuario
        correoService.enviarCorreoRestablecimiento(email, "Usuario", codigo);
    }

    @Override
    public boolean verificarCodigoRestablecimiento(String email, String codigoIngresado) {
        CodigoRestablecimiento datosCodigo = codigosRestablecimiento.get(email);
        if (datosCodigo != null && datosCodigo.codigo.equals(codigoIngresado)) {
            // Verificar si el código no ha expirado
            if (datosCodigo.fechaExpiracion.isAfter(LocalDateTime.now())) {
                return true;  // Código válido
            }
        }
        return false;  // Código incorrecto o expirado
    }

    @Override
    public String generarCodigoRestablecimiento() {
        SecureRandom random = new SecureRandom();
        int codigo = 100000 + random.nextInt(900000);  // Código entre 100000 y 999999
        return String.valueOf(codigo);
    }

    // Método para eliminar el código cuando se restablezca la contraseña
    @Override
    public void eliminarCodigoRestablecimiento(String email) {
        codigosRestablecimiento.remove(email);
    }


    // Clase para almacenar el código y la fecha de expiración
    private static class CodigoRestablecimiento {
        String codigo;
        LocalDateTime fechaExpiracion;

        public CodigoRestablecimiento(String codigo, LocalDateTime fechaExpiracion) {
            this.codigo = codigo;
            this.fechaExpiracion = fechaExpiracion;
        }
    }
}