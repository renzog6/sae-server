package ar.nex.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import ar.nex.entity.empleado.Vacacion;

public interface VacacionRepository extends JpaRepository<Vacacion, Long> {

    // @Query("SELECT * FROM Vacacion AS v ORDER BY v.fecha DESC")
    // List<Vacacion> findByEmpleado(Empleado empleado);

    // List<Vacacion> findByEmpleadoByOrderByFechaAsc(Empleado empleado);

    @Query("SELECT v FROM Vacacion AS v WHERE v.empleado.idPersona=:id ORDER BY v.fecha ASC")
    List<Vacacion> findByOrderByFechaAsc(long id);

}
