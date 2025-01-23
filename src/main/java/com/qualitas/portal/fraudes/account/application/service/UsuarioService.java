package com.qualitas.portal.fraudes.account.application.service;

import com.qualitas.portal.fraudes.account.application.dto.request.CredencialesDto;
import com.qualitas.portal.fraudes.account.application.dto.response.UsuarioRespuesta;
import com.qualitas.portal.fraudes.account.domain.model.Usuario;

import java.math.BigDecimal;
import java.util.List;

public interface UsuarioService {
    UsuarioRespuesta obtenerUsuarioPorId(BigDecimal id);
    Usuario obtenerUsuarioPorEmail(String email);
    Usuario esUsuarioValido(CredencialesDto credenciales);
    boolean existeUsuarioenDB(String vEmail);
    List<String> obtenerRolesUsuario(long id);
    BigDecimal crearUsuario (Usuario usuario);

    void actualizarContrasena(String email, String nuevaContrasena);
}
