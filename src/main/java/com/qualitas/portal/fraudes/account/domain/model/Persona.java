package com.qualitas.portal.fraudes.account.domain.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.qualitas.portal.fraudes.account.domain.enums.Sexo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

import java.util.Date;public class Persona {
    private BigDecimal iPersonaId;
    private String vNombre;
    private Sexo vSexo;
    private Integer iCodigoPostal;
    private Date dFechaNacimiento;

    // Getter y Setter para iPersonaId
    public BigDecimal getiPersonaId() {
        return iPersonaId;
    }

    public void setiPersonaId(BigDecimal iPersonaId) {
        this.iPersonaId = iPersonaId;
    }

    // Getter y Setter para vNombre
    public String getVNombre() {
        return vNombre;
    }

    public void setVNombre(String vNombre) {
        this.vNombre = vNombre;
    }

    // Getter y Setter para vSexo
    public Sexo getVSexo() {
        return vSexo;
    }

    public void setVSexo(Sexo vSexo) {
        this.vSexo = vSexo;
    }

    // Getter y Setter para iCodigoPostal
    public Integer getICodigoPostal() {
        return iCodigoPostal;
    }

    public void setICodigoPostal(Integer iCodigoPostal) {
        this.iCodigoPostal = iCodigoPostal;
    }

    // Getter y Setter para dFechaNacimiento
    public Date getDFechaNacimiento() {
        return dFechaNacimiento;
    }

    public void setDFechaNacimiento(Date dFechaNacimiento) {
        this.dFechaNacimiento = dFechaNacimiento;
    }
}
