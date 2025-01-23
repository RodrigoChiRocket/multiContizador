package com.qualitas.portal.fraudes.account.application.dto.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.qualitas.portal.fraudes.account.domain.enums.Sexo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PersonaRequestDTO {
    private String vNombre;
    private Sexo vSexo;
    private Integer iCodigoPostal;
    private Date dFechaNacimiento;
}
