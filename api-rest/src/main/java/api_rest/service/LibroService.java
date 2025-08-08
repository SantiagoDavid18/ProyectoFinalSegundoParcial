package api_rest.service;

import api_rest.dto.LibroDTO;
import api_rest.dto.ResponseDTO;
import api_rest.entity.Autor;
import api_rest.entity.Libro;
import api_rest.producer.NotificacionProducer;
import api_rest.repository.AutorRepository;
import api_rest.repository.LibroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static api_rest.repository.LibroRepository.*;

@Service
public class LibroService {
    @Autowired
    private LibroRepository repository;

    @Autowired
    private AutorRepository autorRepository;

    public ResponseDTO crearLibro(LibroDTO dto) {
        Autor autor = autorRepository.findById(dto.getIdAutor())
                .orElseThrow(() -> new RuntimeException("Autor no encontrado"));

        Libro libro = new Libro();
        libro.setAutor(autor);
        libro.setTitulo(dto.getTitulo());
        libro.setResumen(dto.getResumen());
        libro.setEditorial(dto.getEditorial());
        libro.setIsbn(dto.getIsbn());
        libro.setAnioPublicacion(dto.getAnioPublicacion());
        libro.setNumeroPaginas(dto.getNumeroPaginas());
        libro.setGenero(dto.getGenero());

        Libro savedLibro = repository.save(libro);

        NotificacionProducer.enviarNotificacion(
           "Libro :"+dto.getTitulo()+"  registrado",
            "Nuevo Libro"
        );

        return new ResponseDTO(
                "Libro registrado exitosamente",
                savedLibro);
    }

    public List<Libro> listarLibros() {
        return repository.findAll();
    }
}

