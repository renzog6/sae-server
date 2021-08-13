package ar.nex.repository;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import ar.nex.entity.ubicacion.Localidad;

/**
 *
 * @author Renzo O. Gorosito
 */
@Repository
public interface LocalidadRepository extends JpaRepository<Localidad, Long> {

}
