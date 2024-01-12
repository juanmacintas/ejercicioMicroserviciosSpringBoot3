package es.ejercicio.microservicios.biblioteca.cliente;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import es.ejercicio.microservicios.biblioteca.control.ControlLibros;
import es.ejercicio.microservicios.dto.LibroDTO;

@FeignClient(name="libros",
			fallback = ControlLibros.class)
public interface ClienteLibros {

   @RequestMapping(path = "/getAll",
    		method = RequestMethod.GET)
    List<LibroDTO>  obtenerLibros();

   @RequestMapping(path = "/getFavoritos",
   		method = RequestMethod.GET)
   List<LibroDTO>  obtenerLibrosFavoritos();


   @RequestMapping(path = "/getByExample",
	   		method = RequestMethod.POST)
   List<LibroDTO>  obtenerLibrosByExample(@RequestBody LibroDTO input);

   @RequestMapping(path = "/getLibro/{id}",
   		method = RequestMethod.GET)
   LibroDTO obtenerLibro(@PathVariable("id") String id);

}
