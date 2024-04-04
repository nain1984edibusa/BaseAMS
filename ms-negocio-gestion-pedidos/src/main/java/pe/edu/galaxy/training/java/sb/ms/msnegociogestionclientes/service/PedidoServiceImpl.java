package pe.edu.galaxy.training.java.sb.ms.msnegociogestionclientes.service;

import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import pe.edu.galaxy.training.java.sb.ms.msnegociogestionclientes.dto.PedidoCabeceraDTO;
import pe.edu.galaxy.training.java.sb.ms.msnegociogestionclientes.dto.PedidoDetalleDTO;
import pe.edu.galaxy.training.java.sb.ms.msnegociogestionclientes.entity.PedidoCabeceraEntity;
import pe.edu.galaxy.training.java.sb.ms.msnegociogestionclientes.entity.PedidoDetalleEntity;
import pe.edu.galaxy.training.java.sb.ms.msnegociogestionclientes.mappers.PedidoMapper;
import pe.edu.galaxy.training.java.sb.ms.msnegociogestionclientes.repository.PedidoCabeceraRepository;
import pe.edu.galaxy.training.java.sb.ms.msnegociogestionclientes.service.client.clientes.ClienteDTO;
import pe.edu.galaxy.training.java.sb.ms.msnegociogestionclientes.service.client.clientes.ClienteService;

@Slf4j
@RequiredArgsConstructor
@Service
public class PedidoServiceImpl implements PedidoService {

	private final PedidoCabeceraRepository pedidoCabeceraRepository;

//	private final PedidoCabeceraRepository pedidoDetalleRepository;
	
	//@Autowired
	private final PedidoMapper pedidoMapper;
	
	private final ClienteService clienteService;
	
	@Override
	public List<PedidoCabeceraDTO> findByLikeObject(PedidoCabeceraDTO t) throws ServiceException {
		return null;
	}

	@Override
	public Optional<PedidoCabeceraDTO> findById(Long id) throws ServiceException {
		try {
			
			//return pedidoCabeceraRepository.findById(id);
			
			// Custom mapper
			/*
			
			Optional<PedidoCabeceraEntity> optPedidoCabeceraEntity=	pedidoCabeceraRepository.findById(id);
			
			if (optPedidoCabeceraEntity.isPresent()) {
				
				PedidoCabeceraEntity pedidoCabeceraEntity=optPedidoCabeceraEntity.get();
				
				PedidoCabeceraDTO pedidoCabeceraDTO=this.toDTO(pedidoCabeceraEntity);
				
				
				ClienteDTO clienteDTO=clienteService.findById(id);
				
				log.info("clienteDTO {}",clienteDTO);
				
				pedidoCabeceraDTO.setClienteDTO(clienteDTO);

				List<PedidoDetalleDTO> LstPedidoCabeceraDTO= pedidoCabeceraEntity.getListPedidoDetalle().stream().map(item -> this.toDTO(item)).toList();
				
				pedidoCabeceraDTO.setListPedidoDetalle(LstPedidoCabeceraDTO);
				
				return Optional.of(pedidoCabeceraDTO);
			}*/
			
			
			Optional<PedidoCabeceraEntity> optPedidoCabeceraEntity=	pedidoCabeceraRepository.findById(id); // Código
			
			if (optPedidoCabeceraEntity.isPresent()) {
				
				PedidoCabeceraEntity pedidoCabeceraEntity=optPedidoCabeceraEntity.get();
				
				PedidoCabeceraDTO pedidoCabeceraDTO=pedidoMapper.toDTO(pedidoCabeceraEntity);
				
				ClienteDTO clienteDTO=clienteService.findById(id);
				
				//log.info("clienteDTO {}",clienteDTO);
				
				pedidoCabeceraDTO.setClienteDTO(clienteDTO);

				//List<PedidoDetalleDTO> LstPedidoCabeceraDTO= pedidoCabeceraEntity.getListPedidoDetalle().stream().map(item -> this.toDTO(item)).toList();
				
				//pedidoCabeceraDTO.setListPedidoDetalle(LstPedidoCabeceraDTO);
				
				return Optional.ofNullable(pedidoCabeceraDTO);
			}
			
			
			return null;
			
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new ServiceException();
		}
		
	}

	@Override
	public PedidoCabeceraDTO save(PedidoCabeceraDTO  t) throws ServiceException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PedidoCabeceraDTO update(PedidoCabeceraDTO t) throws ServiceException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean delete(PedidoCabeceraDTO t) throws ServiceException {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	private PedidoCabeceraDTO toDTO(PedidoCabeceraEntity e) {
		
		return PedidoCabeceraDTO
				.builder()
				.id(e.getId())
				.glosa(e.getGlosa())
				.fechaRegistro(e.getFechaRegistro())
				.total(e.getTotal())
				.build();
		
	}
	
	private PedidoDetalleDTO toDTO(PedidoDetalleEntity e) {
		
		return PedidoDetalleDTO
				.builder()
				.id(e.getId())
				.idProducto(e.getIdProducto())
				.cantidad(e.getCantidad())
				.subTotal(e.getSubTotal())
				.build();
		
	}

}
