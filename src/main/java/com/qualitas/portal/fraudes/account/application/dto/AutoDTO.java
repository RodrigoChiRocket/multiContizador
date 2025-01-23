package com.qualitas.portal.fraudes.account.application.dto;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
public class AutoDTO {
    private BigDecimal iAutoId;
    private String vDescripcion;
    private Date dFechaCreacion;

}
