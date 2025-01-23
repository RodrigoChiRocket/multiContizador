package com.qualitas.portal.fraudes.account.application.service;



public interface CorreoService {

    boolean enviarCorreo(String toEmail, String nombreUsuario, String contrasena);

    boolean enviarCorreoRestablecimiento(String toEmail, String nombreUsuario, String codigo);
}
