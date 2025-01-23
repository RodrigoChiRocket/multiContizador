package com.qualitas.portal.fraudes.account.application.dto.response;

import java.math.BigDecimal;
import java.util.List;

public class RolRespuestaDto {
    private String vRolNombre;
    private List<String> permisos;

    public RolRespuestaDto(String vRolNombre, List<String> permisos) {
        this.vRolNombre = vRolNombre;
        this.permisos = permisos;
    }

    public RolRespuestaDto() {
    }

    public String getvRolNombre() {
        return vRolNombre;
    }

    public void setvRolNombre(String vRolNombre) {
        this.vRolNombre = vRolNombre;
    }

    public List<String> getPermisos() {
        return permisos;
    }

    public void setPermisos(List<String> permisos) {
        this.permisos = permisos;
    }

}
