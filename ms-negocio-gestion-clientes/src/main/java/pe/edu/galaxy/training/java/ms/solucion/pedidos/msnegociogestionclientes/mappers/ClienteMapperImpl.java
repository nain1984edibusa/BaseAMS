package pe.edu.galaxy.training.java.ms.solucion.pedidos.msnegociogestionclientes.mappers;

import java.util.List;

import org.springframework.stereotype.Component;

import pe.edu.galaxy.training.java.ms.solucion.pedidos.msnegociogestionclientes.dto.ClienteDTO;
import pe.edu.galaxy.training.java.ms.solucion.pedidos.msnegociogestionclientes.entity.ClienteEntity;

@Component
public class ClienteMapperImpl implements ClienteMapper {

	@Override
	public ClienteDTO toDTO(ClienteEntity e) {
		return ClienteDTO.builder().id(e.getId()).razonSocial(e.getRazonSocial()).ruc(e.getRuc()).telefono(e.getTelefono()).correo(e.getCorreo())
				.direccion(e.getDireccion()).build();
	}

	@Override
	public List<ClienteDTO> toDTO(List<ClienteEntity> lst) {
		return lst.stream().map(e -> toDTO(e)).toList();
	}

}
