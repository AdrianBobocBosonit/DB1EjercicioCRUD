package com.bosonit.DB1EjercicioCRUD.persona.infraestructure.controller.output;

import com.bosonit.DB1EjercicioCRUD.persona.domain.Persona;
import lombok.Data;

import java.util.Date;

@Data
public class PersonaOutputDTO {

    private String id;
    private String usuario;
    private String password;
    private String name;
    private String surname;
    private String companyEmail;
    private String personalEmail;
    private String city;
    private Boolean active;
    private Date createdDate;
    private String imagenUrl;
    private Date TerminationDate;

    public PersonaOutputDTO(Persona persona) {
        setId(persona.getId());
        setUsuario(persona.getUsuario());
        setPassword(persona.getPassword());
        setName(persona.getName());
        setSurname(persona.getSurname());
        setCompanyEmail(persona.getCompanyEmail());
        setPersonalEmail(persona.getPersonalEmail());
        setCity(persona.getCity());
        setActive(persona.getActive());
        setCreatedDate(persona.getCreatedDate());
        setImagenUrl(persona.getImagenUrl());
        setTerminationDate(persona.getTerminationDate());
    }
}
