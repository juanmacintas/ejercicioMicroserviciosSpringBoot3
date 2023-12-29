package es.ejercicio.microservicios.biblioteca.cliente;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import es.ejercicio.microservicios.biblioteca.config.FeignAutoConfiguration;
import es.ejercicio.microservicios.biblioteca.control.ControlEditoriales;
import es.ejercicio.microservicios.dto.EditorialDTO;

@FeignClient(name="editoriales",
			fallback = ControlEditoriales.class,
			configuration = FeignAutoConfiguration.class)
public interface ClienteEditoriales {

    @RequestMapping(value = "/editoriales/getAll",
	   		method = RequestMethod.GET)
    List<EditorialDTO> obtenerEditoriales();

   @RequestMapping(value = "/editoriales/getEditorial/{id}",
    		method = RequestMethod.GET)
    EditorialDTO obtenerEditorial(@PathVariable("id") String id);

   @RequestMapping(value = "/editoriales/nuevaEditorial",
   		method = RequestMethod.POST)
   ResponseEntity<EditorialDTO>  nuevaEditorial(@RequestBody EditorialDTO input);


   @RequestMapping(value = "/editoriales/deleteEditorial/{id}",
   		method = RequestMethod.DELETE)
   void eliminarEditorial(@PathVariable("id") String id);

}
