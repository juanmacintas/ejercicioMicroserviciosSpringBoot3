package es.ejercicio.microservicios.view;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

import es.ejercicio.microservicios.dto.LibroBibliotecaDTO;
import es.ejercicio.microservicios.service.BibliotecaService;

@Route
public class BibliotecaView extends VerticalLayout {

	private Grid<LibroBibliotecaDTO> grid;
	private BibliotecaService servicioBiblioteca;
	
    /**
     * Construct a new Vaadin view.
     * <p>
     * Build the initial UI state for the user accessing the application.
     *
     * @param service
     *            The message service. Automatically injected Spring managed
     *            bean.
     */
    public BibliotecaView(@Autowired BibliotecaService service) {
    	this.servicioBiblioteca = service;
    	contruirUI();
        // Use custom CSS classes to apply styling. This is defined in
        // styles.css.
        addClassName("centered-content");

        add(grid);
    }

	private void contruirUI() {
		grid = new Grid<>(LibroBibliotecaDTO.class, false);
		grid.addColumn(LibroBibliotecaDTO::getTitulo).setHeader("Título");
		grid.addColumn(LibroBibliotecaDTO::getDescripcion).setHeader("Descripción");
		grid.addColumn(LibroBibliotecaDTO::getAutor).setHeader("Autor");
		grid.addColumn(LibroBibliotecaDTO::getCategoria).setHeader("Categoria");
		grid.addColumn(LibroBibliotecaDTO::getEditorial).setHeader("Editorial");

		List<LibroBibliotecaDTO> libros = servicioBiblioteca.obtieneLibrosBilioteca();
		grid.setItems(libros);
		
		
	}

}
