package com.bosonit.DB1EjercicioCRUD.persona.infraestructure.controller.output;

import com.bosonit.DB1EjercicioCRUD.profesor.domain.Profesor;
import com.bosonit.DB1EjercicioCRUD.student.domain.Student;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
public class PersonaCORSOutputDTO {
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
    private String created_date;
    private String imagen_url;
    private String termination_date;
}
