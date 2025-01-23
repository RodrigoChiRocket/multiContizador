package com.qualitas.portal.fraudes.account.domain.model;

import java.math.BigDecimal;

public class Permiso {

    private BigDecimal iPermisoId;
    private String vPermisoNombre;

    public Permiso(String peticion) {
        this.vPermisoNombre = peticion;
    }

    public Permiso(BigDecimal idPermiso, String peticion) {
        this.iPermisoId = idPermiso;
        this.vPermisoNombre = peticion;
    }

    public BigDecimal getiPermisoId() {
        return iPermisoId;
    }

    public void setiPermisoId(BigDecimal iPermisoId) {
        this.iPermisoId = iPermisoId;
    }

    public String getvPermisoNombre() {
        return vPermisoNombre;
    }

    public void setvPermisoNombre(String vPermisoNombre) {
        this.vPermisoNombre = vPermisoNombre;
    }
}
