package es.ejercicio.microservicios.service;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.ejercicio.microservicios.biblioteca.cliente.ClienteBiblioteca;
import es.ejercicio.microservicios.dto.LibroBibliotecaDTO;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class BibliotecaService implements Serializable {

	@Autowired
    private ClienteBiblioteca clienteBiblioteca;
	
   
    public List<LibroBibliotecaDTO> obtieneLibrosBilioteca() {
    	List<LibroBibliotecaDTO> libros = clienteBiblioteca.obtenerLibros();
    	log.debug("Libros obtenidos:" + libros);
    	return libros;
    }

    public List<LibroBibliotecaDTO> obtieneLibrosFavoritosBilioteca() {
		return clienteBiblioteca.obtenerLibrosFavoritos();
}
    
}
