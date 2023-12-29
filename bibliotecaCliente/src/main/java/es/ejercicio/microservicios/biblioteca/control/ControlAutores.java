package es.ejercicio.microservicios.biblioteca.control;

import java.util.ArrayList;
import java.util.List;

import org.springframework.cloud.client.circuitbreaker.NoFallbackAvailableException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;

import es.ejercicio.microservicios.biblioteca.cliente.ClienteAutores;
import es.ejercicio.microservicios.dto.AutorDTO;



@Component 
public class ControlAutores implements ClienteAutores {

	@Override
	public List<AutorDTO> obtenerAutores() {
		return new ArrayList<AutorDTO>();
	}

	@Override
	public ResponseEntity<AutorDTO> obtenerAutor(String id) {
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
        		AutorDTO.builder().id(0).nombre("NO DISPONIBLE").build());
	}

   @Override
   public ResponseEntity<AutorDTO>  nuevoAutor(@RequestBody AutorDTO input) {
		return ResponseEntity
       		.status(HttpStatus.NOT_FOUND)
       		.body(AutorDTO.builder().id(0).nombre("NO DISPONIBLE").build());
   }

   @Override
	public void eliminarAutor(String id) {
	   throw new NoFallbackAvailableException("Fallo al eliminar el Autor!", new RuntimeException());
	}
}
