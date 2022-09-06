package com.bosonit.DB1EjercicioCRUD.student.infraestructure.controller;

import com.bosonit.DB1EjercicioCRUD.student.application.StudentService;
import com.bosonit.DB1EjercicioCRUD.student.infraestructure.controller.output.StudentOutputDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/student")
public class StudentDeleteController {

    @Autowired
    StudentService studentService;

    @DeleteMapping("/deleteByIdStudent/{idStudent}")
    public String deleteStudentByIdStudent(@PathVariable String idStudent) {
        studentService.deleteStudentByIdStudent(idStudent);
        return "El estudiante con el id " + idStudent + " ha sido eliminado satisfactoriamente";
    }

    @DeleteMapping("/deleteByIdPersona/{idPersona}")
    public String deleteStudentByIdPersona(@PathVariable String idPersona) {
        studentService.deleteStudentByIdPerson(idPersona);
        return "El estudiante con el id persona " + idPersona + " ha sido eliminado correctamente";
    }
}
