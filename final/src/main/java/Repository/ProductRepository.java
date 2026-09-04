package Repository;

import com.example.demo.Model.ProductModel;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface ProductRepository extends JpaRepository<ProductModel, Long> {
    List<ProductModel> findByCategoriaIgnoreCase(String categoria);
    List<ProductModel> findByNombreContainingIgnoreCase(String nombre);
}