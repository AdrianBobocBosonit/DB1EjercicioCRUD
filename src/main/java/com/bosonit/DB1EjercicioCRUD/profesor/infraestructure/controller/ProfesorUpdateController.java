package com.bosonit.DB1EjercicioCRUD.profesor.infraestructure.controller;

import com.bosonit.DB1EjercicioCRUD.profesor.application.ProfesorService;
import com.bosonit.DB1EjercicioCRUD.profesor.infraestructure.controller.output.ProfesorOutputDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/profesores")
public class ProfesorUpdateController {

    @Autowired
    ProfesorService profesorService;

    @PutMapping
    public ProfesorOutputDTO updateProfesor(@RequestParam String idProfesor, String branch) throws Exception {
        return profesorService.updateProfesorByIdProfesor(idProfesor, branch);
    }
}
