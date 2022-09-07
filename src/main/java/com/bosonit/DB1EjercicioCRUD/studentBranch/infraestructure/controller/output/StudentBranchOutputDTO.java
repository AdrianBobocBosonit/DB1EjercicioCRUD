package com.bosonit.DB1EjercicioCRUD.studentBranch.infraestructure.controller.output;

import com.bosonit.DB1EjercicioCRUD.student.domain.Student;
import com.bosonit.DB1EjercicioCRUD.studentBranch.domain.StudentBranch;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class StudentBranchOutputDTO {

    private String idAsignatura;
    private String asignatura;
    private List<Student> studentList;
    private String comments;
    private Date initialDate;
    private Date finishDate;

    public StudentBranchOutputDTO(StudentBranch studentBranch) {
        setIdAsignatura(studentBranch.getIdAsignatura());
        setAsignatura(studentBranch.getAsignatura());
        setStudentList(studentBranch.getStudents());
        setComments(studentBranch.getComments());
        setInitialDate(studentBranch.getInitialDate());
        setFinishDate(studentBranch.getFinishDate());
    }
}
