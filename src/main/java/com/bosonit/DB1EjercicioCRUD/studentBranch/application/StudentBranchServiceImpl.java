package com.bosonit.DB1EjercicioCRUD.studentBranch.application;

import com.bosonit.DB1EjercicioCRUD.exceptions.EntityNotFoundException;
import com.bosonit.DB1EjercicioCRUD.profesor.domain.Profesor;
import com.bosonit.DB1EjercicioCRUD.profesor.infraestructure.repository.ProfesorRepository;
import com.bosonit.DB1EjercicioCRUD.student.infraestructure.repository.StudentRepository;
import com.bosonit.DB1EjercicioCRUD.studentBranch.domain.StudentBranch;
import com.bosonit.DB1EjercicioCRUD.studentBranch.infraestructure.controller.input.StudentBranchInputDTO;
import com.bosonit.DB1EjercicioCRUD.studentBranch.infraestructure.controller.output.StudentBranchOutputDTO;
import com.bosonit.DB1EjercicioCRUD.studentBranch.infraestructure.repository.StudentBranchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class StudentBranchServiceImpl implements StudentBranchService{

    @Autowired
    private StudentBranchRepository studentBranchRepository;

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private ProfesorRepository profesorRepository;

    @Override
    public StudentBranchOutputDTO addStudentBranch(StudentBranchInputDTO studentBranchInputDTO) {
        System.err.println("ESTE ES EL ID ESTUDIANTE QUE NOS LLEGA A LA IMPLEMENTACION: " +studentBranchInputDTO.getIdProfesor());

        Optional<Profesor> profesor = profesorRepository.findById(studentBranchInputDTO.getIdProfesor());

        //System.err.println("ESTE ES EL ID ESTUDIANTE QUE NOS LLEGA A LA IMPLEMENTACION: " +studentBranchInputDTO.getIdStudent());

        //List<Student> student;

        //System.err.println("CREO EL ESTUDIANTE");

        //student = studentRepository.findByIdBranch(studentBranchInputDTO.getIdStudent());

        System.err.println("HAGO LA BUSQUEDA, ESTO RESULTA EN: " + studentBranchInputDTO);

       // System.err.println("ESTO ES LO QUE MIDE LA LISTA DE ESTUDIANTES: " +    student.size());
        //System.err.println("ESTA ES LA LISTA QUE SE QUEDA TRAS LA BUSQUEDA: ");
        /*for (Student s: student) {
            System.out.println(s.toString());
        }*/


        if (profesor.isPresent()) {
            StudentBranch studentBranch = studentBranchInputDTO.studentBranchInputDTO(profesor.get());
            studentBranchRepository.save(studentBranch);
            return new StudentBranchOutputDTO(studentBranchRepository.save(studentBranch));
        } else {
            throw new EntityNotFoundException("DICHA ASIGNATURA NO HA SIDO POSIBLE ENCONTRARLA", 404);
        }


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
    public void deleteStudentBranchByIdBranch(String idBranch) {
        studentBranchRepository.deleteById(idBranch);
    }

    @Override
    public StudentBranch getStudentBranchById(String idBranch) {
        Optional<StudentBranch> studentBranch =  studentBranchRepository.findById(idBranch);
        if (studentBranch.isPresent()) {
            return studentBranch.get();
        } else {
            throw new EntityNotFoundException("DICHA ASIGNATURA NO HA SIDO POSIBLE ENCONTRAR", 404);
        }
    }
}
