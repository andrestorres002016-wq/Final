package servicio;

import com.example.demo.dto.ProductRequestDTO;
import com.example.demo.dto.ProductResponseDTO;
import java.util.List;

    public interface ProductService {
        ProductResponseDTO createProduct(ProductRequestDTO requestDTO);
        List<ProductResponseDTO> getAllProducts();
        ProductResponseDTO getProductById(Long id);
        ProductResponseDTO updateProduct(Long id, ProductRequestDTO requestDTO);
        void deleteProduct(Long id);
        List<ProductResponseDTO> getProductsByCategory(String category);
        List<ProductResponseDTO> getProductsByName(String name);
    }
