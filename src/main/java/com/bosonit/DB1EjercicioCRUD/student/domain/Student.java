package com.bosonit.DB1EjercicioCRUD.student.domain;

import com.bosonit.DB1EjercicioCRUD.persona.domain.Persona;
import com.bosonit.DB1EjercicioCRUD.profesor.domain.Profesor;
import com.bosonit.DB1EjercicioCRUD.student.infraestructure.controller.input.StudentInputDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Data
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
    private String idPersona;

    /*@OneToOne
    @JoinColumn(name = "id_person")
    private Persona persona;*/

    @Column(nullable = false)
    private int numHours;
    private String comments;
    private String idProfesor;

    /*@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_profesor")
    private Profesor profesor;*/

    @Column(nullable = false)
    private String branch;

    public Student(StudentInputDTO studentInputDTO) {
        setIdStudent(studentInputDTO.getIdStudent());
        //setIdPersona(studentInputDTO.getIdPersona());
        setNumHours(studentInputDTO.getNumHours());
        setComments(studentInputDTO.getComments());
        //setIdProfesor(studentInputDTO.getIdProfesor());
        setBranch(studentInputDTO.getBranch());
    }
}
