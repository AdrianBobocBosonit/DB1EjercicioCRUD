package com.bosonit.DB1EjercicioCRUD.profesor.application;


import com.bosonit.DB1EjercicioCRUD.profesor.infraestructure.controller.input.ProfesorInputDTO;
import com.bosonit.DB1EjercicioCRUD.profesor.infraestructure.controller.output.ProfesorOutputDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProfesorService {
    ProfesorOutputDTO getByIdPersona(String idPersona) throws Exception;

    ProfesorOutputDTO addProfesor(ProfesorInputDTO profesorInputDTO) throws Exception;

    List<ProfesorOutputDTO> getAllProfesores();

    ProfesorOutputDTO getProfesorByIdProfesor(String idProfesor) throws Exception;

    void deleteProfesorByIdProfesor(String idProfesor) throws Exception;

    void deleteProfesorByIdPersona(String idPersona) throws Exception;

    ProfesorOutputDTO updateProfesorByIdProfesor(String idProfesor, String branch);
}
