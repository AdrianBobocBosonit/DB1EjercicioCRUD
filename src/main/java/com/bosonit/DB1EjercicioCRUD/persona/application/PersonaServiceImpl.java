package com.bosonit.DB1EjercicioCRUD.persona.application;


import com.bosonit.DB1EjercicioCRUD.persona.domain.Persona;
import com.bosonit.DB1EjercicioCRUD.persona.infraestructure.controller.input.PersonaInputDTO;
import com.bosonit.DB1EjercicioCRUD.persona.infraestructure.controller.output.PersonaOutputDTO;
import com.bosonit.DB1EjercicioCRUD.persona.infraestructure.repository.PersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PersonaServiceImpl implements PersonaService {

    @Autowired
    private PersonaRepository personaRepository;

     @Override
     public List<PersonaOutputDTO> findByName(String name) {

         List<PersonaOutputDTO> listaOutByName = new ArrayList<>();

         for (Persona p: personaRepository.findPersonaByName(name)) {
             listaOutByName.add(new PersonaOutputDTO(p));
         }

        return listaOutByName;
     }
    @Override
    public PersonaOutputDTO addPersona(PersonaInputDTO personaInputDTO) throws Exception {
        if (!personaInputDTO.getCompanyEmail().contains("@")) {
            throw new Exception("El email de la compañia no es valido");
        }
        if (!personaInputDTO.getPersonalEmail().contains("@")) {
            throw new Exception("El email personal no es valido");
        }

        Persona persona = personaInputDTO.PersonaInputDTO();


        System.out.println("######################################################3");
        System.out.println(persona);
        System.out.println("######################################################3");

        return new PersonaOutputDTO(personaRepository.save(persona));
    }

    @Override
    public List<PersonaOutputDTO> getAllPersonas() {
        List<PersonaOutputDTO> listadoOut = new ArrayList<>();

        for (Persona p: personaRepository.findAll()) {
             listadoOut.add(new PersonaOutputDTO(p));
         }

        return listadoOut;
    }

    @Override
    public PersonaOutputDTO getPersonaById(String id) {

         Optional<Persona> p = personaRepository.findById(id);
         if (p == null) {
             throw new EntityNotFoundException("NO HAY UNA PERSONA CON EL ID " + id);
         }
         return new PersonaOutputDTO(p.get());
    }

    @Override
    public void deletePersonaById(String id) {
         if (id == null) {
             throw new EntityNotFoundException("NO SE HA ENCONTRADO DICHA PERSONA A ELIMINAR");
         } else {
             personaRepository.deleteById(id);
         }

    }

    @Override
    public PersonaOutputDTO updatePersonaById(String id, String password) {
         Optional<Persona> personaAActualizar = personaRepository.findById(id);
        if (personaAActualizar.get() != null) {
            personaAActualizar.get().setPassword(password);
            personaRepository.saveAndFlush(personaAActualizar.get());
        } else if (personaAActualizar.get() == null) {
            throw new EntityNotFoundException("NO SE HA ENCONTRADO NINGUNA PERSONA CON ESE ID");
        }
        return new PersonaOutputDTO(personaAActualizar.get());
    }
}
