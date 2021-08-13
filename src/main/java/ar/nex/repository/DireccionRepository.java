package ar.nex.repository;

import ar.nex.entity.ubicacion.Direccion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Renzo O. Gorosito
 */
@Repository
public interface DireccionRepository extends JpaRepository<Direccion, Long> {

}