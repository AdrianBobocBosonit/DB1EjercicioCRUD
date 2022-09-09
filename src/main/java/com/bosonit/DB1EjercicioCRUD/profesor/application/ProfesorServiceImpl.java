package com.bosonit.DB1EjercicioCRUD.profesor.application;

import com.bosonit.DB1EjercicioCRUD.exceptions.EntityNotFoundException;
import com.bosonit.DB1EjercicioCRUD.exceptions.UnprocessableEntityException;
import com.bosonit.DB1EjercicioCRUD.persona.domain.Persona;
import com.bosonit.DB1EjercicioCRUD.persona.infraestructure.repository.PersonaRepository;
import com.bosonit.DB1EjercicioCRUD.profesor.domain.Profesor;
import com.bosonit.DB1EjercicioCRUD.profesor.infraestructure.controller.input.ProfesorInputDTO;
import com.bosonit.DB1EjercicioCRUD.profesor.infraestructure.controller.output.ProfesorOutputDTO;
import com.bosonit.DB1EjercicioCRUD.profesor.infraestructure.repository.ProfesorRepository;
import com.bosonit.DB1EjercicioCRUD.student.infraestructure.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProfesorServiceImpl implements ProfesorService{

    @Autowired
    private ProfesorRepository profesorRepository;

    @Autowired
    private PersonaRepository personaRepository;

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public ProfesorOutputDTO getByIdPersona(String idPersona) {
        Profesor profesor = profesorRepository.findProfesorByIdPersona(idPersona);
        if (profesor == null) {
            throw new EntityNotFoundException("EL PROFESOR CON DICHO ID PERSONA NO EXISTE", 404);
        }
        return new ProfesorOutputDTO(profesor);
    }

    @Override
    public ProfesorOutputDTO addProfesor(ProfesorInputDTO profesorInputDTO) {
        if (profesorInputDTO.getIdPersona() == null) {
            throw new UnprocessableEntityException("SE HA DE PROPORCIONAR UN IDPERSONA", 422);
        }

        Optional<Persona> persona = personaRepository.findById(profesorInputDTO.getIdPersona());
        System.err.println("ESTA ES LA PERSONA QUE SE NOS DEVUELVE: " + persona);

        if (persona.isEmpty()) {
            throw new EntityNotFoundException("LA PERSONA NO HA PODIDO SER ENCONTRADA", 404);
        }

        if (studentRepository.findByIdPersona(profesorInputDTO.getIdPersona()) != null) {
            throw new UnprocessableEntityException("EL PROFESOR QUE ESTAS INTENTANDO ASIGNAR ES UN ESTUDIANTE", 422);
        }

        Profesor profesor = profesorInputDTO.ProfesorInputDTO(persona.get());
        profesor.setPersona(persona.get());
        System.err.println("ESTA ES LA profesor.getPersona QUE SE QUEDA: " + profesor.getPersona());

        System.out.println("######################################################3");
        System.out.println(profesor);
        System.out.println("######################################################3");

        return new ProfesorOutputDTO(profesorRepository.save(profesor));
    }

    @Override
    public List<ProfesorOutputDTO> getAllProfesores() {
        List<ProfesorOutputDTO> listaOut = new ArrayList<>();
        for (Profesor p: profesorRepository.findAll()) {
            listaOut.add(new ProfesorOutputDTO(p));
        }
        return listaOut;
    }

    @Override
    public ProfesorOutputDTO getProfesorByIdProfesor(String idProfesor) throws Exception {
        Profesor profesor = profesorRepository.findById(idProfesor).orElse(null);
        System.out.println("EL PROFESOR ES: " + profesor);
        if (profesor == null) {
            throw new Exception("EL PROFESOR CON EL ID PROFESOR INDICADO NO EXISTE");
        }
        return new ProfesorOutputDTO(profesor);
    }

    @Override
    public void deleteProfesorByIdProfesor(String idProfesor) throws Exception{
        if (idProfesor == null) {
            throw new Exception("SE HA DE PROPORCIONAR UN ID DE ALGUN PROFESOR");
        }

        Profesor profesor = profesorRepository.findById(idProfesor).orElse(null);

        if (profesor == null) {
            throw new EntityNotFoundException("EL POFESOR BUSCADO NO HA PODIDOD SER ENCONTRADO", 404);
        }

        profesorRepository.delete(profesor);
    }

    @Override
    public void deleteProfesorByIdPersona(String idPersona) throws Exception {
        Profesor profesor = profesorRepository.findProfesorByIdPersona(idPersona);
        if (profesor == null) {
            throw new Exception("EL ID PERSONA PROPORCIONADO NO EXISTE");
        }
        profesorRepository.delete(profesor);
    }

    @Override
    public ProfesorOutputDTO updateProfesorByIdProfesor(String idProfesor, String branch) {
        Optional<Profesor> profesor = profesorRepository.findById(idProfesor);
        profesor.get().setBranch(branch);
        return new ProfesorOutputDTO(profesorRepository.save(profesor.get()));
    }
}
