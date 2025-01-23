package com.qualitas.portal.fraudes.account.application.service;

import com.qualitas.portal.fraudes.account.application.dto.PersonaDTO;
import com.qualitas.portal.fraudes.account.application.dto.request.PersonaRequestDTO;

import java.math.BigDecimal;
import java.util.List;

public interface PersonaService {

    // Crear una nueva persona
    PersonaDTO crearPersona(PersonaDTO personaRequestDTO);

    // Obtener una persona por su ID
    PersonaDTO obtenerPersona(BigDecimal id);

    // Actualizar una persona existente
    PersonaDTO actualizarPersona(BigDecimal id, PersonaDTO personaRequestDTO);

    // Listar todas las personas
    List<PersonaDTO> listarPersonas();

    // Eliminar una persona por su ID
    void eliminarPersona(BigDecimal id);


}
