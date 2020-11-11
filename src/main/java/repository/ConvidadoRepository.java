package repository;

import org.springframework.data.repository.CrudRepository;

import models.Convidado;
import models.Evento;

public interface ConvidadoRepository extends CrudRepository<Convidado, String> {
	
	Iterable<Convidado> findByEvento(Evento evento);

}
