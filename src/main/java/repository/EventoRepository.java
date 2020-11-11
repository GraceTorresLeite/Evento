package repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import models.Evento;

public interface EventoRepository  extends CrudRepository<Evento,String>{
	
	Evento findByCodigo(Long codigo);

}
