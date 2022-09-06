package com.bosonit.DB1EjercicioCRUD.profesor.domain;

import com.bosonit.DB1EjercicioCRUD.profesor.infraestructure.controller.input.ProfesorInputDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
public class Profesor {
    @Id
    @GeneratedValue(generator = "profesorGenerator")
    @GenericGenerator(name = "profesorGenerator",
            parameters = @org.hibernate.annotations.Parameter(name = "prefijo", value = "profesor"),
            strategy = "com.bosonit.DB1EjercicioCRUD.MiGenerador"
    )
    private String idProfesor;

    private String idPersona;

    private String comments;

    @Column(nullable = false)
    private String branch;

    public Profesor(ProfesorInputDTO profesorInputDTO) {
        setIdProfesor(profesorInputDTO.getIdProfesor());
        setIdPersona(profesorInputDTO.getIdPersona());
        setComments(profesorInputDTO.getComments());
        setBranch(profesorInputDTO.getBranch());
    }
}
