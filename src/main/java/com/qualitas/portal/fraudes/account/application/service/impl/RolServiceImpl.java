package com.qualitas.portal.fraudes.account.application.service.impl;

import com.qualitas.portal.fraudes.account.Infrastructure.dao.RolDao;
import com.qualitas.portal.fraudes.account.application.service.RolService;
import com.qualitas.portal.fraudes.account.application.dto.response.RolRespuestaDto;
import com.qualitas.portal.fraudes.account.domain.model.Rol;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class RolServiceImpl implements RolService {
    @Autowired
    private RolDao rolDao;

    @Override
    @Transactional
    public BigDecimal crearRol(String vRolNombre, List<BigDecimal> permisos) {
        Rol rol = new Rol();
        rol.setvRolNombre(vRolNombre);

        return rolDao.crearRol(rol, permisos);
    }

    @Override
    public RolRespuestaDto obtenerRol(BigDecimal iRolId) {
        return toDto(rolDao.obtenerRol(iRolId));
    }

    @Override
    public List<RolRespuestaDto> roles() {

        return rolDao.roles().stream()
                .map(this::toDto)
                .collect(Collectors.toList());
    }

    private RolRespuestaDto toDto(Rol rol){
        return new RolRespuestaDto(rol.getvRolNombre(),
                rolDao.obtenerPermisos(rol.getiRolId()));
    }
}
