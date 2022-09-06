package com.bosonit.DB1EjercicioCRUD.student.application;

import com.bosonit.DB1EjercicioCRUD.student.domain.Student;
import com.bosonit.DB1EjercicioCRUD.student.infraestructure.controller.input.StudentInputDTO;
import com.bosonit.DB1EjercicioCRUD.student.infraestructure.controller.output.StudentOutputDTO;
import com.bosonit.DB1EjercicioCRUD.student.infraestructure.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements  StudentService{

    @Autowired
    StudentRepository studentRepository;

    @Override
    public StudentOutputDTO addStudent(StudentInputDTO studentInputDTO) {
        Student student = studentInputDTO.StudentInputDTO(null, null);
        return new StudentOutputDTO(studentRepository.save(student));
    }

    @Override
    public List<StudentOutputDTO> getAllStudents() {
        List<StudentOutputDTO> listaOut = new ArrayList<>();
        for (Student s: studentRepository.findAll()) {
            listaOut.add(new StudentOutputDTO(s));
        }
        return listaOut;
    }

    @Override
    public StudentOutputDTO getStudentById(String idStudent) throws Exception {
        Student student = studentRepository.findById(idStudent).orElse(null);
        if (student == null) {
            throw new Exception("EL ESTUDIANTE NO HA SIDO LOCALIZADO");
        }
        System.out.println("EL ESTUDIANTE ES: " + student.toString());
        return new StudentOutputDTO(student);
    }

    @Override
    public List<StudentOutputDTO> getAllStudentsbyIdProfesor(String idProfesor) {
        List<StudentOutputDTO> outputDTOList = new ArrayList<>();
        for (Student s: studentRepository.findByIdProfesor(idProfesor)) {
            outputDTOList.add(new StudentOutputDTO(s));
        }
        return outputDTOList;
    }

    @Override
    public void deleteStudentByIdStudent(String idStudent) {
        Optional<Student> student = studentRepository.findById(idStudent);
        studentRepository.delete(student.get());
    }

    @Override
    public StudentOutputDTO findByIdPersona(String idPerson) {
        Student student = studentRepository.findByIdPersona(idPerson);
        return new StudentOutputDTO(student);
    }

    @Override
    public void deleteStudentByIdPerson(String idPerson) {
        Student student = studentRepository.findByIdPersona(idPerson);
        studentRepository.delete(student);
    }

}
