package com.bosonit.DB1EjercicioCRUD.studentBranch.application;

import com.bosonit.DB1EjercicioCRUD.studentBranch.infraestructure.controller.input.StudentBranchInputDTO;
import com.bosonit.DB1EjercicioCRUD.studentBranch.infraestructure.controller.output.StudentBranchOutputDTO;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface StudentBranchService {

    StudentBranchOutputDTO addStudentBranch(StudentBranchInputDTO studentBranchInputDTO) throws Exception;

    List<StudentBranchOutputDTO> getAllStudentBranch();

    void deleteStudentBranchByIdBranch(String idBranch);

}
