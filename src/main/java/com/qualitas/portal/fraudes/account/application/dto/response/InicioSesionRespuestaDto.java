package com.qualitas.portal.fraudes.account.application.dto.response;

import com.qualitas.portal.fraudes.account.domain.model.Usuario;

public class InicioSesionRespuestaDto {
    private Usuario usuario;
    private String token;

    public InicioSesionRespuestaDto(Usuario usuario, String token) {
        this.usuario = usuario;
        this.token = token;
    }
    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
