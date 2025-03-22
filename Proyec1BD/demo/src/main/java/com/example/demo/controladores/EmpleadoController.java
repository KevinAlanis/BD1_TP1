package com.example.demo.controladores;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
public String listarEmpleados(@RequestParam(value = "orden", required = false) String orden, Model model) {
    List<Empleado> empleados;
    if ("desc".equals(orden)) {
        empleados = empleadoService.obtenerListaDescendente();
    } else {
        empleados = empleadoService.obtenerListaAscendente();
    }
    model.addAttribute("empleados", empleados);
    return "empleados";
}


    @GetMapping("/empleados/nuevo")
    public String mostrarFormularioNuevoEmpleado(Model model){
        model.addAttribute("empleado", new Empleado());
        return "nuevoEmpleado";
    }

    @PostMapping("/empleados/guardar")
    public String guardarEmpleado(@ModelAttribute Empleado empleado, Model model){
        int resultado = empleadoService.guardar(empleado);
        if (resultado == -1) {
            model.addAttribute("error", "Error: Nombre de empleado ya existe.");
            return "nuevoEmpleado";
        }
        model.addAttribute("mensaje", "Inserción exitosa.");
        return "redirect:/empleados";
    }
}
