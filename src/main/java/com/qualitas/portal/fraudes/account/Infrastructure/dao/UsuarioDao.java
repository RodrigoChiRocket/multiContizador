package com.qualitas.portal.fraudes.account.Infrastructure.dao;

import com.qualitas.portal.fraudes.account.domain.model.Usuario;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

public interface UsuarioDao {
    Usuario obtenerUsuario(BigDecimal id);
    Usuario validarUsuario(String usuario);
    boolean existUsuario(String vEmail);
    String obtenerRolUsuario(long id);
    long obtenerRolID(String rol);
    List<Map<String,Object>> obtenerUsuarioPorRol(long rol);
    String obtenerUsuarioPorId(long id);
    void actualizarContrasena(Usuario usuario);
    Usuario obtenerUsuarioPorEmail(String email);
    // Nuevo método para crear un usuario
    BigDecimal crearUsuario(Usuario usuario);

}
