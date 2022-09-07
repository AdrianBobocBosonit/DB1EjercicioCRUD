package com.bosonit.DB1EjercicioCRUD.student.infraestructure.controller.input;

import com.bosonit.DB1EjercicioCRUD.persona.domain.Persona;
import com.bosonit.DB1EjercicioCRUD.profesor.domain.Profesor;
import com.bosonit.DB1EjercicioCRUD.student.domain.Student;
import lombok.Data;

@Data
public class StudentInputDTO {

    private String idStudent;
    private String idPersona;
    private int numHours;
    private String comments;
    private String idProfesor;
    private String branch;

    public Student StudentInputDTO(Persona persona, Profesor profesor) {
        Student student = new Student();
        student.setIdStudent(this.getIdStudent());
        //student.setIdPersona(this.getIdPersona());
        //student.setPersona(persona);
        student.setNumHours(this.getNumHours());
        student.setComments(this.getComments());
        //student.setIdProfesor(this.getIdProfesor());
        //student.setProfesor(profesor);
        student.setBranch(this.getBranch());
        return student;
    }
}
