package com.bosonit.DB1EjercicioCRUD.student.infraestructure.controller;

import com.bosonit.DB1EjercicioCRUD.student.application.StudentService;
import com.bosonit.DB1EjercicioCRUD.student.infraestructure.controller.output.StudentOutputDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentFindController {

    @Autowired
    StudentService studentService;

    @GetMapping
    public List<StudentOutputDTO> getAllStudents() throws Exception {
        return studentService.getAllStudents();
    }

    @GetMapping("/id/{idStudent}")
    public StudentOutputDTO getStudentById(@PathVariable String idStudent) throws Exception{
        return studentService.getStudentById(idStudent);
    }

    @GetMapping("/profesor/{idProfesor}")
    public List<StudentOutputDTO> getAllStudentsByIdProfesor(@PathVariable String idProfesor) {
        return studentService.getAllStudentsbyIdProfesor(idProfesor);
    }

    @GetMapping("/person/{idPerson}")
    public StudentOutputDTO getStudentByIdPersona(@PathVariable String idPerson) {
        return studentService.findByIdPersona(idPerson);
    }
}
