package com.bosonit.DB1EjercicioCRUD.persona.application;

import com.bosonit.DB1EjercicioCRUD.persona.domain.Persona;
import com.bosonit.DB1EjercicioCRUD.persona.infraestructure.controller.input.PersonaInputDTO;
import com.bosonit.DB1EjercicioCRUD.persona.infraestructure.controller.output.PersonaOutputDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PersonaService {
    List<PersonaOutputDTO> findByName(String name);

    PersonaOutputDTO addPersona(PersonaInputDTO personaInputDTO) throws Exception;

    List<PersonaOutputDTO> getAllPersonas();

    PersonaOutputDTO getPersonaById(String id) throws Exception;

    void deletePersonaById(String id);

    PersonaOutputDTO updatePersonaById(String id, String password) throws Exception;
}
