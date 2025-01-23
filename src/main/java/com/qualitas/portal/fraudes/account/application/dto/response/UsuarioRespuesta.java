package com.qualitas.portal.fraudes.account.application.dto.response;

import java.math.BigDecimal;

public class UsuarioRespuesta {
    private BigDecimal iUsuaID;
    private String vEmail;
    private String vNombreCompleto;
    private String vCelular;
    private RolRespuestaDto rol;

    public UsuarioRespuesta(BigDecimal iUsuaID, String vEmail, String vNombreCompleto, String vCelular, RolRespuestaDto rol) {
        this.iUsuaID = iUsuaID;
        this.vEmail = vEmail;
        this.vNombreCompleto = vNombreCompleto;
        this.vCelular = vCelular;
        this.rol = rol;
    }

    public UsuarioRespuesta() {
    }

    public BigDecimal getiUsuaID() {
        return iUsuaID;
    }

    public void setiUsuaID(BigDecimal iUsuaID) {
        this.iUsuaID = iUsuaID;
    }

    public String getvEmail() {
        return vEmail;
    }

    public void setvEmail(String vEmail) {
        this.vEmail = vEmail;
    }

    public String getvNombreCompleto() {
        return vNombreCompleto;
    }

    public void setvNombreCompleto(String vNombreCompleto) {
        this.vNombreCompleto = vNombreCompleto;
    }

    public String getvCelular() {
        return vCelular;
    }

    public void setvCelular(String vCelular) {
        this.vCelular = vCelular;
    }

    public RolRespuestaDto getRol() {
        return rol;
    }

    public void setRol(RolRespuestaDto rol) {
        this.rol = rol;
    }
}
