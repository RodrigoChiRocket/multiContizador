package com.qualitas.portal.fraudes.account.Infrastructure.dao.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.qualitas.portal.fraudes.account.Infrastructure.dao.UsuarioDao;
import com.qualitas.portal.fraudes.account.util.Retry;
import com.qualitas.portal.fraudes.account.domain.model.Usuario;
import org.mybatis.spring.support.SqlSessionDaoSupport;


import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;

@Repository("usuarioDAOImpl")
public class UsuarioDaoImpl extends SqlSessionDaoSupport implements UsuarioDao {
    @Override
    public Usuario obtenerUsuario(BigDecimal id) {
        try {
            return this.getSqlSession().selectOne("obtenerUsuario", id);

        } catch(Exception e){
            System.out.println(e.getMessage());
            throw new IllegalArgumentException("Ocurrio un problema al recuperar los datos");
        }
    }

    @Override
    public Usuario validarUsuario(String usuario){

        Optional<Usuario> usuarioEnDB = Optional.empty();
        int currentAttempt = 0;
        boolean completo = false;

        while(!completo && currentAttempt < Retry.ATTEMPTS){
            try {
                usuarioEnDB = Optional.ofNullable(this.getSqlSession().
                        selectOne("validarUsuario", usuario));
                this.getSqlSession().clearCache();
                currentAttempt = Retry.ATTEMPTS + 1;
                completo = true;
            }catch(Exception ignore){
                currentAttempt += 1;
            }
        }

        if(!usuarioEnDB.isPresent())
            throw new RuntimeException("Usuario no existe o las crendeenciales son invalidas");

        return usuarioEnDB.get();
    }

    @Override
    public boolean existUsuario(String vEmail){

        Optional<Usuario> usuariosExistente = Optional.empty();
        boolean failed = true;
        int currentAttempt = 0;

        while(failed && currentAttempt < Retry.ATTEMPTS){
            try {
                usuariosExistente = Optional.ofNullable(getSqlSession().
                        selectOne("obtenerUsuarioPorEmail", vEmail));
                this.getSqlSession().clearCache();
                failed = false;
            }catch(Exception ignore){
                currentAttempt += 1;
            }
        }

        return usuariosExistente.isPresent();
    }

    @Override
    public String obtenerRolUsuario(long id) {

        Optional<String> rolUsuario = Optional.empty();
        int currentAttempt = 0;
        boolean completo = false;

        while(!completo && currentAttempt < Retry.ATTEMPTS){
            try {
                rolUsuario = Optional.ofNullable(this.getSqlSession().
                        selectOne("obtenerRolUsuario", BigDecimal.valueOf(id)));
                this.getSqlSession().clearCache();
                completo = true;
                currentAttempt = Retry.ATTEMPTS + 1;
            }catch(Exception ignore){
                currentAttempt += 1;
            }
        }

        if(!rolUsuario.isPresent())
            throw new RuntimeException("Ocurrio un problema al recuperar los datos");

        return rolUsuario.get();
    }

    @Override
    public Usuario obtenerUsuarioPorEmail(String email) {
        Optional<Usuario> usuario = Optional.empty();
        int currentAttempt = 0;
        boolean completo = false;

        while (!completo && currentAttempt < Retry.ATTEMPTS) {
            try {
                usuario = Optional.ofNullable(this.getSqlSession().selectOne("obtenerUsuarioPorEmail", email));
                this.getSqlSession().clearCache();
                currentAttempt = Retry.ATTEMPTS + 1;
                completo = true;
            } catch (Exception ignore) {
                currentAttempt += 1;
            }
        }

        if (!usuario.isPresent()) {
            throw new RuntimeException("Usuario con email " + email + " no existe");
        }

        return usuario.get();
    }


    @Override
    public long obtenerRolID(String rol) {

        Optional<Long> rolUsuarioID = Optional.empty();
        int currentAttempt = 0;
        boolean completo = false;

        while(!completo && currentAttempt < Retry.ATTEMPTS){
            try {
                rolUsuarioID = Optional.ofNullable(this.getSqlSession().
                        selectOne("obtenerRolID", rol));
                this.getSqlSession().clearCache();
                completo = true;
                currentAttempt = Retry.ATTEMPTS + 1;
            }catch(Exception ignore){
                currentAttempt += 1;
            }
        }

        if (!rolUsuarioID.isPresent())
            throw new RuntimeException("rol no admitido");

        return rolUsuarioID.get();
    }

    @Override
    public List<Map<String, Object>> obtenerUsuarioPorRol(long rol) {

        List<String> usuarios = Collections.emptyList();
        int currentAttempt = 0;
        boolean completo = false;

        while(!completo && currentAttempt < Retry.ATTEMPTS){
            try {
                usuarios = this.getSqlSession().selectList("obtenerUsuarioPorRol", rol);
                this.getSqlSession().clearCache();
                currentAttempt = Retry.ATTEMPTS + 1;
                completo = true;
            }catch(Exception ignore){
                currentAttempt += 1;;
            }
        }


        if(usuarios.isEmpty())
            throw new RuntimeException("usuarios no encontrados");

        ObjectMapper mapJson = new ObjectMapper();
        List filtrados = usuarios.stream().map(usuario -> {
            try {
                return mapJson.readValue(usuario, Map.class);
            } catch (IOException e) {
                return null;
            }
        }).collect(Collectors.toList());

        this.getSqlSession().clearCache();

        return filtrados;
    }

    @Override
    public String obtenerUsuarioPorId(long id) {
        return this.getSqlSession().selectOne("obtenerUsuarioPorId", id);
    }

    @Override
    public BigDecimal crearUsuario(Usuario usuario) {
        try {
            this.getSqlSession().insert("crearUsuario", usuario);
            return usuario.getiUsuaID();
        } catch (Exception e) {
            throw new IllegalArgumentException(e.getMessage());
        }
    }

    @Override
    public void actualizarContrasena(Usuario usuario) {
        this.getSqlSession().update("actualizarContrasena", usuario);
    }



}
