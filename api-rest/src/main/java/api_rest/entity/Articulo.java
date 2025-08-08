package api_rest.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

@Entity(name = "articulos")
@Setter
@Getter
public class Articulo extends Publicacion{

    private String areaInvestigacion;
    private String revista;
    private String indexacion;

    @ManyToOne
    @JoinColumn(name = "id_autor")
    @JsonIgnore
    private Autor autor;
}
