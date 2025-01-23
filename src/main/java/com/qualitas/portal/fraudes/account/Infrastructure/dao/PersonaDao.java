package com.qualitas.portal.fraudes.account.Infrastructure.dao;

import com.qualitas.portal.fraudes.account.domain.model.Persona;

import java.math.BigDecimal;
import java.util.List;

public interface PersonaDao {

    Persona crearPersona(Persona persona);
    Persona obtenerPersona(BigDecimal id);
    Persona actualizarPersona(Persona persona);
    List<Persona> listarPersonas();
    void eliminarPersona(BigDecimal id);


}
