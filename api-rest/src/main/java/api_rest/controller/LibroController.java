package api_rest.controller;

import api_rest.dto.LibroDTO;
import api_rest.dto.ResponseDTO;
import api_rest.entity.Libro;
import api_rest.service.LibroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/libros")
public class LibroController {

    @Autowired
    private LibroService service;

    @PostMapping
    public ResponseDTO crearLibro(@RequestBody LibroDTO dto) {
        return service.crearLibro(dto);
    }

    @GetMapping
    public List<Libro> listarLibros() {
        return service.listarLibros();

}

}
