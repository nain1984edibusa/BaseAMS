package pe.edu.galaxy.training.ms.solucion.pedidos.msadministracionserveradmin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import de.codecentric.boot.admin.server.config.EnableAdminServer;

@EnableAdminServer
@SpringBootApplication
public class MsAdministracionServerAdminApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsAdministracionServerAdminApplication.class, args);
	}

}
