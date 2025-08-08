package api_rest.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AutorDTO {

    @NotBlank(message = "El nombre es obligatorio")
    private String nombre;

    @NotBlank(message = "El apellido es obligatorio")
    private String apellido;

    @Email(message = "Debe ser un correo valido")
    @NotBlank(message = "El email es obligatorio")
    private String email;

    @NotBlank(message = "La nacionalidad es un campo obligatorio")
    private String nacionalidad;

        @NotBlank(message = "El ordic es un campo obligatorio")
    private String orcid;

    @NotBlank(message = "La insititucion es un campo obligatorio")
    private String institucion;

}
