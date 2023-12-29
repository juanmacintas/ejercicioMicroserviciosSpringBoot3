package es.ejercicio.microservicios.biblioteca.control;

import java.util.ArrayList;
import java.util.List;

import org.springframework.cloud.client.circuitbreaker.NoFallbackAvailableException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;

import es.ejercicio.microservicios.biblioteca.cliente.ClienteEditoriales;
import es.ejercicio.microservicios.dto.EditorialDTO;


@Component
public class ControlEditoriales implements ClienteEditoriales {

	@Override
	public List<EditorialDTO> obtenerEditoriales() {
		 return new ArrayList<EditorialDTO>();
	}

	@Override
	public EditorialDTO obtenerEditorial(String id) {
		 return EditorialDTO.builder().id(0).nombre("NO DISPONIBLE").build();
	}


	@Override
    public ResponseEntity<EditorialDTO> nuevaEditorial(@RequestBody EditorialDTO input) {
    	   return ResponseEntity
           		.status(HttpStatus.NOT_FOUND)
           		.body(EditorialDTO.builder().id(0).nombre("NO DISPONIBLE").build());
   }

	
	@Override
	public void eliminarEditorial(String id) {
		throw new NoFallbackAvailableException("Fallo al eliminar la editorial", new RuntimeException());
		
	}
	
}
