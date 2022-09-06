package com.bosonit.DB1EjercicioCRUD.profesor.application;

import com.bosonit.DB1EjercicioCRUD.persona.infraestructure.controller.output.PersonaOutputDTO;
import com.bosonit.DB1EjercicioCRUD.profesor.domain.Profesor;
import com.bosonit.DB1EjercicioCRUD.profesor.infraestructure.controller.input.ProfesorInputDTO;
import com.bosonit.DB1EjercicioCRUD.profesor.infraestructure.controller.output.ProfesorOutputDTO;
import com.bosonit.DB1EjercicioCRUD.profesor.infraestructure.repository.ProfesorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProfesorServiceImpl implements ProfesorService{

    @Autowired
    private ProfesorRepository profesorRepository;

    @Override
    public ProfesorOutputDTO getByIdPersona(String idPersona) throws Exception{
        Profesor profesor = profesorRepository.findProfesorByIdPersona(idPersona);
        if (profesor == null) {
            throw new Exception("EL PROFESOR CON DICHO ID PERSONA NO EXISTE");
        }
        return new ProfesorOutputDTO(profesor);
    }

    @Override
    public ProfesorOutputDTO addProfesor(ProfesorInputDTO profesorInputDTO) throws Exception {
        Profesor profesor = profesorInputDTO.ProfesorInputDTO();
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
        Profesor profesor = profesorRepository.findById(idProfesor).orElse(null);
        if (idProfesor == null) {
            throw new Exception("EL ID PROFESOR PROPORCIONADO NO EXISTE");
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
