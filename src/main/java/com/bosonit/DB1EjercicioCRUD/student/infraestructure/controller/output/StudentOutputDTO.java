package com.bosonit.DB1EjercicioCRUD.student.infraestructure.controller.output;

import com.bosonit.DB1EjercicioCRUD.persona.domain.Persona;
import com.bosonit.DB1EjercicioCRUD.persona.infraestructure.controller.output.PersonaOutputDTO;
import com.bosonit.DB1EjercicioCRUD.profesor.domain.Profesor;
import com.bosonit.DB1EjercicioCRUD.profesor.infraestructure.controller.output.ProfesorOutputDTO;
import com.bosonit.DB1EjercicioCRUD.student.domain.Student;
import lombok.Data;

import java.util.List;

@Data
public class StudentOutputDTO {

    private String idStudent;
    //private String idPersona;
    private Persona persona;
    private int numHours;
    private String comments;
    //private String idProfesor;
    private Profesor profesor;
    private String branch;

    public StudentOutputDTO(Student student) {
        setIdStudent(student.getIdStudent());
        //setIdPersona(student.getIdPersona());
        setPersona(student.getPersona());
        setNumHours(student.getNumHours());
        setComments(student.getComments());
        //setIdProfesor(student.getIdProfesor());
        setProfesor(student.getProfesor());
        setBranch(student.getBranch());
    }
}
