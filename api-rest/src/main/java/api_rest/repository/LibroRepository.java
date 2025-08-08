package api_rest.repository;

import api_rest.entity.Libro;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LibroRepository extends JpaRepository<Libro, Long>{
}
