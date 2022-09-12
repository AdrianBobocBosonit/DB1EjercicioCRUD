package com.bosonit.DB1EjercicioCRUD.student.infraestructure.controller;

import com.bosonit.DB1EjercicioCRUD.student.application.StudentService;
import com.bosonit.DB1EjercicioCRUD.student.infraestructure.controller.input.StudentInputDTO;
import com.bosonit.DB1EjercicioCRUD.student.infraestructure.controller.output.StudentOutputDTO;
import com.bosonit.DB1EjercicioCRUD.studentBranch.application.StudentBranchService;
import com.bosonit.DB1EjercicioCRUD.studentBranch.domain.StudentBranch;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentCreateController {

    @Autowired
    StudentService studentService;

    @Autowired
    StudentBranchService studentBranchService;

    @PostMapping
    public StudentOutputDTO addStudent(@RequestBody StudentInputDTO studentInputDTO) {
        System.out.println("ESTOS SON LOS VALORES QUE NOS HAN LLEGADO: " + studentInputDTO);
        StudentOutputDTO studentDevuelto = studentService.addStudent(studentInputDTO);

        StudentBranch studentBranch = studentBranchService.getStudentBranchById(studentInputDTO.getIdBranch());

        if (studentBranch != null) {
            List<StudentBranch> listaStudentBranch = new ArrayList<>();
            listaStudentBranch.add(studentBranch);
            studentDevuelto.setBranch(listaStudentBranch);
        }

        System.out.println("EL STUDENT DEVUELTO AL FORNTEND SERÍA: " + studentDevuelto.toString());
        return studentDevuelto;
    }

}
