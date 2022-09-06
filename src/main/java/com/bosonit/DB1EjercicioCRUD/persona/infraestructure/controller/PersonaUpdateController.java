package com.bosonit.DB1EjercicioCRUD.persona.infraestructure.controller;

import com.bosonit.DB1EjercicioCRUD.persona.application.PersonaService;
import com.bosonit.DB1EjercicioCRUD.persona.infraestructure.controller.output.PersonaOutputDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/personas")
public class PersonaUpdateController {

    @Autowired
    PersonaService personaService;

    @PutMapping
    public PersonaOutputDTO updatePersonaById(@RequestParam String id, @RequestParam String password) throws Exception {
        return personaService.updatePersonaById(id, password);
    }
}
