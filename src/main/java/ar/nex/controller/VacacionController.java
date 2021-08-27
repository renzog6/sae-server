package ar.nex.controller;

import static org.springframework.http.HttpHeaders.CONTENT_DISPOSITION;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
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
import org.springframework.web.bind.annotation.RestController;

import ar.nex.entity.empleado.Empleado;
import ar.nex.entity.empleado.Vacacion;
import ar.nex.repository.EmpleadoRepository;
import ar.nex.repository.VacacionRepository;
import ar.nex.service.ExcelService;
import ar.nex.service.PDFService;

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

    @GetMapping("/{idEmpleado}/list")
    public ResponseEntity<List<Vacacion>> getVacacionByEmpleado(@PathVariable("idEmpleado") long id) {
        try {
            List<Vacacion> lista = new ArrayList<Vacacion>();
            lista = vacacionRepo.findByOrderByFechaAsc(id);

            if (lista != null) {
                return new ResponseEntity<>(lista, HttpStatus.OK);
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

        } catch (Exception e) {
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

    @Autowired
    ExcelService excelService;

    @Autowired
    PDFService pdfService;

    @GetMapping("download/{idEmpleado}")
    public ResponseEntity<Resource> downloadFiles(@PathVariable("idEmpleado") long id) {
        try {
            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
            String filename = "Error.xlsx";
            Resource resource = null;// new InputStreamResource(excelService.load(id));

            if (id != -1) {
                List<Vacacion> list = vacacionRepo.findByOrderByFechaAsc(id);
                if (list != null) {
                    resource = new InputStreamResource(excelService.unoToExcel(list));
                    String nombreEmpleado = list.get(0).getEmpleado().getApellido();
                    nombreEmpleado += " " + list.get(0).getEmpleado().getNombre();
                    filename = "Vacaciones_" + nombreEmpleado + "_" + df.format(new Date()) + ".xlsx";
                }
            } else {
                filename = "Empleados_Vacaciones_" + df.format(new Date()) + ".xlsx";
                List<Empleado> list = empleadoRepo.findAll();
                resource = new InputStreamResource(excelService.todosToExcel(list));
            }

            HttpHeaders httpHeaders = new HttpHeaders();
            httpHeaders.add("Access-Control-Expose-Headers", "Content-Disposition");
            httpHeaders.add("Access-Control-Expose-Headers", "File-Name");
            httpHeaders.add("File-Name", filename);
            httpHeaders.add(CONTENT_DISPOSITION, "attachment;filename=" + filename);

            return ResponseEntity.ok().contentType(MediaType.parseMediaType("application/vnd.ms-excel"))
                    .headers(httpHeaders).body(resource);

        } catch (Exception e) {
            System.out.println(e);
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @GetMapping("downloadPDF/{idVacacion}")
    public ResponseEntity<Resource> downloadPDF(@PathVariable("idVacacion") long id) {
        try {
            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
            String filename = "Error.pdf";

            Optional<Vacacion> _vacacion = vacacionRepo.findById(id);
            Vacacion vacacion = _vacacion.get();

            Resource resource = new InputStreamResource(pdfService.getNotificacion(vacacion));
            String nombreEmpleado = vacacion.getEmpleado().getApellido();
            nombreEmpleado += " " + vacacion.getEmpleado().getNombre();
            filename = "Notificacion_Vacaciones_" + nombreEmpleado + "_" + df.format(new Date()) + ".pdf";

            HttpHeaders httpHeaders = new HttpHeaders();
            httpHeaders.add("Access-Control-Expose-Headers", "Content-Disposition");
            httpHeaders.add("Access-Control-Expose-Headers", "File-Name");
            httpHeaders.add("File-Name", filename);
            httpHeaders.add(CONTENT_DISPOSITION, "attachment;filename=" + filename);

            return ResponseEntity.ok().contentType(MediaType.parseMediaType("application/pdf")).headers(httpHeaders)
                    .body(resource);

        } catch (Exception e) {
            System.out.println(e);
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

}
