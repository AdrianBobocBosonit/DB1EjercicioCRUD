package com.bosonit.DB1EjercicioCRUD.student.infraestructure.repository;

import com.bosonit.DB1EjercicioCRUD.student.domain.Student;
import com.bosonit.DB1EjercicioCRUD.student.infraestructure.controller.output.StudentOutputDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, String> {
    @Query("select s from Student s where s.idProfesor = ?1")
    List<Student> findByIdProfesor(String idProfesor);

    @Query("select s from Student s where s.idPersona = ?1")
    Student findByIdPersona(String idPerson);
}
