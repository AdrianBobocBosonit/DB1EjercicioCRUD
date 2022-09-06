package com.bosonit.DB1EjercicioCRUD.studentBranch.infraestructure.repository;

import com.bosonit.DB1EjercicioCRUD.studentBranch.domain.StudentBranch;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentBranchRepository extends JpaRepository<StudentBranch, String> {
    StudentBranch findStudentBranchByIdAsignatura(String idAsignatura);

    StudentBranch findStudentBranchByIdStudent(String idStudent);

    //@Query(value = "delete from student_branch where ", nativeQuery = true)
    //void deleteStudentBranchByIdStudent(Integer idStudent);
}
