package com.bosonit.DB1EjercicioCRUD.studentBranch.infraestructure.controller.output;

import com.bosonit.DB1EjercicioCRUD.studentBranch.domain.StudentBranch;
import lombok.Data;

import java.util.Date;

@Data
public class StudentBranchOutputDTO {

    private String idAsignatura;
    private String idStudent;
    private String asignatura;
    private String comments;
    private Date initialDate;
    private Date finishDate;

    public StudentBranchOutputDTO(StudentBranch studentBranch) {
        setIdAsignatura(studentBranch.getIdAsignatura());
        setIdStudent(studentBranch.getIdStudent());
        setAsignatura(studentBranch.getAsignatura());
        setComments(studentBranch.getComments());
        setInitialDate(studentBranch.getInitialDate());
        setFinishDate(studentBranch.getFinishDate());
    }
}
