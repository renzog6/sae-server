package ar.nex.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import ar.nex.entity.empleado.Empleado;
import ar.nex.entity.empleado.Vacacion;
import ar.nex.repository.EmpleadoRepository;
import ar.nex.repository.PersonaRepository;
import ar.nex.repository.VacacionRepository;

import org.json.JSONArray;
import org.json.JSONObject;

/**
 *
 * @author Renzo O. Gorosito
 */
@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value = "api/empleado/vacacion")
public class VacacionController {

    @Autowired
    private EmpleadoRepository empleadoRepo;

    @Autowired
    private VacacionRepository vacacionRepo;

    @GetMapping("/{idEmpleado}")
    public ResponseEntity<List<Vacacion>> getVacacionByEmpleado(@PathVariable("idEmpleado") long id) {
        try {
            /*
             * List<Vacacion> lista = new ArrayList<Vacacion>(); lista =
             * vacacionRepo.findAll(); System.out.println(lista);
             */
            Optional<Empleado> empleadoData = empleadoRepo.findById(id);

            if (empleadoData.isPresent()) {
                Empleado empleado = empleadoData.get();
                return new ResponseEntity<>(empleado.getVacaciones(), HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }

        } catch (Exception e) {
            System.out.println(e);
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/{idEmpleado}/create")
    public ResponseEntity<Vacacion> create(@PathVariable("idEmpleado") long idEmpleado,
            @RequestBody Vacacion vacacion) {
        try {
            System.out.println("ID::::: " + idEmpleado);
            Optional<Empleado> _empleado = empleadoRepo.findByIdPersona(idEmpleado);
            if (_empleado.get().getVacaciones() == null) {
                System.out.println("esnull");
            }

            Vacacion newVacacion = new Vacacion();
            newVacacion.setEmpleado(_empleado.get());
            newVacacion.setFecha(vacacion.getFecha());
            newVacacion.setDetalle(vacacion.getDetalle());
            newVacacion.setDias(vacacion.getDias());
            newVacacion.setAnio(vacacion.getAnio());
            newVacacion.setFechaToma(vacacion.getFechaToma());
            newVacacion.setFechaLiquida(vacacion.getFechaLiquida());
            newVacacion.setInfo(vacacion.getInfo());

            Date ya = new Date();
            newVacacion.setCreated(ya);
            newVacacion.setUpdated(ya);

            Vacacion _vacacion = vacacionRepo.save(newVacacion);

            return new ResponseEntity<>(_vacacion, HttpStatus.CREATED);
        } catch (Exception e) {
            System.out.println("ID::::: " + idEmpleado);
            System.out.println(e);
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Vacacion> update(@PathVariable("id") long id, @RequestBody Vacacion vacacion) {

        Optional<Vacacion> vacacionData = vacacionRepo.findById(id);

        if (vacacionData.isPresent()) {
            Vacacion _vacacion = vacacionData.get();

            return new ResponseEntity<>(vacacionRepo.save(_vacacion), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_GATEWAY);
        }
    }

    @GetMapping(value = "/diasDisponibles")
    public ResponseEntity<?> getDias() {
        try {
            List<Empleado> lista = new ArrayList<Empleado>();
            empleadoRepo.findAll().forEach(lista::add);

            JSONArray array = new JSONArray();
            // List<JSONObject> array = new ArrayList<JSONObject>();
            // Map<String, Object> body = new HashMap<>();

            if (!lista.isEmpty()) {

                for (Empleado empleado : lista) {

                    int dias = 0;
                    if (empleado.getVacaciones() != null) {
                        for (Vacacion v : empleado.getVacaciones()) {
                            dias += v.getDias();
                        }
                    }
                    JSONObject item = new JSONObject();
                    item.put("id", empleado.getIdPersona());
                    item.put("dias", dias);
                    array.put(item);

                }
                return new ResponseEntity<>(array.toString(), HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }

        } catch (

        Exception e) {
            System.out.println(e);
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<HttpStatus> delete(@PathVariable("id") long id) {
        try {
            vacacionRepo.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            System.out.println(e);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
