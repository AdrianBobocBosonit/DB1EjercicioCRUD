package com.bosonit.DB1EjercicioCRUD.profesor.infraestructure.controller.output;

import com.bosonit.DB1EjercicioCRUD.profesor.domain.Profesor;
import lombok.Data;

@Data
public class ProfesorOutputDTO {
    private String idProfesor;
    private String idPersona;
    private String comments;
    private String branch;

    public ProfesorOutputDTO(Profesor profesor) {
        setIdProfesor(profesor.getIdProfesor());
        setIdPersona(profesor.getIdPersona());
        setComments(profesor.getComments());
        setBranch(profesor.getBranch());
    }
}
