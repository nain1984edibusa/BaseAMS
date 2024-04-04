package pe.edu.galaxy.training.java.sb.ms.msnegociogestionclientes.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.edu.galaxy.training.java.sb.ms.msnegociogestionclientes.entity.PedidoDetalleEntity;


@Repository
public interface PedidoDetalleRepository extends JpaRepository<PedidoDetalleEntity, Long>{

}
