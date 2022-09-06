package com.bosonit.DB1EjercicioCRUD.studentBranch.infraestructure.controller;

import com.bosonit.DB1EjercicioCRUD.studentBranch.application.StudentBranchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/studentBranch")
public class StudentBranchDeleteController {

    @Autowired
    StudentBranchService studentBranchService;

    @DeleteMapping("/branch/{idBranch}")
    public void deleteStudentBranchByIdBranch(@PathVariable String idBranch) {
        studentBranchService.deleteStudentBranchByIdBranch(idBranch);
    }

    @DeleteMapping("/student/{idStudent}")
    public void deleteStudentBranchByIdStudent(@PathVariable String idStudent) {
        studentBranchService.deleteStudentBranchByIdStudent(idStudent);
    }
}
