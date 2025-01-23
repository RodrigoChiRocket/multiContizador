package com.qualitas.portal.fraudes.account.Infrastructure.dao;

import com.qualitas.portal.fraudes.account.domain.model.Rol;

import java.math.BigDecimal;
import java.util.List;

public interface RolDao {
    BigDecimal crearRol(Rol rol, List<BigDecimal> permisos);
    Rol obtenerRol(BigDecimal iRolId);
    List<Rol> roles();
    List<String> obtenerPermisos(BigDecimal iRolId);
}
