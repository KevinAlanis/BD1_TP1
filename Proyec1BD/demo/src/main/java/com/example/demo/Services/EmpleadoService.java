package com.example.demo.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.entidades.Empleado;
import com.example.demo.repositorios.EmpleadoRepository;
import org.springframework.transaction.annotation.Transactional;



import java.util.List;

@Service
public class EmpleadoService {

    @Autowired
    private final EmpleadoRepository empleadoRepository;

    public EmpleadoService(EmpleadoRepository empleadoRepository) {
        this.empleadoRepository = empleadoRepository;
    }

    @Transactional
    public List<Empleado> obtenerListaAscendente(){
        return empleadoRepository.sp_ObtenerEmpleadosOrdenados();
    }

    @Transactional
    public List<Empleado> obtenerListaDescendente(){
        return empleadoRepository.sp_ObtenerEmpleadosOrdenadosDesc();
    }

    @Transactional
    public int guardar(Empleado empleado) {

        return empleadoRepository.sp_InsertarEmpleado(empleado.getNombre(), empleado.getSalario());
    }
    

}
