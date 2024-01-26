package es.ejercicio.microservicios.biblioteca.control;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import es.ejercicio.microservicios.biblioteca.cliente.ClienteBiblioteca;
import es.ejercicio.microservicios.dto.AutorDTO;
import es.ejercicio.microservicios.dto.CategoriaDTO;
import es.ejercicio.microservicios.dto.LibroBibliotecaDTO;


@Component 
public class ControlBiblioteca implements ClienteBiblioteca {

	@Override
	public List<LibroBibliotecaDTO> obtenerLibros() {
		return new ArrayList<LibroBibliotecaDTO>();
	}

	@Override
	public List<LibroBibliotecaDTO> obtenerLibrosFavoritos() {

		return new ArrayList<LibroBibliotecaDTO>();
	}

	@Override
	public List<AutorDTO> obtenerAutores() {

		return new ArrayList<AutorDTO>();
	}

	@Override
	public List<CategoriaDTO> obtenerCategorias() {

		return new ArrayList<CategoriaDTO>();
	}


}
