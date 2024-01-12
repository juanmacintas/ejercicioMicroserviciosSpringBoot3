package es.ejercicio.microservicios.biblioteca.cliente;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import es.ejercicio.microservicios.biblioteca.control.ControlCategorias;
import es.ejercicio.microservicios.dto.CategoriaDTO;

@FeignClient(name="categorias",
			fallback = ControlCategorias.class)
public interface ClienteCategorias {

  @RequestMapping(path = "/getAll",
	   		method = RequestMethod.GET)
  List<CategoriaDTO> obtenerCategorias();

   @RequestMapping(path = "/getCategoria/{id}",
    		method = RequestMethod.GET)
    CategoriaDTO obtenerCategoria(@PathVariable("id") String id);

   @RequestMapping(path = "/nuevaCategoria",
   		method = RequestMethod.POST)
   ResponseEntity<CategoriaDTO>  nuevaCategoria(@RequestBody CategoriaDTO input);


   @RequestMapping(path = "/deleteCategoria/{id}",
   		method = RequestMethod.DELETE)
   void eliminarCategoria(@PathVariable("id") String id);

}
