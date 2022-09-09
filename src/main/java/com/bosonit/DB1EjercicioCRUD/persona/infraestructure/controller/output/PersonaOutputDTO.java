package com.bosonit.DB1EjercicioCRUD.persona.infraestructure.controller.output;

import com.bosonit.DB1EjercicioCRUD.persona.domain.Persona;
import com.bosonit.DB1EjercicioCRUD.profesor.domain.Profesor;
import com.bosonit.DB1EjercicioCRUD.student.domain.Student;
import lombok.Data;

import java.util.Date;

@Data
public class PersonaOutputDTO {

    private String id;
    private String usuario;
    private Student student;
    private Profesor profesor;
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
        setId(persona.getIdPerson());
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

    public PersonaOutputDTO(Persona persona, Profesor profesor) {
        setId(persona.getIdPerson());
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
        setProfesor(profesor);
        setStudent(null);
    }

    public PersonaOutputDTO(Persona persona, Student student) {
        setId(persona.getIdPerson());
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
        setStudent(student);
        setProfesor(null);
    }
}
