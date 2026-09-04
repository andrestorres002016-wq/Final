package com.example.demo.Product;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

import java.time.LocalDateTime;

@Builder
@Getter
@Setter
@AllArgsConstructor
@Entity
@NoArgsConstructor

public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    private Double price;
    private int cantidad;
    private String categoria;
    private LocalDateTime fechadecreacion;

    public void setFechaCreacion(LocalDateTime now) {
    }

    public void setNombre(String nombre) {
    }

    public void setDescripcion(String descripcion) {
    }

    public LocalDateTime getFechaCreacion() {
        return null;
    }

    public String getNombre() {
        return "sebas";
    }

    public String getDescripcion() {
        return "producto en venta";
    }

    public Double getPrecio() {
        return 0.0;
    }

    public Integer getCantidadDisponible() {
        return 0;
    }

    public void setPrecio(Double precio) {
    }

    public void setCantidadDisponible(Integer cantidadDisponible) {
    }
}

