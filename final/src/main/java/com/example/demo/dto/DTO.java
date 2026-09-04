package com.example.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class DTO {

    private Long id;
    private String name;
    private String description;
    private Double price;
    private Double cantidad;
    private String categoria;
    private Double fechadecreacion;
}
