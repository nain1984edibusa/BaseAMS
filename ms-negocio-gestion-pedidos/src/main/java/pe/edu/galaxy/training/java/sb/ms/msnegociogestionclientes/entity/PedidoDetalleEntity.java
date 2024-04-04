package pe.edu.galaxy.training.java.sb.ms.msnegociogestionclientes.entity;

import static java.util.Objects.isNull;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "PEDIDO_DETALLE")
@Entity(name = "PedidoDetalleEntity")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PedidoDetalleEntity {

	@Id
	@Column(name = "PEDIDO_DETALLE_ID")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqPedidoDetalle")
	@SequenceGenerator(sequenceName = "SEQ_PEDIDO_DETALLE", allocationSize = 1, name = "seqPedidoDetalle")
	private Long id;
	
	@JsonIgnore // Para evitar bucles infinitos -JSonbackRefence
	@ManyToOne
	@JoinColumn(name = "PEDIDO_ID", nullable = false)
	private PedidoCabeceraEntity pedidoCabecera;
	
	@Column(name = "PRODUCTO_ID")
	private Long idProducto;
	
	@Column(name = "CANTIDAD")
	private Double cantidad;
	
	@Column(name = "PRECIO")
	private Double precio;
	
	@Column(name = "SUB_TOTAL")
	private Double subTotal;
	
	
	///----------------------------
	
	@Column(name = "ESTADO")
	private String estado;
	

	public void calcularSubTotal() {

		if (isNull(cantidad)) {
			cantidad = 0.0;
		}
		if (isNull(precio)) {
			precio = 0.0;
		}
		setSubTotal(cantidad * precio);
	}

}

