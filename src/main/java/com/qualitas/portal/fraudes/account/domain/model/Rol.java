package com.qualitas.portal.fraudes.account.domain.model;

import java.math.BigDecimal;

public class Rol {
    private BigDecimal iRolId;
    private String vRolNombre;

    public Rol(BigDecimal iRolId, String vRolNombre) {
        this.iRolId = iRolId;
        this.vRolNombre = vRolNombre;
    }

    public Rol() {
    }

    public BigDecimal getiRolId() {
        return iRolId;
    }

    public void setiRolId(BigDecimal iRolId) {
        this.iRolId = iRolId;
    }

    public String getvRolNombre() {
        return vRolNombre;
    }

    public void setvRolNombre(String vRolNombre) {
        this.vRolNombre = vRolNombre;
    }
}
