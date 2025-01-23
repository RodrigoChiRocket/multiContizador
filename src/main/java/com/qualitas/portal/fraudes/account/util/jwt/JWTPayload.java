package com.qualitas.portal.fraudes.account.util.jwt;

import java.util.List;

public class JWTPayload {

    private long idUsuario;
    private String emailUsuario;
    private List<String> roles;

    public JWTPayload(){}

    public JWTPayload(long idUsuario, String emailUsuario, List<String> roles) {
        this.idUsuario = idUsuario;
        this.emailUsuario = emailUsuario;
        this.roles = roles;
    }

    public long getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(long idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getEmailUsuario() {
        return emailUsuario;
    }

    public void setEmailUsuario(String emailUsuario) {
        this.emailUsuario = emailUsuario;
    }

    public List<String> getRoles() {
        return roles;
    }

    public void setRoles(List<String> roles) {
        this.roles = roles;
    }

    @Override
    public String toString() {
        return "JWTPayload{" +
                "idUsuario=" + idUsuario +
                ", emailUsuario='" + emailUsuario + '\'' +
                ", roles=" + roles +
                '}';
    }
}
