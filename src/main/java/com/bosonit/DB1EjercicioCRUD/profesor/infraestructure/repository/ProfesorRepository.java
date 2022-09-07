package com.bosonit.DB1EjercicioCRUD.profesor.infraestructure.repository;

import com.bosonit.DB1EjercicioCRUD.profesor.domain.Profesor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfesorRepository extends JpaRepository<Profesor, String> {
    @Query("select p from Profesor p where p.persona.idPerson = ?1")
    Profesor findProfesorByIdPersona(String idPersona);

    @Query("delete from Profesor p where p.persona.idPerson = ?1")
    void deleteProfesorByIdPersona(String idPersona);
}
