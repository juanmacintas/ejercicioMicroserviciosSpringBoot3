package es.ejercicio.microservicios.autores.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;

@Configuration
public class OpenAPIConfig {

	
	 @Bean
	  public OpenAPI myOpenAPI() {

	    Contact contact = new Contact();
	    contact.setEmail("hurone@gmail.com");
	    contact.setName("Juan Manuel Cintas");
	    contact.setUrl("https://github.com/juanmacintas/ejercicioMicroserviciosSpringBoot3");

	    License mitLicense = new License().name("MIT License").url("https://choosealicense.com/licenses/mit/");

	    Info info = new Info()
	        .title("Tutorial Management API")
	        .version("1.0")
	        .contact(contact)
	        .description("This API exposes endpoints to manage tutorials.").termsOfService("https://www.bezkoder.com/terms")
	        .license(mitLicense);

	    return new OpenAPI().info(info);
	  }
}
