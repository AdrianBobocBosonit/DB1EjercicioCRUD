package com.bosonit.DB1EjercicioCRUD.profesor.infraestructure.controller.output;

import com.bosonit.DB1EjercicioCRUD.persona.domain.Persona;
import com.bosonit.DB1EjercicioCRUD.profesor.domain.Profesor;
import lombok.Data;

@Data
public class ProfesorOutputDTO {
    private String idProfesor;
    //private String idPersona;
    private Persona persona;
    private String comments;
    private String branch;

    public ProfesorOutputDTO(Profesor profesor) {
        setIdProfesor(profesor.getIdProfesor());
        //setIdPersona(profesor.getIdPersona());
        setPersona(profesor.getPersona());
        setComments(profesor.getComments());
        setBranch(profesor.getBranch());
    }
}
