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
import ar.nex.entity.empleado.PersonaEstado;
import ar.nex.entity.empresa.Empresa;
import ar.nex.entity.ubicacion.Contacto;
import ar.nex.repository.ContactoRepository;
import ar.nex.repository.EmpleadoRepository;
import ar.nex.repository.EmpresaRepository;

/**
 *
 * @author Renzo O. Gorosito O. Gorosito
 */
@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value = "api/empleado")
public class EmpleadoController {

  @Autowired
  EmpleadoRepository empleadoRepo;

  @Autowired
  EmpresaRepository empresaSvc;

  @Autowired
  ContactoRepository contactoRepo;

  @GetMapping("/list")
  public ResponseEntity<List<Empleado>> getAllEmpleados(@RequestParam(required = false) String name) {
    try {
      List<Empleado> lista = new ArrayList<Empleado>();

      if (name == null)
        // empleadoRepo.findAll().forEach(lista::add);
        lista = empleadoRepo.findByOrderByApellidoAsc(PersonaEstado.ACTIVO);
      // else
      // empleadoRepo.findByName(name).forEach(lista::add);

      if (lista.isEmpty()) {
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
      }

      return new ResponseEntity<>(lista, HttpStatus.OK);
    } catch (Exception e) {
      System.out.println(e);
      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }

  @GetMapping("/{id}")
  public ResponseEntity<Empleado> getEmpleadoById(@PathVariable("id") long id) {
    Optional<Empleado> empleadoData = empleadoRepo.findById(id);

    if (empleadoData.isPresent()) {
      return new ResponseEntity<>(empleadoData.get(), HttpStatus.OK);
    } else {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
  }

  @PostMapping("/create")
  public ResponseEntity<Empleado> createEmpleado(@RequestBody Empleado empleado) {
    try {
      Empresa _empresa = empresaSvc.findByIdEmpresa((long) 2);
      Empleado newEmpleado = new Empleado();
      newEmpleado.setEmpresa(_empresa);

      newEmpleado.setNombre(empleado.getNombre());
      newEmpleado.setApellido(empleado.getApellido());

      newEmpleado.setNacimiento(empleado.getNacimiento());
      newEmpleado.setDni(empleado.getDni());

      newEmpleado.setGenero(empleado.getGenero());
      newEmpleado.setEstadoCivil(empleado.getEstadoCivil());

      newEmpleado.setFechaAlta(empleado.getFechaAlta());
      newEmpleado.setCuil(empleado.getCuil());

      if (empleado.getDomicilio() != null) {
        newEmpleado.setDomicilio(empleado.getDomicilio());
      }

      newEmpleado.setContactoList(new ArrayList<Contacto>());

      newEmpleado.setCategoria(empleado.getCategoria());
      newEmpleado.setPuesto(empleado.getPuesto());

      newEmpleado.setInfo(empleado.getInfo());
      newEmpleado.setEstado(PersonaEstado.ACTIVO);

      Empleado _empleado = empleadoRepo.save(newEmpleado);

      if (empleado.getContactoList() != null) {
        for (Contacto con : empleado.getContactoList()) {
          Contacto _con = new Contacto(con.getNombre());
          _con.setTipo(con.getTipo());
          _con.setDato(con.getDato());
          _con.setInfo(con.getInfo());
          _con.setPersona(_empleado);
          _empleado.getContactoList().add(_con);
          empleadoRepo.save(_empleado);
        }

      }

      return new ResponseEntity<>(_empleado, HttpStatus.CREATED);
    } catch (Exception e) {
      System.out.println(e);
      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }

  @PutMapping("/update/{id}")
  public ResponseEntity<Empleado> updateEmpleado(@PathVariable("id") long id, @RequestBody Empleado empleado) {
    Optional<Empleado> empleadoData = empleadoRepo.findById(id);

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
      return new ResponseEntity<>(empleadoRepo.save(_empleado), HttpStatus.OK);
    } else {
      return new ResponseEntity<>(HttpStatus.BAD_GATEWAY);
    }
  }

  @PutMapping("/darBaja")
  public ResponseEntity<Empleado> darBajaEmpleado(@RequestBody Empleado empleado) {
    Optional<Empleado> empleadoData = empleadoRepo.findById(empleado.getIdPersona());

    if (empleadoData.isPresent()) {
      Empleado _empleado = empleadoData.get();
      _empleado.setFechaBaja(empleado.getFechaBaja());
      _empleado.setInfo(empleado.getInfo());
      _empleado.setEstado(PersonaEstado.BAJA);

      return new ResponseEntity<>(empleadoRepo.save(_empleado), HttpStatus.OK);
    } else {
      return new ResponseEntity<>(HttpStatus.BAD_GATEWAY);
    }
  }

  @DeleteMapping("/delete/{id}")
  public ResponseEntity<HttpStatus> deleteEmpleado(@PathVariable("id") long id) {
    try {
      empleadoRepo.deleteById(id);
      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    } catch (Exception e) {
      return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }

  /*
   * @DeleteMapping("/delete") public ResponseEntity<HttpStatus>
   * deleteAllEmpleados() { try { empleadoRepo.deleteAll(); return new
   * ResponseEntity<>(HttpStatus.NO_CONTENT); } catch (Exception e) { return new
   * ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR); }
   * 
   * }
   */

}
