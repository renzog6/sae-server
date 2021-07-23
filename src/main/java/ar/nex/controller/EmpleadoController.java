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

import ar.nex.entity.empleado.Empleado;
import ar.nex.entity.empleado.PersonaGenero;
import ar.nex.repository.EmpleadoRepository;

/**
 *
 * @author Renzo O. Gorosito
 */
@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value = "api/empleado") //@RequestMapping("api/empleado")
public class EmpleadoController {

  @Autowired
  EmpleadoRepository repository;

  @GetMapping("/list")
  public ResponseEntity<List<Empleado>> getAllEmpleados(@RequestParam(required = false) String name) {
    try {
      List<Empleado> lista = new ArrayList<Empleado>();

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
  public ResponseEntity<Empleado> getEmpleadoById(@PathVariable("id") long id) {
    Optional<Empleado> empleadoData = repository.findById(id);

    if (empleadoData.isPresent()) {
      return new ResponseEntity<>(empleadoData.get(), HttpStatus.OK);
    } else {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
  }

  @PostMapping("/create")
  public ResponseEntity<Empleado> createEmpleado(@RequestBody Empleado empleado) {
    try {
      Empleado _empleado = repository.save(new Empleado()); // .save(new Empleado(empleado.getNombre(),
                                                            // empleado.getApellido(), false));
      return new ResponseEntity<>(_empleado, HttpStatus.CREATED);
    } catch (Exception e) {
      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }

  @PutMapping("/update/{id}")  
  public ResponseEntity<Empleado> updateEmpleado(@PathVariable("id") long id, @RequestBody Empleado empleado) {
    System.out.println("ID::: " + id);
    Optional<Empleado> empleadoData = repository.findById(id);

    if (empleadoData.isPresent()) {
      Empleado _empleado = empleadoData.get();
      _empleado.setNombre(empleado.getNombre());
      _empleado.setApellido(empleado.getApellido());      
      _empleado.setGenero(empleado.getGenero());
      _empleado.setEstadoCivil(empleado.getEstadoCivil());
      _empleado.setDni(empleado.getDni());
      _empleado.setCuil(empleado.getCuil());
      _empleado.setNacimiento(empleado.getNacimiento());
      _empleado.setFechaAlta(empleado.getFechaAlta());
      _empleado.setPuesto(empleado.getPuesto());
      _empleado.setCategoria(empleado.getCategoria());
      return new ResponseEntity<>(repository.save(_empleado), HttpStatus.OK);
    } else {
      return new ResponseEntity<>(HttpStatus.BAD_GATEWAY);
    }
  }

  @DeleteMapping("/delete/{id}")
  public ResponseEntity<HttpStatus> deleteEmpleado(@PathVariable("id") long id) {
    try {
      repository.deleteById(id);
      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    } catch (Exception e) {
      return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }

  @DeleteMapping("/delete")
  public ResponseEntity<HttpStatus> deleteAllEmpleados() {
    try {
      repository.deleteAll();
      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    } catch (Exception e) {
      return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }

  }

}
