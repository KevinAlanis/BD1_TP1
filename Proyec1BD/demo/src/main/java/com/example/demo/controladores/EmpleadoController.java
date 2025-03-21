package com.example.demo.controladores;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.Services.EmpleadoService;
import com.example.demo.entidades.Empleado;
import java.util.List;

@Controller
public class EmpleadoController {

    private final EmpleadoService empleadoService;

    public EmpleadoController(EmpleadoService empleadoService) {
        this.empleadoService = empleadoService;
    }

    @GetMapping("/empleados")
    public String listarEmpleados(Model model){
        List<Empleado>empleados=empleadoService.obtenerListas();
        model.addAttribute("empleados", empleados);
        return "empleados";
    }
    @GetMapping("/empleados/nuevo")
    public String mostrarFormularioNuevoEmpleado(Model model){
        model.addAttribute("empleado", new Empleado());
        return "nuevoEmpleado";
    }
    @PostMapping("/empleados/guardar")
    public String guardarEmpleado(@ModelAttribute Empleado empleado){
        empleadoService.guardar(empleado);
        return "redirect:/empleados";
    }
}