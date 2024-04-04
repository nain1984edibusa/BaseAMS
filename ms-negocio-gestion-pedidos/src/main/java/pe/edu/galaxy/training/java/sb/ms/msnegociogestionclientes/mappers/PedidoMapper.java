package pe.edu.galaxy.training.java.sb.ms.msnegociogestionclientes.mappers;

import org.mapstruct.Mapper;

import pe.edu.galaxy.training.java.sb.ms.msnegociogestionclientes.dto.PedidoCabeceraDTO;
import pe.edu.galaxy.training.java.sb.ms.msnegociogestionclientes.entity.PedidoCabeceraEntity;
import org.mapstruct.Mapping;

// https://github.com/mapstruct/mapstruct

@Mapper(componentModel = "spring")
public interface PedidoMapper {

	@Mapping(target = "clienteDTO", ignore = true)
	PedidoCabeceraDTO toDTO(PedidoCabeceraEntity e);
	
}
