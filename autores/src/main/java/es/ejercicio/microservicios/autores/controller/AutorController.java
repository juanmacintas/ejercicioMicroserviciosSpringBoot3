package es.ejercicio.microservicios.autores.controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import es.ejercicio.microservicios.autores.entity.Autor;
import es.ejercicio.microservicios.autores.service.AutorService;
import es.ejercicio.microservicios.dto.AutorDTO;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;


@Slf4j
@RestController
@RefreshScope
@Tag(name = "Autores", description = "Controlador de Autores")
public class AutorController {

	@Value("${mensaje.bienvenida}")
	@Getter private String sMensaje;

    @Autowired
    private AutorService autorService;

    @Autowired
    private ModelMapper modelMapper;

    /**
     * Retorna el mensaje del fichero de propiedades
     * @return sMensaje
     */
    @RequestMapping(value = "/getMensaje", method = RequestMethod.GET)
    @ApiOperation("Retorna el valor de la propiedad mensaje.bienvenida del fichero de configuración")
    public String getMensaje()  {
       return sMensaje;
    }

    /**
     * Retorna todos los autores
     * @return Listado de autores
     * @throws SQLException
     */
    @RequestMapping(value = "/getAll", method = RequestMethod.GET)
    @Operation(
    	      summary = "Retorna todos los autores",
    	      description = "Retorna la información de todos los autores",
    	      tags = { "Autores"})
    	  @ApiResponses({
    	      @ApiResponse(responseCode = "200", content = { @Content(schema = @Schema(implementation = AutorDTO.class), mediaType = "application/json") }),
    	      @ApiResponse(responseCode = "404", content = { @Content(schema = @Schema()) }),
    	      @ApiResponse(responseCode = "500", content = { @Content(schema = @Schema()) }) })
    public List<AutorDTO> getAll() throws SQLException {

    	List<Autor> autores = autorService.findAll();
       	List<AutorDTO> autoresDTO = new ArrayList<AutorDTO>();
    	if (autores != null)
    	{
    		for (Autor autor : autores) {
    			AutorDTO autorDTO= (AutorDTO) modelMapper.map(autor, AutorDTO.class);
    			autoresDTO.add(autorDTO);
    		}

    	}
        return autoresDTO;

    }

    /**
     * Retorna el autor del id
     * @return Autor
     * @throws SQLException
     */
    @RequestMapping(value = "/getAutor/{id}", method = RequestMethod.GET)
    public ResponseEntity<AutorDTO> getAutor(@ApiParam(name = "id", value = "Id del Autor a buscar", required = true) @PathVariable("id") String id) throws SQLException {
    	log.debug("Llamada a getAutor para el id:" + id);
    	Integer idAutor = 0;
    	try
    	{
    		idAutor = Integer.parseInt(id);
    	} catch (NumberFormatException ex) {
    		log.error("Se ha producido un error, el id no es un valor numerico:" + ex.getMessage());
    		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new AutorDTO());
    	}

    	//Span s = tracer.createSpan("Autor");

    	//s.logEvent("Se obtiene el autor:" + idAutor);
    	log.debug("Se busca el autor " + idAutor + " en base de datos.");
    	Autor autor = autorService.findById(idAutor);
    	if (autor != null)
    	{
    		log.debug("Autor Obtenido");
    		AutorDTO autorDTO= (AutorDTO) modelMapper.map(autor, AutorDTO.class);
    		log.debug("Autor retornado:" + autorDTO);
    		return ResponseEntity.status(HttpStatus.OK).body(autorDTO);
    	} else {

    		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new AutorDTO());
    	}


    }

    /**
     * Elimina el autor del id
     * @throws SQLException
     */
    @RequestMapping(value = "/deleteAutor/{id}", method = RequestMethod.DELETE)
    @ApiOperation(value = "Elimina un Autor",
    			notes = "Elimina el Autor del id especificado",
    		  response = HttpStatus.class)
    public HttpStatus deleteAutor(@ApiParam(name = "id", value = "Id del Autor a eliminar", required = true)@PathVariable("id") String id) throws SQLException {
    	Integer idAutor = 0;
    	try
    	{
    		idAutor = Integer.parseInt(id);
    	} catch (NumberFormatException ex) {
    		log.error("Se ha producido un error, el id no es un valor numerico:" + ex.getMessage());
    		return HttpStatus.NOT_FOUND;
    	}
    	autorService.deleteById(idAutor);

       	return HttpStatus.OK;
    }


    /**
     * Añade un nuevo autor
     * @return Autor
     * @throws SQLException
     */
    @RequestMapping(value = "/nuevoAutor", method = RequestMethod.POST)
    @ApiOperation("Inserta o actualiza en base de datos un Autor")
    public ResponseEntity<AutorDTO> nuevoAutor(@ApiParam(name = "autorDTO", value = "Autor a insertar/actualizar", required = true) @RequestBody AutorDTO input) throws SQLException {
    	log.debug("Se intenta insertar el autor:" + input);

    	Autor autor = Autor.builder().id(input.getId())
    											 .nombre(input.getNombre())
    											 .build();

    	Autor nuevoAutor = autorService.nuevoAutor(autor);
    	AutorDTO autorDTO= (AutorDTO) modelMapper.map(nuevoAutor, AutorDTO.class);

       	return ResponseEntity.status(HttpStatus.OK).body(autorDTO);

    }

}
