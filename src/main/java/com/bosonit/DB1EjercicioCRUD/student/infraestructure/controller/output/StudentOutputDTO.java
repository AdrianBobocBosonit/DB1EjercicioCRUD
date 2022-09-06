package com.bosonit.DB1EjercicioCRUD.student.infraestructure.controller.output;

import com.bosonit.DB1EjercicioCRUD.persona.infraestructure.controller.output.PersonaOutputDTO;
import com.bosonit.DB1EjercicioCRUD.profesor.domain.Profesor;
import com.bosonit.DB1EjercicioCRUD.profesor.infraestructure.controller.output.ProfesorOutputDTO;
import com.bosonit.DB1EjercicioCRUD.student.domain.Student;
import lombok.Data;

@Data
public class StudentOutputDTO {

    private String idStudent;
    private String idPersona;
    private PersonaOutputDTO personaOutputDTO;
    private int numHours;
    private String comments;
    private String idProfesor;
    private ProfesorOutputDTO profesorOutputDTO;
    private String branch;

    public StudentOutputDTO(Student student) {
        setIdStudent(student.getIdStudent());
        setIdPersona(student.getIdPersona());
        //setPersonaOutputDTO(new PersonaOutputDTO(student.getPersona()));
        setNumHours(student.getNumHours());
        setComments(student.getComments());
        setIdProfesor(student.getIdProfesor());
        //setProfesorOutputDTO(new ProfesorOutputDTO(student.getProfesor()));
        setBranch(student.getBranch());
    }
}
