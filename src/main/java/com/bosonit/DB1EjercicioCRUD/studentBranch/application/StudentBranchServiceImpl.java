package com.bosonit.DB1EjercicioCRUD.studentBranch.application;

import com.bosonit.DB1EjercicioCRUD.studentBranch.domain.StudentBranch;
import com.bosonit.DB1EjercicioCRUD.studentBranch.infraestructure.controller.input.StudentBranchInputDTO;
import com.bosonit.DB1EjercicioCRUD.studentBranch.infraestructure.controller.output.StudentBranchOutputDTO;
import com.bosonit.DB1EjercicioCRUD.studentBranch.infraestructure.repository.StudentBranchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentBranchServiceImpl implements StudentBranchService{

    @Autowired
    private StudentBranchRepository studentBranchRepository;
    @Override
    public StudentBranchOutputDTO addStudentBranch(StudentBranchInputDTO studentBranchInputDTO) throws Exception {
        StudentBranch studentBranch = studentBranchInputDTO.studentBranchInputDTO();
        return new StudentBranchOutputDTO(studentBranchRepository.save(studentBranch));
    }

    @Override
    public List<StudentBranchOutputDTO> getAllStudentBranch() {
        List<StudentBranchOutputDTO> outputDTOList = new ArrayList<>();
        for (StudentBranch s: studentBranchRepository.findAll()) {
            outputDTOList.add(new StudentBranchOutputDTO(s));
        }
        return outputDTOList;
    }

    @Override
    public StudentBranchOutputDTO getStudentBranchByIdBranch(String idBranch) {
        return new StudentBranchOutputDTO(studentBranchRepository.findStudentBranchByIdAsignatura(idBranch));
    }

    @Override
    public StudentBranchOutputDTO getStudentBranchByIdStudent(String idStudent) {
        return new StudentBranchOutputDTO(studentBranchRepository.findStudentBranchByIdStudent(idStudent));
    }

    @Override
    public void deleteStudentBranchByIdBranch(String idBranch) {
        studentBranchRepository.deleteById(idBranch);
    }

    @Override
    public void deleteStudentBranchByIdStudent(String idStudent) {
        StudentBranch studentBranch = studentBranchRepository.findStudentBranchByIdStudent(idStudent);
        studentBranchRepository.delete(studentBranch);
    }


}
