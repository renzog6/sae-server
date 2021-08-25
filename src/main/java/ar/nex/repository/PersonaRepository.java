package ar.nex.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ar.nex.entity.empleado.Persona;

/**
 *
 * @author Renzo O. Gorosito O. Gorosito
 */
@Repository
public interface PersonaRepository extends JpaRepository<Persona, Long> {

}