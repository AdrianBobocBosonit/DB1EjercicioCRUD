package com.bosonit.DB1EjercicioCRUD.profesor.infraestructure.controller;

import com.bosonit.DB1EjercicioCRUD.profesor.application.ProfesorService;
import com.bosonit.DB1EjercicioCRUD.profesor.infraestructure.controller.input.ProfesorInputDTO;
import com.bosonit.DB1EjercicioCRUD.profesor.infraestructure.controller.output.ProfesorOutputDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/profesores")
public class ProfesorCreateController {

    @Autowired
    ProfesorService profesorService;

    @PostMapping
    public ProfesorOutputDTO postProfesor(@RequestBody ProfesorInputDTO profesorInputDTO) throws Exception {
        System.out.println("ESTOS SON LOS VALORES QUE NOS HAN LLEGADO: " + profesorInputDTO);
        ProfesorOutputDTO profesorOutputDTO = profesorService.addProfesor(profesorInputDTO);
        System.out.println("A LA HORA DE CREAR EL PROFESOR ASÍ ES COMO QUEDA: " + profesorOutputDTO);
        return profesorOutputDTO;
    }
}
