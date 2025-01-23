package com.qualitas.portal.fraudes.account.application.convertDTO;

import com.qualitas.portal.fraudes.account.application.dto.PersonaDTO;
import com.qualitas.portal.fraudes.account.application.dto.request.PersonaRequestDTO;
import com.qualitas.portal.fraudes.account.domain.model.Persona;

public interface PersonaConvertDTO {

    Persona dtoToEntity(PersonaDTO personaDTO);


    PersonaDTO entityToDto(Persona persona);
}
