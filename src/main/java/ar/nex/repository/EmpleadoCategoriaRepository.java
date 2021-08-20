package ar.nex.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ar.nex.entity.empleado.EmpleadoCategoria;

/**
 *
 * @author Renzo O. Gorosito O. Gorosito
 */
@Repository
public interface EmpleadoCategoriaRepository extends JpaRepository<EmpleadoCategoria, Long> {

  Optional<EmpleadoCategoria> findById(long id);

}