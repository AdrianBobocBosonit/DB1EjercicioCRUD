package com.bosonit.DB1EjercicioCRUD.studentBranch.domain;

import com.bosonit.DB1EjercicioCRUD.profesor.domain.Profesor;
import com.bosonit.DB1EjercicioCRUD.student.domain.Student;
import com.bosonit.DB1EjercicioCRUD.studentBranch.infraestructure.controller.input.StudentBranchInputDTO;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
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

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "profesor_id")
    private Profesor profesor;
    /*@ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_student")
    Student student;*/

    //private String idStudent;
    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "student_studentBranch",
            joinColumns = @JoinColumn(name = "idAsignatura"),
            inverseJoinColumns = @JoinColumn(name = "idStudent"))
    private List<Student> students;

    private String asignatura;

    private String comments;

    @Column(nullable = false)
    private Date initialDate;

    private Date finishDate;
}
