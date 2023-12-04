package es.ejercicio.microservicios.gestionconfiguracion.ServidorConfiguracion;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
public class ServidorConfiguracionApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServidorConfiguracionApplication.class, args);
	}

}
