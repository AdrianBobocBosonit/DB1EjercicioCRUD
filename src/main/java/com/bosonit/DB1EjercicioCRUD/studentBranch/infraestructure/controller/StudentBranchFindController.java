package com.bosonit.DB1EjercicioCRUD.studentBranch.infraestructure.controller;

import com.bosonit.DB1EjercicioCRUD.studentBranch.application.StudentBranchService;
import com.bosonit.DB1EjercicioCRUD.studentBranch.infraestructure.controller.output.StudentBranchOutputDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/studentBranch")
public class StudentBranchFindController {

    @Autowired
    StudentBranchService studentBranchService;

    @GetMapping
    public List<StudentBranchOutputDTO> getAllStudentBranch() {
        return studentBranchService.getAllStudentBranch();
    }

}
