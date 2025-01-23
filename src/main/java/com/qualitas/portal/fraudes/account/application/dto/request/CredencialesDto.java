package com.qualitas.portal.fraudes.account.application.dto.request;

public class CredencialesDto {

    private String vUsuario;
    private String vContrasena;


    public CredencialesDto(){}

    public CredencialesDto(String vUsuario, String vContrasena){
        this.vUsuario = vUsuario;
        this.vContrasena = vContrasena;
    }


    public String getvUsuario() {
        return vUsuario;
    }

    public void setvUsuario(String vUsuario) {
        this.vUsuario = vUsuario;
    }

    public String getvContrasena() {
        return vContrasena;
    }

    public void setvContrasena(String vContrasena) {
        this.vContrasena = vContrasena;
    }
}
