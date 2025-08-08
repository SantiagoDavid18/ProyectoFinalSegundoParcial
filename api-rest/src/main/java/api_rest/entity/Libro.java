package api_rest.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Entity(name = "libros")
@Setter
@Getter
public class Libro extends Publicacion{

    private String genero;
    private int numeroPaginas;

    @ManyToOne
    @JoinColumn(name = "id_autor")
    @JsonBackReference
    private Autor autor;

}
