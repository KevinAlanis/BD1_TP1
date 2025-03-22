package com.example.demo.repositorios;

import com.example.demo.entidades.Empleado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
//import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface EmpleadoRepository extends JpaRepository<Empleado, Integer> {

    @Procedure(procedureName = "sp_InsertarEmpleado")
    int sp_InsertarEmpleado(String Nombre, BigDecimal Salario);

    @Procedure(procedureName = "sp_ObtenerEmpleadosOrdenados")
    List<Empleado> sp_ObtenerEmpleadosOrdenados();

    @Procedure(procedureName = "sp_ObtenerEmpleadosOrdenadosDesc")
    List<Empleado> sp_ObtenerEmpleadosOrdenadosDesc();
}
