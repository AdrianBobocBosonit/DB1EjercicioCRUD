package com.bosonit.DB1EjercicioCRUD.persona.infraestructure.controller.input;

import com.bosonit.DB1EjercicioCRUD.persona.domain.Persona;
import lombok.Data;

import java.util.Date;

@Data
public class PersonaInputDTO {

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

    public Persona PersonaInputDTO() {
        Persona persona = new Persona();
        persona.setIdPerson(this.getId());
        persona.setUsuario(this.getUsuario());
        persona.setPassword(this.getPassword());
        persona.setName(this.getName());
        persona.setSurname(this.getSurname());
        persona.setCompanyEmail(this.getCompanyEmail());
        persona.setPersonalEmail(this.getPersonalEmail());
        persona.setCity(this.getCity());
        persona.setActive(this.getActive());
        persona.setCreatedDate(this.getCreatedDate());
        persona.setImagenUrl(this.getImagenUrl());
        persona.setTerminationDate(this.getTerminationDate());
        return persona;
    }
}
