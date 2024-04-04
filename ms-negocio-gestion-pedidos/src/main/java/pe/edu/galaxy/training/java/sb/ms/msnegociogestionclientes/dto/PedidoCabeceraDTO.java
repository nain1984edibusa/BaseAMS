package pe.edu.galaxy.training.java.sb.ms.msnegociogestionclientes.dto;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import pe.edu.galaxy.training.java.sb.ms.msnegociogestionclientes.service.client.clientes.ClienteDTO;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
//@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({"id","glosa","fechaRegistro","total","cliente"})
public class PedidoCabeceraDTO {

	private Long id;
	
	//private Long idCliente;
	
	@JsonProperty("cliente")
	private ClienteDTO clienteDTO;
	
	private String glosa;

	private String fechaRegistro;
	
	private Double total;

	@JsonProperty("items")
	private List<PedidoDetalleDTO> listPedidoDetalle;
	

}

