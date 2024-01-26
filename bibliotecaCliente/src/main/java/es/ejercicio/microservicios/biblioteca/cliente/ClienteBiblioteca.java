package es.ejercicio.microservicios.biblioteca.cliente;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import es.ejercicio.microservicios.biblioteca.control.ControlBiblioteca;
import es.ejercicio.microservicios.dto.AutorDTO;
import es.ejercicio.microservicios.dto.CategoriaDTO;
import es.ejercicio.microservicios.dto.LibroBibliotecaDTO;

@FeignClient(name="biblioteca",
			fallback = ControlBiblioteca.class)
public interface ClienteBiblioteca {

	  @RequestMapping(path = "/getAll",
		   		method = RequestMethod.GET)
	  List<LibroBibliotecaDTO> obtenerLibros();

	  @RequestMapping(path = "getAllFavoritos",
    		method = RequestMethod.GET)
	  List<LibroBibliotecaDTO> obtenerLibrosFavoritos();

	  @RequestMapping(path = "/getAutores",
   		method = RequestMethod.GET)
	  List<AutorDTO>  obtenerAutores();


	  @RequestMapping(path = "/getCategorias",
   		method = RequestMethod.GET)
	   List<CategoriaDTO> obtenerCategorias();

}
