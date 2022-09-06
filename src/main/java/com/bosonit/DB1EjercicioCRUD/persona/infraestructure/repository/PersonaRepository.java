package com.bosonit.DB1EjercicioCRUD.persona.infraestructure.repository;

import com.bosonit.DB1EjercicioCRUD.persona.domain.Persona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonaRepository extends JpaRepository<Persona, String> {
    List<Persona> findPersonaByName(String name);
}
