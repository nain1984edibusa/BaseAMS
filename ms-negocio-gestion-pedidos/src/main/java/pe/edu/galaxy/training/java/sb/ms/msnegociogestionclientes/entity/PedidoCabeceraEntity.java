package pe.edu.galaxy.training.java.sb.ms.msnegociogestionclientes.entity;

import java.util.List;

import org.hibernate.annotations.Where;
import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import static java.util.Objects.isNull;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "PEDIDO_CABECERA")
@Entity(name = "PedidoCabeceraEntity")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PedidoCabeceraEntity {

	@Id
	@Column(name = "PEDIDO_ID")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqPedidoCabecera")
	@SequenceGenerator(sequenceName = "SEQ_PEDIDO_CABECERA", allocationSize = 1, name = "seqPedidoCabecera")
	private Long id;
	
	@Column(name = "CLIENTE_ID")
	private Long idCliente;
	
	@Column(name = "GLOSA")
	private String glosa; // Resumen 

	@Column(name = "FECHA_REGISTRO")
	private String fechaRegistro;
	
	@Column(name = "TOTAL")
	private Double total;
	
	@Column(name = "ESTADO")
	private String estado;

	//
	@OneToMany(mappedBy = "pedidoCabecera", cascade = CascadeType.ALL)
	@Where(clause = "estado='1'")
	private List<PedidoDetalleEntity> listPedidoDetalle;
	

	public void calcularTotal() {
		
	Double tmpTotal=0.0;
		
		for (PedidoDetalleEntity pie : listPedidoDetalle) {
			if (isNull(listPedidoDetalle)|| listPedidoDetalle.isEmpty() || isNull(pie)) {
				setTotal(0.0);
			}
			
			tmpTotal+=pie.getSubTotal();
		}
		setTotal(tmpTotal);
	}

}

