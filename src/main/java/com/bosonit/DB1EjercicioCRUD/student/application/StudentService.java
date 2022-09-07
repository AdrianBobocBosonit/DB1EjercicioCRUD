package com.bosonit.DB1EjercicioCRUD.student.application;

import com.bosonit.DB1EjercicioCRUD.student.infraestructure.controller.input.StudentInputDTO;
import com.bosonit.DB1EjercicioCRUD.student.infraestructure.controller.output.StudentOutputDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface StudentService {
    StudentOutputDTO addStudent(StudentInputDTO studentInputDTO);

    List<StudentOutputDTO> getAllStudents();

    StudentOutputDTO getStudentById(String idStudent) throws Exception;

    StudentOutputDTO findByIdPersona(String idPerson);

    void deleteStudentByIdStudent(String idStudent);

    void deleteStudentByIdPerson(String idPerson);
}
