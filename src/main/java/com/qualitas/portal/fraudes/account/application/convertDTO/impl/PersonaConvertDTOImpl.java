package com.qualitas.portal.fraudes.account.application.convertDTO.impl;

import com.qualitas.portal.fraudes.account.application.convertDTO.PersonaConvertDTO;
import com.qualitas.portal.fraudes.account.application.dto.PersonaDTO;
import com.qualitas.portal.fraudes.account.application.dto.request.PersonaRequestDTO;
import com.qualitas.portal.fraudes.account.domain.model.Persona;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
public class PersonaConvertDTOImpl implements PersonaConvertDTO {

    private static final Logger logger = LoggerFactory.getLogger(PersonaConvertDTOImpl.class);

    @Override
    public Persona dtoToEntity(PersonaDTO personaDTO) {
        logger.info("Convirtiendo PersonaDTO a Persona: {}", personaDTO);
        Persona persona = new Persona();
        persona.setiPersonaId(personaDTO.getiPersonaId());
        persona.setVNombre(personaDTO.getvNombre());
        persona.setVSexo(personaDTO.getvSexo());
        persona.setICodigoPostal(personaDTO.getiCodigoPostal());
        persona.setDFechaNacimiento(personaDTO.getdFechaNacimiento());
        return persona;
    }



    @Override
    public PersonaDTO entityToDto(Persona persona) {
        PersonaDTO personaDTO = new PersonaDTO();
        personaDTO.setiPersonaId(persona.getiPersonaId());
        personaDTO.setvNombre(persona.getVNombre());
        personaDTO.setvSexo(persona.getVSexo());
        personaDTO.setiCodigoPostal(persona.getICodigoPostal());
        personaDTO.setdFechaNacimiento(persona.getDFechaNacimiento());
        return personaDTO;
    }
}
