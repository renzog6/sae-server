package ar.nex.service;

import ar.nex.entity.ubicacion.Contacto;
import ar.nex.repository.ContactoRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Renzo O. Gorosito
 */
@Service
public class ContactoServiceImpl implements ContactoService {

    @Autowired
    private ContactoRepository contactoRepository;

    public List<Contacto> findAll() {
        List<Contacto> list = new ArrayList<>();
        try {
            list = contactoRepository.findAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

}
