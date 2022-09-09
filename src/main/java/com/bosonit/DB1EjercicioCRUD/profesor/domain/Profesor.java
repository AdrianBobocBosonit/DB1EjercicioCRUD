package com.bosonit.DB1EjercicioCRUD.profesor.domain;

import com.bosonit.DB1EjercicioCRUD.persona.domain.Persona;
import com.bosonit.DB1EjercicioCRUD.profesor.infraestructure.controller.input.ProfesorInputDTO;
import com.bosonit.DB1EjercicioCRUD.student.domain.Student;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.List;

@AllArgsConstructor
@Getter
@Setter
@ToString
@NoArgsConstructor
@Entity
public class Profesor {
    @Id
    @GeneratedValue(generator = "profesorGenerator")
    @GenericGenerator(name = "profesorGenerator",
            parameters = @org.hibernate.annotations.Parameter(name = "prefijo", value = "profesor"),
            strategy = "com.bosonit.DB1EjercicioCRUD.MiGenerador"
    )
    private String idProfesor;

    //private String idPersona;
    @OneToOne
    @JoinColumn(name = "idPerson")
    private Persona persona;

    private String comments;

    @Column(nullable = false)
    private String branch;

    /*@OneToMany(mappedBy = "profesor")
    private List<Student> studentList;*/

    public Profesor(ProfesorInputDTO profesorInputDTO) {
        setIdProfesor(profesorInputDTO.getIdProfesor());
        //setIdPersona(profesorInputDTO.getIdPersona());
        setComments(profesorInputDTO.getComments());
        setBranch(profesorInputDTO.getBranch());
    }
}
