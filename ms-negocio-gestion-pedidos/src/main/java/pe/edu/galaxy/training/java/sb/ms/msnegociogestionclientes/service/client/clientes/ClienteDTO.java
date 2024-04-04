package pe.edu.galaxy.training.java.sb.ms.msnegociogestionclientes.service.client.clientes;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ClienteDTO {

	private Long id;
	
	private String razonSocial;
	
	private String ruc;
}
