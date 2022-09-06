package com.bosonit.DB1EjercicioCRUD.profesor.infraestructure.controller;

import com.bosonit.DB1EjercicioCRUD.profesor.application.ProfesorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/profesores")
public class ProfesorDeleteController {

    @Autowired
    ProfesorService profesorService;

    @DeleteMapping("/deleteByIdProfesor/{idProfesor}")
    public String deleteProfesorByIdProfesor(@PathVariable String idProfesor) throws Exception{
        System.out.println("SE VA A BORRAR EL PROFESOR CON EL IDPROFESOR: " + idProfesor);
        profesorService.deleteProfesorByIdProfesor(idProfesor);
        return "Eliminado con exito el profesor con el idProfesor: " + idProfesor;
    }

    @DeleteMapping("/deleteByIdPersona/{idPersona}")
    public String deleteProfesorByIdPersona(@PathVariable String idPersona) throws Exception {
        System.out.println("SE VA A BORRAR EL PROFESOR CON EL IDPERSONA: " + idPersona);
        profesorService.deleteProfesorByIdPersona(idPersona);
        return "Persona con el id " + idPersona + " eliminada con exito";
    }
}
