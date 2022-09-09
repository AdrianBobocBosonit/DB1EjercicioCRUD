package com.bosonit.DB1EjercicioCRUD.persona.application;

import com.bosonit.DB1EjercicioCRUD.exceptions.EntityNotFoundException;
import com.bosonit.DB1EjercicioCRUD.exceptions.UnprocessableEntityException;
import com.bosonit.DB1EjercicioCRUD.persona.domain.Persona;
import com.bosonit.DB1EjercicioCRUD.persona.infraestructure.controller.input.PersonaInputDTO;
import com.bosonit.DB1EjercicioCRUD.persona.infraestructure.controller.output.PersonaOutputDTO;
import com.bosonit.DB1EjercicioCRUD.persona.infraestructure.repository.PersonaRepository;
import com.bosonit.DB1EjercicioCRUD.profesor.domain.Profesor;
import com.bosonit.DB1EjercicioCRUD.profesor.infraestructure.repository.ProfesorRepository;
import com.bosonit.DB1EjercicioCRUD.student.domain.Student;
import com.bosonit.DB1EjercicioCRUD.student.infraestructure.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PersonaServiceImpl implements PersonaService {

    @Autowired
    private PersonaRepository personaRepository;

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private ProfesorRepository profesorRepository;

     @Override
     public List<PersonaOutputDTO> findByName(String name) {
         if (name == null) {
             throw new UnprocessableEntityException("Nombre no proporcionado",422);
         }

         List<PersonaOutputDTO> listaOutByName = new ArrayList<>();
         List<Persona> personaList =  personaRepository.findPersonaByName(name);

         if (personaList.size() == 0) {
             throw new com.bosonit.DB1EjercicioCRUD.exceptions.EntityNotFoundException("No hay ninguna persona con ese nombre", 422);
         }

         for (Persona p: personaList) {
             listaOutByName.add(new PersonaOutputDTO(p));
         }

        return listaOutByName;
     }
    @Override
    public PersonaOutputDTO addPersona(PersonaInputDTO personaInputDTO) {
        if (!personaInputDTO.getCompanyEmail().contains("@")) {
            throw new UnprocessableEntityException("El email de la compañia no es valido", 422);
        }
        if (!personaInputDTO.getPersonalEmail().contains("@")) {
            throw new UnprocessableEntityException("El email personal no es valido", 422);
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
        List<Persona> personaList = personaRepository.findAll();

        if (personaList.size() == 0) {
            throw new EntityNotFoundException("No hay personas asignadas", 404);
        }

        for (Persona p: personaList) {
             listadoOut.add(new PersonaOutputDTO(p));
         }

        return listadoOut;
    }

    @Override
    public PersonaOutputDTO getPersonaById(String id) {

         Optional<Persona> p = personaRepository.findById(id);
         if (p.isEmpty()) {
             throw new EntityNotFoundException("NO HAY UNA PERSONA CON EL ID " + id, 404);
         }
         return new PersonaOutputDTO(p.get());
    }

    @Override
    public void deletePersonaById(String id) {
         if (id == null) {
             throw new EntityNotFoundException("NO SE HA ENCONTRADO DICHA PERSONA A ELIMINAR", 404);
         } else {
             personaRepository.deleteById(id);
         }

    }

    @Override
    public PersonaOutputDTO updatePersonaById(String id, String password) {
         Optional<Persona> personaAActualizar = personaRepository.findById(id);
        if (personaAActualizar.isPresent()) {
            personaAActualizar.get().setPassword(password);
            personaRepository.saveAndFlush(personaAActualizar.get());
        } else {
            throw new EntityNotFoundException("NO SE HA ENCONTRADO NINGUNA PERSONA CON ESE ID", 404);
        }
        return new PersonaOutputDTO(personaAActualizar.get());
    }

    @Override
    public PersonaOutputDTO findFullByIdPersona(String idPersona) {
        System.out.println("ESTE ES EL IDPERSONA QUE LLEGA: " + idPersona);
        PersonaOutputDTO personaOutputDTO;

        Persona persona = personaRepository.findById(idPersona).orElse(null);
        System.err.println("ESTA ES LA PERSONA: " + persona);

        Profesor profesor = profesorRepository.findProfesorByIdPersona(idPersona);
        System.out.println("ESTE ES EL PROFESOR: " + profesor);
        if (profesor != null) {

            personaOutputDTO = new PersonaOutputDTO(persona, profesor);
            return personaOutputDTO;
        }

        Student student = studentRepository.findByIdPersona(idPersona);
        System.out.println("ESTE ES EL STUDENT: " + student);
        if (student != null) {

            personaOutputDTO = new PersonaOutputDTO(persona, student);
            return personaOutputDTO;
        }

        System.err.println("HACER RETURN NULL");
        return null;
    }
}
