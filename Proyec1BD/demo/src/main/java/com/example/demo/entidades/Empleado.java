package com.example.demo.entidades;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name = "Empleado")
public class Empleado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, length = 128)
    private String nombre;

    @Column(nullable = false)
    private BigDecimal salario;

    public void setSalario(BigDecimal salario) {
        this.salario = salario;
    }

    // Getters y Setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public BigDecimal getSalario() {
        return salario;
    }
    
}