package ar.nex.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import ar.nex.entity.empleado.Empleado;
import ar.nex.entity.empleado.PersonaEstado;

/**
 *
 * @author Renzo O. Gorosito O. Gorosito
 */
@Repository
public interface EmpleadoRepository extends JpaRepository<Empleado, Long> {

  // List<Empleado> findByName(String name);
  Optional<Empleado> findByIdPersona(long id);

  @Query("SELECT e FROM Empleado AS e WHERE e.estado=:estado ORDER BY e.apellido ASC")
  List<Empleado> findByOrderByApellidoAsc(PersonaEstado estado);
}