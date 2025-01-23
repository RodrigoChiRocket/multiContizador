package com.qualitas.portal.fraudes.account.application.service;

import com.qualitas.portal.fraudes.account.application.dto.response.RolRespuestaDto;

import java.math.BigDecimal;
import java.util.List;

public interface RolService {
    BigDecimal crearRol(String vRolNombre, List<BigDecimal> permisos);
    RolRespuestaDto obtenerRol(BigDecimal iRolId);
    List<RolRespuestaDto> roles();
}
