package ar.nex.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ar.nex.entity.empleado.Empleado;

/**
 *
 * @author Renzo O. Gorosito
 */
@Repository
public interface EmpleadoRepository extends JpaRepository<Empleado, Long> {

  //  List<Empleado> findByName(String name);
}