package es.ejercicio.microservicios.biblioteca.control;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import es.ejercicio.microservicios.biblioteca.cliente.ClienteLibros;
import es.ejercicio.microservicios.dto.LibroDTO;


@Component
public class ControlLibros implements ClienteLibros {

	@Override
	public  List<LibroDTO> obtenerLibros() {
		return new ArrayList<LibroDTO>() ;
	}

	@Override
	public  List<LibroDTO> obtenerLibrosFavoritos() {
		return new ArrayList<LibroDTO>() ;
	}

	@Override
	public  List<LibroDTO> obtenerLibrosByExample(LibroDTO example) {
		return new ArrayList<LibroDTO>() ;
	}

	@Override	
	public LibroDTO obtenerLibro(String id) {
		return LibroDTO.builder().id(0).titulo("NO DISPONIBLE").build();
	}

}
