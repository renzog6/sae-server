package ar.nex.repository;

import ar.nex.entity.ubicacion.Contacto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Renzo O. Gorosito
 */
@Repository
public interface ContactoRepository extends JpaRepository<Contacto, Long> {

}
