package com.qualitas.portal.fraudes.account.domain.model;

import java.math.BigDecimal;

public class Usuario {

    private BigDecimal iUsuaID;
    private String vEmail;
    private String vNombreCompleto;
    private String vContrasena;
    private BigDecimal iRolClav;
    private String vCelular;


    public Usuario() {
    }

    public Usuario(BigDecimal iUsuaID, String vEmail, String vNombreCompleto, String vContrasena, BigDecimal iRolClav, String vCelular) {
        this.iUsuaID = iUsuaID;
        this.vEmail = vEmail;
        this.vNombreCompleto = vNombreCompleto;
        this.vContrasena = vContrasena;
        this.iRolClav = iRolClav;
        this.vCelular = vCelular;
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

    public String getvContrasena() {
        return vContrasena;
    }

    public void setvContrasena(String vContrasena) {
        this.vContrasena = vContrasena;
    }

    public BigDecimal getiRolClav() {
        return iRolClav;
    }

    public void setiRolClav(BigDecimal iRolClav) {
        this.iRolClav = iRolClav;
    }

    public String getvCelular() {
        return vCelular;
    }

    public void setvCelular(String vCelular) {
        this.vCelular = vCelular;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "iUsuaID=" + iUsuaID +
                ", vEmail='" + vEmail + '\'' +
                ", vNombreCompleto='" + vNombreCompleto + '\'' +
                ", vContrasena='" + vContrasena + '\'' +
                ", iRolClav=" + iRolClav +
                '}';
    }
}
