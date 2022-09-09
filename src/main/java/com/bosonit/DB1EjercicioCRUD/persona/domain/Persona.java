package com.bosonit.DB1EjercicioCRUD.persona.domain;

import com.bosonit.DB1EjercicioCRUD.persona.infraestructure.controller.input.PersonaInputDTO;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@ToString
@Table(name = "PERSONA")
public class Persona {
    @Id
    @GeneratedValue(generator = "personaGenerator")
    @GenericGenerator(name = "personaGenerator",
            parameters = @Parameter(name = "prefijo", value = "persona"),
            strategy = "com.bosonit.DB1EjercicioCRUD.MiGenerador"
    )
    private String idPerson;

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
        setIdPerson(personaInputDTO.getId());
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
