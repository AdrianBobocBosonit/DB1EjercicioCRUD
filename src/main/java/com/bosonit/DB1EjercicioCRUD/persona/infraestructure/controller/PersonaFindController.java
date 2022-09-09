package com.bosonit.DB1EjercicioCRUD.persona.infraestructure.controller;

import com.bosonit.DB1EjercicioCRUD.persona.application.PersonaService;
import com.bosonit.DB1EjercicioCRUD.persona.domain.Persona;
import com.bosonit.DB1EjercicioCRUD.persona.infraestructure.controller.output.PersonaOutputDTO;
import com.bosonit.DB1EjercicioCRUD.profesor.application.ProfesorService;
import com.bosonit.DB1EjercicioCRUD.student.application.StudentService;
import com.bosonit.DB1EjercicioCRUD.student.domain.Student;
import com.bosonit.DB1EjercicioCRUD.student.infraestructure.controller.output.StudentOutputDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/personas")
public class PersonaFindController {

    @Autowired
    PersonaService personaService;

    @Autowired
    StudentService studentService;

    @Autowired
    ProfesorService profesorService;

    @GetMapping
    public List<PersonaOutputDTO> getPersonas(@RequestParam(required = false) String name, @RequestParam(required = false) String idPersona) throws Exception {
        System.out.println("SI ES NULO DARA NULO, SINO EL NOMBRE QUE NOS DA ES: " + name);
        if ((name != null) && (name.length() >= 6) && (name.length() <= 10)) {
            System.out.println("LLEGA A FINDPERSONASBYNAME");
            return personaService.findByName(name);
        } else if(idPersona != null) {
            List<PersonaOutputDTO> listaSalida = new ArrayList<>();
            listaSalida.add(personaService.findFullByIdPersona(idPersona));
            return  listaSalida;
        } else if (name == null) {
            System.out.println("LLEGA A GETALLPERSONAS");
            return personaService.getAllPersonas();
        } else {
            throw new Exception("Hay cosas mal");
        }
    }

    @GetMapping("/{id}")
    public PersonaOutputDTO getPersonaByID(@PathVariable String id) throws Exception {
        System.out.println("EL ID OBTENIDO ES: " + id);
        if (id == null) {
            throw new Exception("NO HAY ID PASADO");
        }
        return personaService.getPersonaById(id);
    }

    @GetMapping("/full/{idPersona}")
    public PersonaOutputDTO getPersonasFull(@PathVariable String idPersona) {
        System.err.println("DEBERA DE SACAR TODAS LAS PERSONAS YA SEA SIN RELACION O RELACIONADAS A UN PROFESOR O STUDENT");

        return personaService.findFullByIdPersona(idPersona);
    }
}
