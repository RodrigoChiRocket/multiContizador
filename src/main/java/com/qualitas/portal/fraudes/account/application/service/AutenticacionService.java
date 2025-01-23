package com.qualitas.portal.fraudes.account.application.service;

import com.qualitas.portal.fraudes.account.application.dto.response.InicioSesionRespuestaDto;
import com.qualitas.portal.fraudes.account.application.dto.request.CredencialesDto;
import com.qualitas.portal.fraudes.account.domain.model.Usuario;

import java.math.BigDecimal;

public interface AutenticacionService {

    InicioSesionRespuestaDto iniciarSesion(CredencialesDto credencialesUsuario);

    BigDecimal registrarUsuario(Usuario usuario);

   
}
