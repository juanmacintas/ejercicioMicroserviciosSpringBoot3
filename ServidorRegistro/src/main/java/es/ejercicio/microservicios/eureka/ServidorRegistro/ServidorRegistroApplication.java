package es.ejercicio.microservicios.eureka.ServidorRegistro;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class ServidorRegistroApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServidorRegistroApplication.class, args);
	}

}
