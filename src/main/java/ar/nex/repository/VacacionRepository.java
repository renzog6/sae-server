package ar.nex.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ar.nex.entity.empleado.Vacacion;

public interface VacacionRepository extends JpaRepository<Vacacion, Long> {

}
