package com.bosonit.DB1EjercicioCRUD.studentBranch.application;

import com.bosonit.DB1EjercicioCRUD.studentBranch.domain.StudentBranch;
import com.bosonit.DB1EjercicioCRUD.studentBranch.infraestructure.controller.input.StudentBranchInputDTO;
import com.bosonit.DB1EjercicioCRUD.studentBranch.infraestructure.controller.output.StudentBranchOutputDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface StudentBranchService {

    @Autowired

    StudentBranchOutputDTO addStudentBranch(StudentBranchInputDTO studentBranchInputDTO) throws Exception;

    List<StudentBranchOutputDTO> getAllStudentBranch();

    void deleteStudentBranchByIdBranch(String idBranch);

    StudentBranch getStudentBranchById(String idBranch);

}
