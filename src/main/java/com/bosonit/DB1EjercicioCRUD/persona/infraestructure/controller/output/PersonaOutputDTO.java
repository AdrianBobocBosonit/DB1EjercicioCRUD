package com.bosonit.DB1EjercicioCRUD.persona.infraestructure.controller.output;

import com.bosonit.DB1EjercicioCRUD.persona.domain.Persona;
import com.bosonit.DB1EjercicioCRUD.profesor.domain.Profesor;
import com.bosonit.DB1EjercicioCRUD.student.domain.Student;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
public class PersonaOutputDTO {

    private String id;
    private String usuario;
    private Student student;
    private Profesor profesor;
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

    public PersonaOutputDTO(Persona persona) {
        setId(persona.getIdPerson());
        setUsuario(persona.getUsuario());
        setPassword(persona.getPassword());
        setName(persona.getName());
        setSurname(persona.getSurname());
        setCompany_email(persona.getCompanyEmail());
        setPersonal_email(persona.getPersonalEmail());
        setCity(persona.getCity());
        setActive(persona.getActive());
        setCreated_date(persona.getCreatedDate());
        setImagen_url(persona.getImagenUrl());
        setTermination_date(persona.getTerminationDate());
    }

    public PersonaOutputDTO(Persona persona, Profesor profesor) {
        setId(persona.getIdPerson());
        setUsuario(persona.getUsuario());
        setPassword(persona.getPassword());
        setName(persona.getName());
        setSurname(persona.getSurname());
        setCompany_email(persona.getCompanyEmail());
        setPersonal_email(persona.getPersonalEmail());
        setCity(persona.getCity());
        setActive(persona.getActive());
        setCreated_date(persona.getCreatedDate());
        setImagen_url(persona.getImagenUrl());
        setTermination_date(persona.getTerminationDate());
        setProfesor(profesor);
        setStudent(null);
    }

    public PersonaOutputDTO(Persona persona, Student student) {
        setId(persona.getIdPerson());
        setUsuario(persona.getUsuario());
        setPassword(persona.getPassword());
        setName(persona.getName());
        setSurname(persona.getSurname());
        setCompany_email(persona.getCompanyEmail());
        setPersonal_email(persona.getPersonalEmail());
        setCity(persona.getCity());
        setActive(persona.getActive());
        setCreated_date(persona.getCreatedDate());
        setImagen_url(persona.getImagenUrl());
        setTermination_date(persona.getTerminationDate());
        setStudent(student);
        setProfesor(null);
    }
}
