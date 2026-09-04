package com.example.demo.Repository;

import com.example.demo.Model.ProductModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<ProductModel, Long> {

    List<ProductModel> findByCategoriaIgnoreCase(String categoria);

    List<ProductModel> findByNombreContainingIgnoreCase(String nombre);
}