package com.bosonit.DB1EjercicioCRUD.studentBranch.infraestructure.controller.input;

import com.bosonit.DB1EjercicioCRUD.profesor.domain.Profesor;
import com.bosonit.DB1EjercicioCRUD.student.domain.Student;
import com.bosonit.DB1EjercicioCRUD.studentBranch.domain.StudentBranch;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class StudentBranchInputDTO {
    //A la hora de implementar un profesor o un estudiante hay que poner referencia al output(private ProfesorOutputDTOP profesor)

    private String idAsignatura;
    private String idProfesor;
    private String idStudent;
    private String asignatura;
    private String comments;
    private Date initialDate;
    private Date finishDate;

    public StudentBranch studentBranchInputDTO(Profesor profesor) {
        StudentBranch studentBranch = new StudentBranch();
        studentBranch.setProfesor(profesor);
        //studentBranch.setStudents(studentList);
        studentBranch.setAsignatura(this.getAsignatura());
        studentBranch.setComments(this.getComments());
        studentBranch.setInitialDate(this.getInitialDate());
        studentBranch.setFinishDate(this.getFinishDate());
        return studentBranch;
    }
}
