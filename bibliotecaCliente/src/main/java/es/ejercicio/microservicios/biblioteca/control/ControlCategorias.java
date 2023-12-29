package es.ejercicio.microservicios.biblioteca.control;

import java.util.ArrayList;
import java.util.List;

import org.springframework.cloud.client.circuitbreaker.NoFallbackAvailableException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;

import es.ejercicio.microservicios.biblioteca.cliente.ClienteCategorias;
import es.ejercicio.microservicios.dto.CategoriaDTO;


@Component
public class ControlCategorias implements ClienteCategorias{


	@Override
	public List<CategoriaDTO> obtenerCategorias() {
		return new ArrayList<CategoriaDTO>();
	}

	@Override
	public CategoriaDTO obtenerCategoria(String id) {
		return CategoriaDTO.builder().id(0).nombre("NO DISPONIBLE").build();
	}


	@Override
    public ResponseEntity<CategoriaDTO>  nuevaCategoria(@RequestBody CategoriaDTO input) {
	      return ResponseEntity
	        		.status(HttpStatus.NOT_FOUND)
	        		.body(CategoriaDTO.builder().id(0).nombre("NO DISPONIBLE").build());
   }

	@Override
	public void eliminarCategoria(String id) {
		throw new NoFallbackAvailableException("Fallo al eliminar la categoría", new RuntimeException());
	}

}
