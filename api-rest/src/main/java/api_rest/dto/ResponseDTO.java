package api_rest.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

    public class ResponseDTO {
        private String mensaje;
        private Object data;

    }