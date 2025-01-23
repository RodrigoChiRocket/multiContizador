package com.qualitas.portal.fraudes.account.domain.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Auto {
    private BigDecimal iAutoId;
    private String vDescripcion;
    private Date dFechaCreacion;

}
