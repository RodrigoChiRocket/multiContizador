package com.qualitas.portal.fraudes.account.util.validacionContrasena;

import org.springframework.stereotype.Component;

@Component
public class VCaracteres implements VContrasena {
    @Override
    public boolean esValida(String contrasena) {
        return contrasena.matches(".*[!@#$%^&*(),.?\":{}|<>].*");
    }
}
