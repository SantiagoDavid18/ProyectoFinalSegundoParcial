package api_rest.repository;

import api_rest.entity.Articulo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArticuloRepository extends JpaRepository<Articulo, Long> {
}
