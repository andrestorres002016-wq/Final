package com.example.demo.Service;

import com.example.demo.Model.ProductModel;
import com.example.demo.Repository.ProductRepository;
import com.example.demo.dto.ProductRequestDTO;
import com.example.demo.dto.ProductResponseDTO;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public ProductResponseDTO createProduct(ProductRequestDTO requestDTO) {
        ProductModel product = mapToEntity(requestDTO);
        product.setFechaCreacion(LocalDateTime.now());
        ProductModel savedProduct = productRepository.save(product);
        return mapToDTO(savedProduct);
    }

    public List<ProductResponseDTO> getAllProducts() {
        return productRepository.findAll()
                .stream()
                .map(this::mapToDTO)
                .toList();
    }

    public ProductResponseDTO getProductById(Long id) {
        ProductModel product = productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Producto no encontrado con ID: " + id));
        return mapToDTO(product);
    }

    public ProductResponseDTO updateProduct(Long id, ProductRequestDTO requestDTO) {
        ProductModel product = productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Producto no encontrado con ID: " + id));

        product.setNombre(requestDTO.getNombre());
        product.setDescripcion(requestDTO.getDescripcion());
        product.setPrecio(requestDTO.getPrecio());
        product.setCantidadDisponible(requestDTO.getCantidadDisponible());
        product.setCategoria(requestDTO.getCategoria());

        ProductModel updatedProduct = productRepository.save(product);
        return mapToDTO(updatedProduct);
    }

    public void deleteProduct(Long id) {
        if (!productRepository.existsById(id)) {
            throw new RuntimeException("Producto no encontrado con ID: " + id);
        }
        productRepository.deleteById(id);
    }

    public List<ProductResponseDTO> getProductsByCategory(String category) {
        return productRepository.findByCategoriaIgnoreCase(category)
                .stream()
                .map(this::mapToDTO)
                .toList();
    }

    public List<ProductResponseDTO> getProductsByName(String name) {
        return productRepository.findByNombreContainingIgnoreCase(name)
                .stream()
                .map(this::mapToDTO)
                .toList();
    }

    private ProductModel mapToEntity(ProductRequestDTO dto) {
        ProductModel p = new ProductModel();
        p.setNombre(dto.getNombre());
        p.setDescripcion(dto.getDescripcion());
        p.setPrecio(dto.getPrecio());
        p.setCantidadDisponible(dto.getCantidadDisponible());
        p.setCategoria(dto.getCategoria());
        return p;
    }

    private ProductResponseDTO mapToDTO(ProductModel p) {
        ProductResponseDTO dto = new ProductResponseDTO();
        dto.setId(p.getId());
        dto.setNombre(p.getNombre());
        dto.setDescripcion(p.getDescripcion());
        dto.setPrecio(p.getPrecio());
        dto.setCantidadDisponible(p.getCantidadDisponible());
        dto.setCategoria(p.getCategoria());
        dto.setFechaCreacion(p.getFechaCreacion());
        return dto;
    }
}