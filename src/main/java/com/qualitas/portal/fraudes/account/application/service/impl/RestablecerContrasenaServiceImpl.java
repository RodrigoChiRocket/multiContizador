package com.qualitas.portal.fraudes.account.application.service.impl;

import com.qualitas.portal.fraudes.account.application.service.CodigoEmailService;
import com.qualitas.portal.fraudes.account.application.service.RestablecerContrasenaService;
import com.qualitas.portal.fraudes.account.application.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RestablecerContrasenaServiceImpl implements RestablecerContrasenaService {

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private CodigoEmailService codigoEmailService;

    @Override
    public void restablecerContrasena(String email, String nuevaContrasena, String codigoIngresado) {
        // Verifica si el código de restablecimiento es válido
        if (codigoEmailService.verificarCodigoRestablecimiento(email, codigoIngresado)) {
            // Actualizar la contraseña del usuario
            usuarioService.actualizarContrasena(email, nuevaContrasena);
            // Eliminar el código de restablecimiento
            codigoEmailService.eliminarCodigoRestablecimiento(email);
        } else {
            throw new RuntimeException("Código de restablecimiento inválido o expirado.");
        }
    }
}
