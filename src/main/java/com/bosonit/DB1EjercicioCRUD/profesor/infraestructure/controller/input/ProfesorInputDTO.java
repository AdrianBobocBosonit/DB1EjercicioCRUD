package com.bosonit.DB1EjercicioCRUD.profesor.infraestructure.controller.input;

import com.bosonit.DB1EjercicioCRUD.profesor.domain.Profesor;
import lombok.Data;


@Data
public class ProfesorInputDTO {
    private String idProfesor;
    private String idPersona;
    private String comments;
    private String branch;

    public Profesor ProfesorInputDTO() {
        Profesor profesor = new Profesor();
        profesor.setIdProfesor(this.getIdProfesor());
        profesor.setIdPersona(this.getIdPersona());
        profesor.setComments(this.getComments());
        profesor.setBranch(this.getBranch());
        return profesor;
    }
}
