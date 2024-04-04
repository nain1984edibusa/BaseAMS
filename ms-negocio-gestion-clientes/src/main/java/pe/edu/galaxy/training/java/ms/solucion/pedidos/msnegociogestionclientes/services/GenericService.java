package pe.edu.galaxy.training.java.ms.solucion.pedidos.msnegociogestionclientes.services;

import java.util.List;
import java.util.Optional;

public interface GenericService<T> {

	List<T> findAll() throws ServiceException;
	
	List<T> findByLikeObject(T t) throws ServiceException;

	T save(T t) throws ServiceException;

	T update(T t) throws ServiceException;

	void delete(Long id) throws ServiceException;

	Optional<T> findById(Long id) throws ServiceException;
}
