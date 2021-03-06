package ar.nex.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ar.nex.entity.ubicacion.Direccion;
import ar.nex.entity.ubicacion.Localidad;
import ar.nex.repository.DireccionRepository;
import ar.nex.repository.LocalidadRepository;

/**
 *
 * @author Renzo O. Gorosito
 */
@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value = "api/ubicacion")
public class UbicacionController {

    @Autowired
    LocalidadRepository localidadRepo;

    @Autowired
    DireccionRepository direccionRepo;

    @GetMapping("/localidad/list")
    public ResponseEntity<List<Localidad>> getAllLocalidades(@RequestParam(required = false) String name) {
        try {
            List<Localidad> lista = new ArrayList<Localidad>();

            if (name == null)
                localidadRepo.findAll().forEach(lista::add);
            // else
            // repository.findByName(name).forEach(lista::add);

            if (lista.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

            return new ResponseEntity<>(lista, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/localidad/{id}")
    public ResponseEntity<Localidad> getLocalidad(@PathVariable("id") long id) {
        try {
            Optional<Localidad> localidad = localidadRepo.findById(id);

            if (localidad.isPresent()) {
                return new ResponseEntity<>(localidad.get(), HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.BAD_GATEWAY);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/direccion/list")
    public ResponseEntity<List<Direccion>> getAllDirecciones(@RequestParam(required = false) String name) {
        try {
            List<Direccion> lista = new ArrayList<Direccion>();

            if (name == null)
                direccionRepo.findAll().forEach(lista::add);
            // else
            // repository.findByName(name).forEach(lista::add);

            if (lista.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

            return new ResponseEntity<>(lista, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/direccion/update/{id}")
    public ResponseEntity<Direccion> updateDireccion(@PathVariable("id") long id, @RequestBody Direccion direccion) {
        Optional<Direccion> data = direccionRepo.findById(id);

        if (data.isPresent()) {
            Direccion _direccion = data.get();
            _direccion.setCalle(direccion.getCalle());
            _direccion.setNumero(direccion.getNumero());
            _direccion.setLocalidad(direccion.getLocalidad());
            _direccion.setInfo(direccion.getInfo());
            return new ResponseEntity<>(direccionRepo.save(_direccion), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_GATEWAY);
        }
    }
}