package api_rest.controller;

import api_rest.dto.AutorDTO;
import api_rest.dto.ResponseDTO;
import api_rest.entity.Autor;
import api_rest.service.AutorService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/autor")
@Tag(name = "autor", description = "Gestión de autores")
public class AutorController {
    @Autowired
    private AutorService autorService;

    // CREAR AUTOR
    @PostMapping
    @Operation(summary = "Registrar un nuevo autor, se ingresa un AutorDTO")
    public ResponseDTO crearAutor(@RequestBody @Valid AutorDTO dto) {
        return autorService.crearAutor(dto);
    }

    // LISTAR TODOS LOS AUTORES
    @GetMapping
    @Operation(summary = "Devuelve el listado de autores")
    public List<Autor> listarTodos() {
        return autorService.listarTodos();
    }

    // LISTAR AUTOR
    @GetMapping("/todos")
    @Operation(summary = "Devuelve el listado de autores DTO")
    public ResponseDTO listaAutores() {
            return autorService.listarAutores();
    }

    // OBTENER AUTOR POR ID
    @GetMapping("/{id}")
    public ResponseDTO buscarPorId(@PathVariable Long id) {
        return autorService.buscarPorId(id);
    }

    // ACTUALIZAR AUTOR
    @PutMapping("/{id}")
    public ResponseDTO actualizarAutor(@PathVariable Long id, @RequestBody @Valid AutorDTO dto) {
        return autorService.actualizarAutor(id, dto);
    }

    // ELIMINAR AUTOR
    @DeleteMapping("/{id}")
    public ResponseDTO eliminarAutor(@PathVariable Long id) {
        return autorService.eliminarAutor(id);
    }
}

