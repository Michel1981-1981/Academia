package br.com.alura.Academia.RepositoryFerias;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.alura.Academia.ModelFerias.Ferias;

@Repository
@Transactional
public interface FeriasRepository  extends CrudRepository<Ferias, Long>  {


	void save(Iterable<Ferias> ferias);



}

