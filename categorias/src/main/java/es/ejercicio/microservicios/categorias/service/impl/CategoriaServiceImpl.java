package es.ejercicio.microservicios.categorias.service.impl;

import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import es.ejercicio.microservicios.categorias.entity.Categoria;
import es.ejercicio.microservicios.categorias.repository.CategoriaRepository;
import es.ejercicio.microservicios.categorias.service.CategoriaService;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class CategoriaServiceImpl implements CategoriaService {

	@Autowired
	private CategoriaRepository categoriaRepository;


	@Override
	@Cacheable(value = "categorias")
	public List<Categoria> findAll() {
		log.debug("Se obtienen todas las categorias.");
		return categoriaRepository.findAll();
	}


	@Override
	@Cacheable(value = "categoria", key = "#id")
	public Categoria findById(Integer id) {
		log.debug("Se obtiene la categoria con id:" + id);
		return categoriaRepository.findById(id).get();
	}


	@Override
	public Categoria nuevaCategoria(Categoria categoria) {
		log.debug("Se añade la categoria:" + categoria);
		return categoriaRepository.save(categoria);

	}


	@Override
	public void deleteById(Integer id) {
		log.debug("Se elimina la categoria con id:" + id);
		categoriaRepository.deleteById(id);

	}
}
