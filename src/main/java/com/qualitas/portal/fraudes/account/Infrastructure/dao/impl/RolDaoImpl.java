package com.qualitas.portal.fraudes.account.Infrastructure.dao.impl;

import com.qualitas.portal.fraudes.account.Infrastructure.dao.RolDao;
import com.qualitas.portal.fraudes.account.domain.model.Rol;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class RolDaoImpl extends SqlSessionDaoSupport implements RolDao {
    @Override
    public BigDecimal crearRol(Rol rol, List<BigDecimal> permisos) {

        try {
            this.getSqlSession().insert("crearRol", rol);
            insertarPermisos(rol.getiRolId(), permisos);

            return rol.getiRolId();
        } catch (Exception e){
            throw new IllegalArgumentException(e);
        }
    }

    @Override
    public Rol obtenerRol(BigDecimal iRolId) {
        try {
            return this.getSqlSession().selectOne("obtenerRol", iRolId);
        } catch (Exception e){
            throw new IllegalArgumentException(e);
        }
    }

    @Override
    public List<Rol> roles() {
        try {
            return this.getSqlSession().selectList("obtenerRoles");
        } catch (Exception e){
            throw new IllegalArgumentException(e);
        }
    }

    @Override
    public List<String> obtenerPermisos(BigDecimal iRolId) {
        try {
            return this.getSqlSession().selectList("obtenerPermisos", iRolId);
        } catch (Exception e){
            throw new IllegalArgumentException(e);
        }
    }

    private void insertarPermisos(BigDecimal iRolId, List<BigDecimal> permisos){
        Map<String, Object> params = new HashMap<>();
        params.put("iRolId", iRolId);

        try {
            for(BigDecimal permiso : permisos){
                params.put("iPermisoId", permiso);
                this.getSqlSession().insert("crearRolPermiso", params);
            }
        } catch (Exception e){
            throw new IllegalArgumentException(e);
        }

    }
}
