package com.bosonit.DB1EjercicioCRUD.persona.infraestructure.controller;

import com.bosonit.DB1EjercicioCRUD.persona.application.PersonaService;
import com.bosonit.DB1EjercicioCRUD.persona.infraestructure.controller.input.PersonaInputDTO;
import com.bosonit.DB1EjercicioCRUD.persona.infraestructure.controller.output.PersonaOutputDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/personas")
public class PersonaCreateController {

    @Autowired
    PersonaService personaService;

    @PostMapping
    public PersonaOutputDTO postPersona(@RequestBody PersonaInputDTO personaInputDTO) throws Exception {
        System.out.println("ESTOS SON LOS VALORES QUE NOS HA LLEGADO: " + personaInputDTO);
        return personaService.addPersona(personaInputDTO);
    }
}


