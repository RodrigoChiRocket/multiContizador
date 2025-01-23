package com.qualitas.portal.fraudes.account.application.service;

public interface RestablecerContrasenaService {

    void restablecerContrasena(String email, String nuevaContrasena, String codigoIngresado);
}
