package com.bosonit.DB1EjercicioCRUD.persona.domain;

import com.bosonit.DB1EjercicioCRUD.persona.infraestructure.controller.input.PersonaInputDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import javax.persistence.*;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "PERSONA")
public class Persona {
    @Id
    @GeneratedValue(generator = "personaGenerator")
    @GenericGenerator(name = "personaGenerator",
            parameters = @Parameter(name = "prefijo", value = "persona"),
            strategy = "com.bosonit.DB1EjercicioCRUD.MiGenerador"
    )
    private String id;

    @Column(length = 10, nullable = false)
    private String usuario;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String name;

    private String surname;

    @Column(nullable = false)
    private String companyEmail;

    @Column(nullable = false)
    private String personalEmail;

    @Column(nullable = false)
    private String city;

    @Column(nullable = false)
    private Boolean active;

    @Column(nullable = false)
    private Date createdDate;

    private String imagenUrl;
    private Date terminationDate;

    public Persona(PersonaInputDTO personaInputDTO) {
        setId(personaInputDTO.getId());
        setCity(personaInputDTO.getCity());
        setActive(personaInputDTO.getActive());
        setCompanyEmail(personaInputDTO.getCompanyEmail());
        setCreatedDate(personaInputDTO.getCreatedDate());
        setPassword(personaInputDTO.getPassword());
        setSurname(personaInputDTO.getSurname());
        setUsuario(personaInputDTO.getUsuario());
        setTerminationDate(personaInputDTO.getTerminationDate());
        setImagenUrl(personaInputDTO.getImagenUrl());
        setPersonalEmail(personaInputDTO.getPersonalEmail());
    }
}
