package com.qualitas.portal.fraudes.account.application.service.impl;

import com.qualitas.portal.fraudes.account.util.validacionContrasena.VContrasena;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ValidacionContrasenaServiceImpl {

    @Autowired
    private List<VContrasena> validacionContrasena;

    public void esValida(String contrasena) {
        for (VContrasena regla : validacionContrasena) {
            if (!regla.esValida(contrasena)) {
                throw new RuntimeException("La contraseña no es válida");
            }
        }
    }
}
