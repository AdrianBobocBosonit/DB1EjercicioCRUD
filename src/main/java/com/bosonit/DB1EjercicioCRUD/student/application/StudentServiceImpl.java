package com.bosonit.DB1EjercicioCRUD.student.application;

import com.bosonit.DB1EjercicioCRUD.exceptions.EntityNotFoundException;
import com.bosonit.DB1EjercicioCRUD.exceptions.UnprocessableEntityException;
import com.bosonit.DB1EjercicioCRUD.persona.domain.Persona;
import com.bosonit.DB1EjercicioCRUD.persona.infraestructure.repository.PersonaRepository;
import com.bosonit.DB1EjercicioCRUD.profesor.domain.Profesor;
import com.bosonit.DB1EjercicioCRUD.profesor.infraestructure.repository.ProfesorRepository;
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
    @Autowired
    PersonaRepository personaRepository;

    @Autowired
    ProfesorRepository profesorRepository;

    @Override
    public StudentOutputDTO addStudent(StudentInputDTO studentInputDTO) {
        System.out.println("ESTE ES EL STUDENTINPUTDTOP QUE NOS LLEGA: " + studentInputDTO.toString());
        System.out.println("ESTE ES EL ID QUE NOS LLEGA Y PASAMOS PARA BUSCAR: " + studentInputDTO.getIdPersona());
        Persona persona = personaRepository.findById(studentInputDTO.getIdPersona()).orElse(null);
        if (persona == null) {
            throw new EntityNotFoundException("LA PERSONA A ASIGNAR NO EXISTE", 404);
        }
        System.out.println("ESTA ES LA PERSONA QUE NOS LLEGA: " + persona);

        Profesor profesor = profesorRepository.findById(studentInputDTO.getIdProfesor()).orElse(null);
        if (profesor == null) {
            throw new EntityNotFoundException("EL PROFESOR A A SIGNAR NO EXISTE", 404);
        }
        System.out.println("ESTE ES EL PROFESOR QUE NOS LLEGA: " + profesor);
        Student student = studentInputDTO.StudentInputDTO(persona, profesor);

        if (profesorRepository.findProfesorByIdPersona(studentInputDTO.getIdPersona()) != null) {
            throw new UnprocessableEntityException("LA PERSONA QUE SE ESTA INTENTANDO ASIGNAR ES UN PROFESOR", 422);
        }

        student.setPersona(persona);
        student.setProfesor(profesor);

        System.out.println("##################################################");
        System.out.println("ESTE ES EL STUDENT FINAL: " + student);
        System.out.println("##################################################");
        return new StudentOutputDTO(studentRepository.save(student));
    }

    @Override
    public List<StudentOutputDTO> getAllStudents() {
        System.err.println("ENTRO AL METODO DE LA IMPLEMENTACION");
        List<StudentOutputDTO> listaOut = new ArrayList<>();
        System.err.println("CREO LA LISTA");
        for (Student s: studentRepository.findAll()) {
            System.err.println("ANIADO LAS COSAS A LA LISTA");
            listaOut.add(new StudentOutputDTO(s));
        }
        System.err.println("ESTA ES LA LISTAOUT: " + listaOut);
        return listaOut;
    }

    @Override
    public StudentOutputDTO getStudentById(String idStudent) throws Exception {
        Student student = studentRepository.findById(idStudent).orElse(null);
        if (student == null) {
            throw new Exception("EL ESTUDIANTE NO HA SIDO LOCALIZADO");
        }
        System.out.println("EL ESTUDIANTE ES: " + student);
        return new StudentOutputDTO(student);
    }

    @Override
    public StudentOutputDTO findByIdPersona(String idPerson) {
        Student student = studentRepository.findByIdPersona(idPerson);
        return new StudentOutputDTO(student);
    }

    @Override
    public void deleteStudentByIdStudent(String idStudent) {
        Optional<Student> student = studentRepository.findById(idStudent);
        studentRepository.delete(student.get());
    }

    @Override
    public void deleteStudentByIdPerson(String idPerson) {
        Student student = studentRepository.findByIdPersona(idPerson);
        studentRepository.delete(student);
    }

}
