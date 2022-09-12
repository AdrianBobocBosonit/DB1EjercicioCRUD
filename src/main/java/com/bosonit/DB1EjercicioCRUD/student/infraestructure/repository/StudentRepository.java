package com.bosonit.DB1EjercicioCRUD.student.infraestructure.repository;

import com.bosonit.DB1EjercicioCRUD.student.domain.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student, String> {

    @Query("select s from Student s where s.persona.idPerson = ?1")
    Student findByIdPersona(String idPerson);
}
