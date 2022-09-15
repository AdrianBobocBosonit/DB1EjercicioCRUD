package com.bosonit.DB1EjercicioCRUD.persona.infraestructure.controller.input;

import com.bosonit.DB1EjercicioCRUD.persona.domain.Persona;
import lombok.*;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class PersonaCORSInputDTO {
    private String id;
    private String usuario;
    private String password;
    private String name;
    private String surname;
    private String company_email;
    private String personal_email;
    private String city;
    private Boolean active;
    private Date created_date;
    private String imagen_url;
    private Date termination_date;


    public Persona PersonaCORSInputDTO() {
        Persona persona = new Persona();
        persona.setIdPerson(this.getId());
        persona.setUsuario(this.getUsuario());
        persona.setPassword(this.getPassword());
        persona.setName(this.getName());
        persona.setSurname(this.getSurname());
        persona.setCompanyEmail(this.getCompany_email());
        persona.setPersonalEmail(this.getPersonal_email());
        persona.setCity(this.getCity());
        persona.setActive(this.getActive());
        persona.setCreatedDate(this.getCreated_date());
        persona.setImagenUrl(this.getImagen_url());
        persona.setTerminationDate(this.getTermination_date());
        return persona;
    }
}
