package api_rest.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class ArticuloDTO {

    //Atributos del Padre
    private String titulo;
    private int anioPublicacion;
    private String editorial;
    private String isbn;
    private String resumen;

//Atributos propios del articulo

    private String areaInvestigacion;
    private String revista;
    private String indexacion;
    private Long idAutor;
}
