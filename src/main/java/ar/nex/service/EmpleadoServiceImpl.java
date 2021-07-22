package ar.nex.service;

import java.util.List;

import org.springframework.stereotype.Service;

import ar.nex.entity.empleado.Empleado;

/**
 *
 * @author Renzo
 */
@Service
public class EmpleadoServiceImpl implements EmpleadoService {
    
    List<Empleado> findByName(String name){
        return null;
    }
}
