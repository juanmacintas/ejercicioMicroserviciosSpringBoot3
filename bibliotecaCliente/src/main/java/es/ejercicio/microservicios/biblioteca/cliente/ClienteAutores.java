package es.ejercicio.microservicios.biblioteca.cliente;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import es.ejercicio.microservicios.biblioteca.control.ControlAutores;
import es.ejercicio.microservicios.dto.AutorDTO;

@FeignClient(name="autores",
			fallback = ControlAutores.class)
public interface ClienteAutores {

	  @RequestMapping(path = "/autores/getAll",
		   		method = RequestMethod.GET)
	  List<AutorDTO> obtenerAutores();

	  @RequestMapping(path = "/autores/getAutor/{id}",
    		method = RequestMethod.GET)
	  ResponseEntity<AutorDTO> obtenerAutor(@PathVariable("id") String id);

	  @RequestMapping(path = "/autores/nuevoAutor",
   		method = RequestMethod.POST)
	  ResponseEntity<AutorDTO>  nuevoAutor(@RequestBody AutorDTO input);


	  @RequestMapping(path = "/autores/deleteAutor/{id}",
   		method = RequestMethod.DELETE)
	  void eliminarAutor(@PathVariable("id") String id);

}
