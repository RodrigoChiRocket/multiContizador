package com.qualitas.portal.fraudes.account.application.service.impl;

import com.qualitas.portal.fraudes.account.application.service.RolService;
import com.qualitas.portal.fraudes.account.application.service.UsuarioService;
import com.qualitas.portal.fraudes.account.application.dto.request.CredencialesDto;
import com.qualitas.portal.fraudes.account.application.dto.response.UsuarioRespuesta;
import com.qualitas.portal.fraudes.account.domain.model.Usuario;
import com.qualitas.portal.fraudes.account.application.service.AutenticacionService;
import com.qualitas.portal.fraudes.account.application.service.CorreoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.qualitas.portal.fraudes.account.Infrastructure.dao.UsuarioDao;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    private static final Logger logger = LoggerFactory.getLogger(UsuarioServiceImpl.class);

    @Autowired
    @Qualifier("usuarioDAOImpl")
    private UsuarioDao usuarioDao;

    @Autowired
    private RolService rolService;

    @Autowired
    private ValidacionContrasenaServiceImpl validacionContrasenaService;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Autowired
    private AutenticacionService autenticacionService;

    @Autowired
    private CorreoService correoService;

    @Override
    public UsuarioRespuesta obtenerUsuarioPorId(BigDecimal id) {
        Usuario usuario = usuarioDao.obtenerUsuario(id);
        return toDto(usuario);
    }

    @Override
    public Usuario obtenerUsuarioPorEmail(String email) {
        return usuarioDao.obtenerUsuarioPorEmail(email);
    }

    @Override
    public Usuario esUsuarioValido(CredencialesDto credenciales) {

        Usuario usuario = usuarioDao.validarUsuario(credenciales.getvUsuario());

        if (!passwordEncoder.matches(credenciales.getvContrasena(), usuario.getvContrasena()))
            throw new RuntimeException("usuario y/o contraseña incorrectos");

        usuario.setvContrasena(null);

        return usuario;
    }

    @Override
    public boolean existeUsuarioenDB(String vEmail) {
        return usuarioDao.existUsuario(vEmail);
    }

    @Override
    public List<String> obtenerRolesUsuario(long id) {
        return Collections.singletonList(this.usuarioDao.obtenerRolUsuario(id));
    }

    @Transactional
    @Override
    public BigDecimal crearUsuario(Usuario usuario) {

        // Verifica si el usuario ya existe en la base de datos por email
        if (existeUsuarioenDB(usuario.getvEmail())) {
            throw new RuntimeException("Ya existe un usuario con este email: (Service) " + usuario.getvEmail());
        }

        // Validar la contraseña. Este método lanzará una excepción si no es válida.
        validacionContrasenaService.esValida(usuario.getvContrasena());

        // Enviar correo con la contraseña y nombre del usuario
        correoService.enviarCorreo(usuario.getvEmail(), usuario.getvNombreCompleto(), usuario.getvContrasena());

        // Encriptar la contraseña
        String contrasenaEncriptada = passwordEncoder.encode(usuario.getvContrasena());
        usuario.setvContrasena(contrasenaEncriptada);

        // Crear usuario en la base de datos
        return usuarioDao.crearUsuario(usuario);
    }




    @Transactional
    @Override
    public void actualizarContrasena(String email, String nuevaContrasena) {
        Usuario usuario = usuarioDao.obtenerUsuarioPorEmail(email);
        if (usuario == null) {
            throw new RuntimeException("Usuario no encontrado.");
        }

        // Obtener la contraseña encriptada anterior
        String vContrasenaAntiguaEncriptada = usuario.getvContrasena();
        logger.info("Contrasena antigua encriptada: {}", vContrasenaAntiguaEncriptada);

        // Registrar si la nueva contraseña coincide con la antigua (esto no desencripta, solo compara)
        if (passwordEncoder.matches(nuevaContrasena, vContrasenaAntiguaEncriptada)) {
            logger.info("La nueva Contrasena coincide con la antigua.");
        }
            logger.info("La nueva Contrasena NO coincide con la antigua.");


        // Encriptar la nueva contraseña
        String contrasenaEncriptada = passwordEncoder.encode(nuevaContrasena);
        usuario.setvContrasena(contrasenaEncriptada);

        usuarioDao.actualizarContrasena(usuario);  // Método en el DAO para actualizar la contraseña
    }


    private UsuarioRespuesta toDto(Usuario usuario) {
        UsuarioRespuesta usuarioRespuesta = new UsuarioRespuesta();

        usuarioRespuesta.setiUsuaID(usuario.getiUsuaID());
        usuarioRespuesta.setvNombreCompleto(usuario.getvNombreCompleto());
        usuarioRespuesta.setvEmail(usuario.getvEmail());
        usuarioRespuesta.setvCelular(usuario.getvCelular());
        usuarioRespuesta.setRol(rolService.obtenerRol(usuario.getiRolClav()));

        return usuarioRespuesta;
    }
}

