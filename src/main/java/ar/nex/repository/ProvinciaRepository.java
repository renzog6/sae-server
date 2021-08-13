package ar.nex.repository;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import ar.nex.entity.ubicacion.Provincia;

/**
 *
 * @author Renzo O. Gorosito
 */
@Repository
public interface ProvinciaRepository extends JpaRepository<Provincia, Long> {

}
