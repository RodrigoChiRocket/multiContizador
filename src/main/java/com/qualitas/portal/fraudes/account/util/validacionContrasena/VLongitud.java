package com.qualitas.portal.fraudes.account.util.validacionContrasena;

import org.springframework.stereotype.Component;

@Component
public class VLongitud implements VContrasena {
    @Override
    public boolean esValida(String contrasena) {
        return contrasena.length() >= 8 && contrasena.length() <= 16;
    }
}
