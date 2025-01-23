package com.qualitas.portal.fraudes.account.application.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.qualitas.portal.fraudes.account.domain.enums.Sexo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;

public class PersonaDTO {
    private BigDecimal iPersonaId;
    private String vNombre;
    private Sexo vSexo;
    private Integer iCodigoPostal;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date dFechaNacimiento;

    public PersonaDTO() {
    }

    public PersonaDTO(BigDecimal iPersonaId, String vNombre, Sexo vSexo, Integer iCodigoPostal, Date dFechaNacimiento) {
        this.iPersonaId = iPersonaId;
        this.vNombre = vNombre;
        this.vSexo = vSexo;
        this.iCodigoPostal = iCodigoPostal;
        this.dFechaNacimiento = dFechaNacimiento;
    }

    public BigDecimal getiPersonaId() {
        return iPersonaId;
    }

    public void setiPersonaId(BigDecimal iPersonaId) {
        this.iPersonaId = iPersonaId;
    }

    public String getvNombre() {
        return vNombre;
    }

    public void setvNombre(String vNombre) {
        this.vNombre = vNombre;
    }

    public Sexo getvSexo() {
        return vSexo;
    }

    public void setvSexo(Sexo vSexo) {
        this.vSexo = vSexo;
    }

    public Integer getiCodigoPostal() {
        return iCodigoPostal;
    }

    public void setiCodigoPostal(Integer iCodigoPostal) {
        this.iCodigoPostal = iCodigoPostal;
    }

    public Date getdFechaNacimiento() {
        return dFechaNacimiento;
    }

    public void setdFechaNacimiento(Date dFechaNacimiento) {
        this.dFechaNacimiento = dFechaNacimiento;
    }
}
