package com.qualitas.portal.fraudes.account.application.service.impl;

import com.qualitas.portal.fraudes.account.application.dto.response.InicioSesionRespuestaDto;
import com.qualitas.portal.fraudes.account.application.dto.request.CredencialesDto;
import com.qualitas.portal.fraudes.account.domain.model.Usuario;
import com.qualitas.portal.fraudes.account.application.service.AutenticacionService;
import com.qualitas.portal.fraudes.account.application.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigDecimal;
import java.util.List;

@Service
public class AutenticacionServiceImpl implements AutenticacionService {

    @Autowired
    private UsuarioService usuarioService;
    private static final Logger logger = LoggerFactory.getLogger(AutenticacionServiceImpl.class);

    @Autowired
    AutenticacionService autenticacionService;

    @Override
    public InicioSesionRespuestaDto iniciarSesion(CredencialesDto credencialesUsuario) {
        Usuario usuario = usuarioService.esUsuarioValido(credencialesUsuario);
        List<String> roles = usuarioService.obtenerRolesUsuario(usuario.getiUsuaID().longValue());

        //String token = JwtUtil.generarToken(usuario.getvEmail(), usuario.getiUsuaID().longValue(), roles, JwtUtil.JWT_SEMILLA);

        return new InicioSesionRespuestaDto(usuario, null);
    }

    @Override
    public BigDecimal registrarUsuario(Usuario usuario) {
        return usuarioService.crearUsuario(usuario);
    }

}
