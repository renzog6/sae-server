package ar.nex.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ar.nex.entity.ubicacion.Contacto;
import ar.nex.repository.ContactoRepository;

/**
 *
 * @author Renzo O. Gorosito
 */
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("api/contacto")
public class ContactoRestController {

    @Autowired
    private ContactoRepository contactoRepo;

    @GetMapping("/list")
    public List<Contacto> getAll() {

        List<Contacto> list = contactoRepo.findAll();

        return list;
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Contacto> updateContacto(@PathVariable("id") long id, @RequestBody Contacto contacto) {
        Optional<Contacto> data = contactoRepo.findById(id);

        if (data.isPresent()) {
            Contacto _contacto = data.get();
            _contacto.setDato(contacto.getDato());
            return new ResponseEntity<>(contactoRepo.save(_contacto), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_GATEWAY);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<HttpStatus> deleteContacto(@PathVariable("id") long id) {
        try {
            contactoRepo.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
