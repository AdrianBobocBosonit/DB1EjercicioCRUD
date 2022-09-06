package com.bosonit.DB1EjercicioCRUD.persona.infraestructure.controller;

import com.bosonit.DB1EjercicioCRUD.persona.application.PersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/personas")
public class PersonaDeleteController {

    @Autowired
    PersonaService personaService;

    @DeleteMapping("/{id}")
    public String deletePersonaById(@PathVariable String id) {
        System.out.println("SE VA A BORRAR LA PERSONA CON EL ID NUMERO: " + id);
        personaService.deletePersonaById(id);
        return "Persona con el id " + id + " eliminada con exito";
    }
}
