package ar.nex.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ar.nex.entity.empleado.EmpleadoPuesto;

/**
 *
 * @author Renzo O. Gorosito O. Gorosito
 */
@Repository
public interface EmpleadoPuestoRepository extends JpaRepository<EmpleadoPuesto, Long> {

  Optional<EmpleadoPuesto> findById(long id);

}