package com.bosonit.DB1EjercicioCRUD.studentBranch.domain;

import com.bosonit.DB1EjercicioCRUD.profesor.domain.Profesor;
import com.bosonit.DB1EjercicioCRUD.student.domain.Student;
import com.bosonit.DB1EjercicioCRUD.studentBranch.infraestructure.controller.input.StudentBranchInputDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class StudentBranch {

    @Id
    @GeneratedValue(generator = "studentBranchGenerator")
    @GenericGenerator(name = "studentBranchGenerator",
            parameters = @org.hibernate.annotations.Parameter(name = "prefijo", value = "studentBranch"),
            strategy = "com.bosonit.DB1EjercicioCRUD.MiGenerador"
    )
    private String idAsignatura;

    /*@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "profesor_id")
    Profesor profesor;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_student")
    Student student;*/

    private String idStudent;

    private String asignatura;

    private String comments;

    @Column(nullable = false)
    private Date initialDate;

    private Date finishDate;

    public StudentBranch(StudentBranchInputDTO studentBranchInputDTO) {
        setIdAsignatura(studentBranchInputDTO.getIdAsignatura());
        //setProfesor(studentBranchInputDTO.getProfesor());
        setIdStudent(studentBranchInputDTO.getIdStudent());
        setAsignatura(studentBranchInputDTO.getAsignatura());
        setComments(studentBranchInputDTO.getComments());
        setInitialDate(studentBranchInputDTO.getInitialDate());
        setFinishDate(studentBranchInputDTO.getFinishDate());
    }
}
