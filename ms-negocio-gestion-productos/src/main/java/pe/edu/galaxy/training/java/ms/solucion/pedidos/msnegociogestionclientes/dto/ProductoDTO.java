package pe.edu.galaxy.training.java.ms.solucion.pedidos.msnegociogestionclientes.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductoDTO{

	private Long id;
	
	private String nombre;
	
	private Double precio;
	
	private Integer stock;

	private String estado;

}
