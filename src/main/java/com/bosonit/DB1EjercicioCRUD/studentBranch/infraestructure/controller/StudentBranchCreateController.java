package com.bosonit.DB1EjercicioCRUD.studentBranch.infraestructure.controller;

import com.bosonit.DB1EjercicioCRUD.studentBranch.application.StudentBranchService;
import com.bosonit.DB1EjercicioCRUD.studentBranch.infraestructure.controller.input.StudentBranchInputDTO;
import com.bosonit.DB1EjercicioCRUD.studentBranch.infraestructure.controller.output.StudentBranchOutputDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/studentBranch")
public class StudentBranchCreateController {

    @Autowired
    StudentBranchService studentBranchService;

    @PostMapping
    public StudentBranchOutputDTO postStudentBranch(@RequestBody StudentBranchInputDTO studentBranchInputDTO) throws Exception{
        System.err.println("ESTOS SON LOS VALORES QUE NOS HA LLEGADO: " + studentBranchInputDTO);
        StudentBranchOutputDTO studentBranchOutputDTO = studentBranchService.addStudentBranch(studentBranchInputDTO);
        System.err.println("ESTOS SON LOS VALORES CON LOS QUE SE TERMINA GUARDANDO: " + studentBranchOutputDTO);
        return studentBranchOutputDTO;
    }
}
