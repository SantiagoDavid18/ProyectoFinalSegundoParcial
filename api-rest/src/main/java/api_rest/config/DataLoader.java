package api_rest.config;

import api_rest.entity.Articulo;
import api_rest.entity.Autor;
import api_rest.entity.Libro;
import api_rest.repository.ArticuloRepository;
import api_rest.repository.AutorRepository;
import api_rest.repository.LibroRepository;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DataLoader implements CommandLineRunner {

    @Autowired
    private AutorRepository autorRepository;

    @Autowired
    private LibroRepository libroRepository;

    @Autowired
    private ArticuloRepository articuloRepository;

    @Override
    public void run(String... args) throws Exception {

        if(autorRepository.count() == 0) {
            Autor autor1 = new Autor();
            autor1.setNombre("Juan");
            autor1.setApellido("Quiñonez");
            autor1. setEmail("juanqui@gmail.com");
            autor1.setNacionalidad("Ecuatoriana");
            autor1.setOrcid("0987-0976-6545-2354");
            autor1.setInstitucion("ESPE");

            Autor autor2 = new Autor();
            autor2.setNombre("Emilio");
            autor2.setApellido("Padilla");
            autor2. setEmail("epadilla@gmail.com");
            autor2.setNacionalidad("Italiano");
            autor2.setOrcid("0917-0876-6345-2654");
            autor2.setInstitucion("UNAM");

            //GUARDAR AUTORES
            autorRepository.saveAll(List.of(autor1, autor2));
            System.out.println("Se registraron " + autorRepository.count() + " autores");

            Libro libro1 = new Libro();
            libro1.setAutor(autor1);
            libro1.setTitulo("Springbooot a fondo");
            libro1.setAnioPublicacion(2021);
            libro1.setEditorial("ESPE");
            libro1.setIsbn("0001-0002-020202");
            libro1.setResumen("Springbooot a fondo");
            libro1.setGenero("Desarrollo de software");
            libro1.setNumeroPaginas(150);

            Libro libro2 = new Libro();
            libro2.setAutor(autor2);
            libro2.setTitulo("Iliada");
            libro2.setAnioPublicacion(1995);
            libro2.setEditorial("ARCANGEL");
            libro2.setIsbn("0004-0005-040404");
            libro2.setResumen("Iliada");
            libro2.setGenero("Documento Literario");
            libro2.setNumeroPaginas(220);

            libroRepository.saveAll(List.of(libro1, libro2));

            Articulo art1 = new Articulo();
            art1.setAutor(autor1);
            art1.setTitulo("IA en MEdicina");
            art1.setAnioPublicacion(2021);
            art1.setEditorial("ESPE");
            art1.setIsbn("0978-0982-020765");
            art1.setResumen("IA en MEdicina");
            art1.setAreaInvestigacion("Medicina");
            art1.setRevista("Revista Latinoamericana de Medicina");

            Articulo art2 = new Articulo();
            art2.setAutor(autor2);
            art2.setTitulo("Analista de datos biometricos");
            art2.setAnioPublicacion(2025);
            art2.setEditorial("ESPE");
            art2.setIsbn("4678-0982-04562165");
            art2.setResumen("Analista de datos biometricos");
            art2.setAreaInvestigacion("Big Data");
            art2.setRevista("Journal of data Science");

            articuloRepository.saveAll(List.of(art1, art2));
            System.out.println("Se registraron " + articuloRepository.count() + " articulos");


        }else{
            System.out.println("Ya existe registros en la base de datos. No se cargaron los datos iniciales.");
        }
    }
}
