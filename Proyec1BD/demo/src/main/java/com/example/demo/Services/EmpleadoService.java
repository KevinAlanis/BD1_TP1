package com.example.demo.Services;

import org.springframework.stereotype.Service;
import com.example.demo.entidades.Empleado;
import com.example.demo.repositorios.EmpleadoRepository;
import java.util.List;

@Service
public class EmpleadoService {

    private final EmpleadoRepository empleadoRepository;

    public EmpleadoService(EmpleadoRepository empleadoRepository) {
        this.empleadoRepository = empleadoRepository;
    }

    public List<Empleado> obtenerListas(){
        return empleadoRepository.findAll();
    }
    public void guardar(Empleado empleado){
        empleadoRepository.save(empleado);
    }
}