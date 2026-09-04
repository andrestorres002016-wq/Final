package controller;


import com.ejemplo.inventario.dto.ProductRequestDTO;
import com.ejemplo.inventario.dto.ProductResponseDTO;
import com.ejemplo.inventario.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    // RF1: Crear producto - POST /api/products
    @PostMapping
    public ResponseEntity<ProductResponseDTO> createProduct(@RequestBody ProductRequestDTO requestDTO) {
        ProductResponseDTO createdProduct = productService.createProduct(requestDTO);
        return new ResponseEntity<>(createdProduct, HttpStatus.CREATED);
    }

    // RF1: Consultar todos los productos - GET /api/products
    @GetMapping
    public ResponseEntity<List<ProductResponseDTO>> getAllProducts() {
        return ResponseEntity.ok(productService.getAllProducts());
    }

    // RF1: Consultar producto por ID - GET /api/products/{id}
    @GetMapping("/{id}")
    public ResponseEntity<ProductResponseDTO> getProductById(@PathVariable Long id) {
        return ResponseEntity.ok(productService.getProductById(id));
    }

    // RF1: Actualizar producto - PUT /api/products/{id}
    @PutMapping("/{id}")
    public ResponseEntity<ProductResponseDTO> updateProduct(@PathVariable Long id, @RequestBody ProductRequestDTO requestDTO) {
        return ResponseEntity.ok(productService.updateProduct(id, requestDTO));
    }

    // RF1: Eliminar producto - DELETE /api/products/{id}
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable Long id) {
        productService.deleteProduct(id);
        return ResponseEntity.noContent().build();
    }

    // RF2: Buscar por categoría - GET /api/products/category/{category}
    @GetMapping("/category/{category}")
    public ResponseEntity<List<ProductResponseDTO>> getProductsByCategory(@PathVariable String category) {
        return ResponseEntity.ok(productService.getProductsByCategory(category));
    }

    // RF2: Buscar por nombre - GET /api/products/search?name=mouse
    @GetMapping("/search")
    public ResponseEntity<List<ProductResponseDTO>> searchProductsByName(@RequestParam String name) {
        return ResponseEntity.ok(productService.searchProductsByName(name));
    }
}