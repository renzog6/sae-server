package ar.nex.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ar.nex.entity.empleado.EmpleadoCategoria;
import ar.nex.repository.EmpleadoCategoriaRepository;

/**
 *
 * @author Renzo O. Gorosito O. Gorosito
 */
@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value = "api/empleado-categoria") // @RequestMapping("api/item")
public class EmpleadoCategoriaController {

  @Autowired
  EmpleadoCategoriaRepository repository;

  @GetMapping("/list")
  public ResponseEntity<List<EmpleadoCategoria>> getAllEmpleadoCategorias(@RequestParam(required = false) String name) {
    try {
      List<EmpleadoCategoria> lista = new ArrayList<EmpleadoCategoria>();

      if (name == null)
        repository.findAll().forEach(lista::add);
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

  @GetMapping("/{id}")
  public ResponseEntity<EmpleadoCategoria> getEmpleadoCategoriaById(@PathVariable("id") long id) {
    Optional<EmpleadoCategoria> itemData = repository.findById(id);

    if (itemData.isPresent()) {
      return new ResponseEntity<>(itemData.get(), HttpStatus.OK);
    } else {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
  }

  @PostMapping("/create")
  public ResponseEntity<EmpleadoCategoria> createEmpleadoCategoria(@RequestBody EmpleadoCategoria item) {
    try {
      EmpleadoCategoria ec = new EmpleadoCategoria();
      ec.setNombre(item.getNombre());
      ec.setInfo(item.getInfo());
      EmpleadoCategoria _item = repository.save(ec);
      return new ResponseEntity<>(_item, HttpStatus.CREATED);
    } catch (Exception e) {
      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }

  @PutMapping("/update/{id}")
  public ResponseEntity<EmpleadoCategoria> updateEmpleadoCategoria(@PathVariable("id") long id,
      @RequestBody EmpleadoCategoria item) {
    try {
      Optional<EmpleadoCategoria> itemData = repository.findById(id); // .findById(id);
      if (itemData.isPresent()) {
        EmpleadoCategoria _item = itemData.get();
        _item.setNombre(item.getNombre());
        _item.setInfo(item.getInfo());
        return new ResponseEntity<>(repository.save(_item), HttpStatus.OK);
      } else {
        return new ResponseEntity<>(HttpStatus.BAD_GATEWAY);
      }
    } catch (Exception e) {
      return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }

  @DeleteMapping("/delete/{id}")
  public ResponseEntity<String> deleteEmpleadoCategoria(@PathVariable("id") long id) {
    try {
      Optional<EmpleadoCategoria> itemData = repository.findById(id);
      if (itemData.isPresent()) {
        EmpleadoCategoria _item = itemData.get();
        repository.delete(_item);
        return new ResponseEntity<>(HttpStatus.OK);
      } else {
        return new ResponseEntity<>("ITEM::: " + id + " NO exite", HttpStatus.BAD_GATEWAY);
      }
    } catch (Exception e) {
      return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }

  @DeleteMapping("/delete")
  public ResponseEntity<HttpStatus> deleteAllEmpleadoCategorias() {
    try {
      repository.deleteAll();
      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    } catch (Exception e) {
      return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }

  }

}
