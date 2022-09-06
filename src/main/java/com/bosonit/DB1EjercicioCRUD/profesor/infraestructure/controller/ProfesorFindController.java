package com.bosonit.DB1EjercicioCRUD.profesor.infraestructure.controller;

import com.bosonit.DB1EjercicioCRUD.profesor.application.ProfesorService;
import com.bosonit.DB1EjercicioCRUD.profesor.infraestructure.controller.output.ProfesorOutputDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/profesores")
public class ProfesorFindController {

    @Autowired
    ProfesorService profesorService;

    @GetMapping("/getByIdPersona/{idPersona}")
    public ProfesorOutputDTO getProfesorByIdPersona(@PathVariable String idPersona) throws Exception {
        System.out.println("ESTE ES EL ID QUE RECIBIMOS: " + idPersona);
        if (idPersona == null) {
            throw new Exception("EL ID ES NULO");
        }
        return profesorService.getByIdPersona(idPersona);
    }

    @GetMapping("/getByIdProfesor/{idProfesor}")
    public ProfesorOutputDTO getProfesorByIdProfesor(@PathVariable String idProfesor) throws Exception {
        System.out.println("ESTE ES EL ID QUE RECIBIMOS: " + idProfesor);
        if (idProfesor == null) {
            throw new Exception("EL ID ES NULO");
        }
        return profesorService.getProfesorByIdProfesor(idProfesor);
    }

    @GetMapping
    public List<ProfesorOutputDTO> getAllProfesores() throws Exception {
        return profesorService.getAllProfesores();
    }
}
