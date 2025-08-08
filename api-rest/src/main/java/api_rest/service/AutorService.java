package api_rest.service;

import api_rest.dto.AutorDTO;
import api_rest.dto.ResponseDTO;
import api_rest.entity.Autor;
import api_rest.producer.NotificacionProducer;
import api_rest.repository.AutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AutorService {

    @Autowired
    private AutorRepository autorRepository;

    @Autowired
    private NotificacionProducer notificacionProducer;

    //Crear un nuevo autor
    public ResponseDTO crearAutor(AutorDTO dto) {
        Autor autor = new Autor();
        autor.setNombre(dto.getNombre());;
        autor.setApellido(dto.getApellido());
        autor.setEmail(dto.getEmail());
        autor.setInstitucion(dto.getInstitucion());
        autor.setOrcid(dto.getOrcid());
        autor.setNacionalidad(dto.getNacionalidad());
        Autor savedAutor = autorRepository.save(autor);


        notificacionProducer.enviarNotificacion(
                 "Nuevo autor registrado"+dto.getNombre(),
                       "Nuevo Autor");


        return new ResponseDTO( "Autor registrado exitosamente", savedAutor);
        }

        // Obtener por ID
        public ResponseDTO buscarPorId(Long id) {
            Autor autor = autorRepository.findById(id)
                    .orElseThrow(() -> new RuntimeException("Autor no encontrado"));
            return new ResponseDTO("Autor encontrado", autor);
        }

        // Actualizar un autor
        public ResponseDTO actualizarAutor(Long id, AutorDTO dto) {
            Autor autor = autorRepository.findById(id)
                    .orElseThrow(() -> new RuntimeException("Autor no encontrado"));

            autor.setNombre(dto.getNombre());
            autor.setApellido(dto.getApellido());
            autor.setEmail(dto.getEmail());
            autor.setInstitucion(dto.getInstitucion());
            autor.setOrcid(dto.getOrcid());
            autor.setNacionalidad(dto.getNacionalidad());

            return new ResponseDTO("Autor actualizado exitosamente",
                    autorRepository.save(autor));
        }

        // Eliminar un autor
        public ResponseDTO eliminarAutor(Long id) {
        if (!autorRepository.existsById(id)) {
            throw new RuntimeException("Autor no existe");
        }
        autorRepository.deleteById(id);
        return new ResponseDTO("Autor eliminado exitosamente", id);

        }

        // Obtener todos los autores
        public ResponseDTO listarAutores() {
            List<Autor> autores = autorRepository.findAll();
            int total = autores.size();
            return new ResponseDTO("Se encontraron:" + total + "autores", autores);

        }

        public List<Autor> listarTodos (){
        return autorRepository.findAll();
        }
    }

