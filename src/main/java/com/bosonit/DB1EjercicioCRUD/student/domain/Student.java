package com.bosonit.DB1EjercicioCRUD.student.domain;

import com.bosonit.DB1EjercicioCRUD.persona.domain.Persona;
import com.bosonit.DB1EjercicioCRUD.profesor.domain.Profesor;
import com.bosonit.DB1EjercicioCRUD.student.infraestructure.controller.input.StudentInputDTO;
import com.bosonit.DB1EjercicioCRUD.studentBranch.domain.StudentBranch;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Student {
    @Id
    @GeneratedValue(generator = "studentGenerator")
    @GenericGenerator(name = "studentGenerator",
            parameters = @org.hibernate.annotations.Parameter(name = "prefijo", value = "student"),
            strategy = "com.bosonit.DB1EjercicioCRUD.MiGenerador"
    )
    private String idStudent;
    //private String idPersona;

    @OneToOne
    @JoinColumn(name = "id_person")
    private Persona persona;

    @Column(nullable = false)
    private int numHours;
    private String comments;
    //private String idProfesor;

    /*@ManyToOne(fetch = FetchType.LAZY)
     @JoinColumn(name = "id_profesor")*/

    /*@ManyToMany()
    @JoinTable(name = "student_profesor",
                joinColumns = {@JoinColumn(name = "student_id")},
                inverseJoinColumns = {@JoinColumn(name = "profesor_id")})
    private List<Profesor> profesorList;*/

    @ManyToOne
    @JoinColumn(name = "id_profesor")
    private Profesor profesor;

    @Column(nullable = false)
    @ManyToMany(mappedBy = "students")
    private List<StudentBranch> branch;


}
