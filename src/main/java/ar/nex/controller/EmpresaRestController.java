package ar.nex.controller;

import ar.nex.entity.empresa.Empresa;
import ar.nex.service.EmpresaService;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Renzo
 */
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("api/empresa")
public class EmpresaRestController {
    
     @Autowired
     private EmpresaService service;
    
    @GetMapping("/list")
    public List<Empresa> getAll(){
        List<Empresa> list = new ArrayList<>();
        try {
            list = service.getAll();
            System.out.println("ar.nex.controller.api.EmpresaRestController.getAll()>>>>> "+service.getAll().size());
        } catch (Exception e) {
            e.printStackTrace();
        }        
        return list;
    }
    
}
