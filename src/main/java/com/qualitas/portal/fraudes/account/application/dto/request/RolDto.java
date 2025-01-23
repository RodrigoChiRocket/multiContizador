package com.qualitas.portal.fraudes.account.application.dto.request;

import java.math.BigDecimal;
import java.util.List;

public class RolDto {
    private String vRolNombre;
    private List<BigDecimal> permisosId;

    public RolDto() {
    }

    public RolDto(String vRolNombre, List<BigDecimal> permisosId) {
        this.vRolNombre = vRolNombre;
        this.permisosId = permisosId;
    }

    public String getvRolNombre() {
        return vRolNombre;
    }

    public void setvRolNombre(String vRolNombre) {
        this.vRolNombre = vRolNombre;
    }

    public List<BigDecimal> getPermisosId() {
        return permisosId;
    }

    public void setPermisosId(List<BigDecimal> permisosId) {
        this.permisosId = permisosId;
    }
}
