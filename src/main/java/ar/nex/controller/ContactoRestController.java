package ar.nex.controller;

import ar.nex.entity.ubicacion.Contacto;
import ar.nex.repository.ContactoRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Renzo O. Gorosito
 */
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("api/contacto")
public class ContactoRestController {

    @Autowired
    private ContactoRepository repo;

    @GetMapping("/list")
    public List<Contacto> getAll() {

        List<Contacto> list = repo.findAll();

        return list;
    }
}
