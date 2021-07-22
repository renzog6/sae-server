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

import ar.nex.entity.empleado.EmpleadoPuesto;
import ar.nex.repository.EmpleadoPuestoRepository;

/**
 *
 * @author Renzo O. Gorosito
 */
@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value = "api/empleado-puesto") // @RequestMapping("api/item")
public class EmpleadoPuestoController {

  @Autowired
  EmpleadoPuestoRepository repository;

  @GetMapping("/list")
  public ResponseEntity<List<EmpleadoPuesto>> getAllEmpleadoPuestos(@RequestParam(required = false) String name) {
    try {
      List<EmpleadoPuesto> lista = new ArrayList<EmpleadoPuesto>();

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
  public ResponseEntity<EmpleadoPuesto> getEmpleadoPuestoById(@PathVariable("id") long id) {
    Optional<EmpleadoPuesto> itemData = repository.findById(id);

    if (itemData.isPresent()) {
      return new ResponseEntity<>(itemData.get(), HttpStatus.OK);
    } else {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
  }

  @PostMapping("/create")
  public ResponseEntity<EmpleadoPuesto> createEmpleadoPuesto(@RequestBody EmpleadoPuesto item) {
    try {
      EmpleadoPuesto puesto = new EmpleadoPuesto();      
      puesto.setNombre(item.getNombre());
      puesto.setInfo(item.getInfo());
      EmpleadoPuesto _item = repository.save(puesto);
      return new ResponseEntity<>(_item, HttpStatus.CREATED);
    } catch (Exception e) {
      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }

  @PutMapping("/update/{id}")
  public ResponseEntity<EmpleadoPuesto> updateEmpleadoPuesto(@PathVariable("id") long id, @RequestBody EmpleadoPuesto item) {
    try {
      Optional<EmpleadoPuesto> itemData = repository.findById(id);
      if (itemData.isPresent()) {
        EmpleadoPuesto _item = itemData.get();
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
  public ResponseEntity<String> deleteEmpleadoPuesto(@PathVariable("id") long id) {
    try {
      Optional<EmpleadoPuesto> itemData = repository.findById(id);      
      if (itemData.isPresent()) {
        EmpleadoPuesto _item = itemData.get();
        repository.delete(_item);
        return new ResponseEntity<>(HttpStatus.OK);
      } else {
        return new ResponseEntity<>("ITEM::: "+id+" NO exite",HttpStatus.BAD_GATEWAY);
      }
    } catch (Exception e) {
      return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }

  @DeleteMapping("/delete")
  public ResponseEntity<HttpStatus> deleteAllEmpleadoPuestos() {
    try {
      repository.deleteAll();
      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    } catch (Exception e) {
      return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }

  }

}
