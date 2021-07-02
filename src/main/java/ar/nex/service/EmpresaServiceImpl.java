package ar.nex.service;

import ar.nex.entity.empresa.Empresa;
import ar.nex.repository.EmpresaRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Renzo
 */
@Service
public class EmpresaServiceImpl implements EmpresaService {

    @Autowired
    private EmpresaRepository repo;

    @Override
    public List<Empresa> getAll() {
        return repo.findAll();
    }

}
