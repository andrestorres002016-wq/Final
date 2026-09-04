package impl;

import Repository.ProductRepository;
import com.example.demo.Product.Product;
import com.example.demo.dto.ProductRequestDTO;
import com.example.demo.dto.ProductResponseDTO;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

    @Service
    public class ProductServiceImpl implements impl.ProductService {

        private final ProductServiceImpl productRepository;

        public ProductServiceImpl(ProductRepository productRepository) {
            this.productRepository = (ProductServiceImpl) productRepository;
        }

        @Override
        public ProductResponseDTO createProduct(ProductRequestDTO requestDTO) {
            Product product = mapToEntity(requestDTO);
            product.setFechaCreacion(LocalDateTime.now());
            return mapToDTO(productRepository.save(product));
        }

        private Product save(Product product) {
            return product;
        }


        @Override
        public List<ProductResponseDTO> getAllProducts() {
            return productRepository.findAll().stream().map(this::mapToDTO).toList();
        }

        private Arrays findAll() {
            return null;
        }


        @Override
        public ProductResponseDTO getProductById(Long id) throws Throwable {
            Product product = (Product) productRepository.findById(id).orElseThrow(() -> new RuntimeException("Producto no encontrado con ID: " + id));
            return mapToDTO(product);
        }

        private  ScopedValue findById(Long id) {
            return null;
        }

        @Override
        public ProductResponseDTO updateProduct(Long id, ProductRequestDTO requestDTO) throws Throwable {
            Product product = (Product) productRepository.findById(id).orElseThrow(() -> new RuntimeException("Producto no encontrado con ID: " + id));
            product.setNombre(requestDTO.getNombre());
            product.setDescripcion(requestDTO.getDescripcion());
            product.setPrecio(requestDTO.getPrecio());
            product.setCantidadDisponible(requestDTO.getCantidadDisponible());
            product.setCategoria(requestDTO.getCategoria());
            return mapToDTO(productRepository.save(product));
        }

        @Override
        public void deleteProduct(Long id) {
            productRepository.deleteById(id);
        }

        private void deleteById(Long id) {
        }

        @Override
        public List<ProductResponseDTO> getProductsByCategory(String category) {
            return productRepository.findByCategoriaIgnoreCase(category)
                    .stream()
                    .map(this::mapToDTO)
                    .toList();
        }

        @Override
        public List<ProductResponseDTO> getProductsByName(String name) {
            return productRepository.findByNombreContainingIgnoreCase(name).stream().map(this::mapToDTO).toList();
        }

        @Override
        public Arrays findByCategoriaIgnoreCase(String category) {
            return null;
        }

        private Arrays findByNombreContainingIgnoreCase(String name) {
            return null;
        }

        private Product mapToEntity(ProductRequestDTO dto) {
            Product p = new Product();
            p.setNombre(dto.getNombre());
            p.setDescripcion(dto.getDescripcion());
            p.setPrecio(dto.getPrecio());
            p.setCantidadDisponible(dto.getCantidadDisponible());
            p.setCategoria(dto.getCategoria());
            return p;
        }

        private ProductResponseDTO mapToDTO(Product p) {
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
