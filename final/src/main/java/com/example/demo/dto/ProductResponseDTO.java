package com.example.demo.dto;

import java.time.LocalDateTime;

    public class ProductResponseDTO {
        private Long id;
        private String nombre;
        private String descripcion;
        private Double precio;
        private Integer cantidadDisponible;
        private String categoria;
        private LocalDateTime fechaCreacion;

        public ProductResponseDTO() {}

        public Long getId() { return id; }
        public void setId(Long id) { this.id = id; }
        public String getNombre() { return nombre; }
        public void setNombre(String nombre) { this.nombre = nombre; }
        public String getDescripcion() { return descripcion; }
        public void setDescripcion(String descripcion) { this.descripcion = descripcion; }
        public Double getPrecio() { return precio; }
        public void setPrecio(Double precio) { this.precio = precio; }
        public Integer getCantidadDisponible() { return cantidadDisponible; }
        public void setCantidadDisponible(Integer cantidadDisponible) { this.cantidadDisponible = cantidadDisponible; }
        public String getCategoria() { return categoria; }
        public void setCategoria(String categoria) { this.categoria = categoria; }
        public LocalDateTime getFechaCreacion() { return fechaCreacion; }
        public void setFechaCreacion(LocalDateTime fechaCreacion) { this.fechaCreacion = fechaCreacion; }
    }
