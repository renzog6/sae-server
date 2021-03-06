package ar.nex.repository;

import ar.nex.entity.empresa.Empresa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Renzo O. Gorosito
 */
@Repository
public interface EmpresaRepository extends JpaRepository<Empresa, Long> {

    Empresa findByIdEmpresa(Long idEmpresa);

}
