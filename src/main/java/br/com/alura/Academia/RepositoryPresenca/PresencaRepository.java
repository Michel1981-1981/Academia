package br.com.alura.Academia.RepositoryPresenca;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.alura.Academia.ModelPresenca.Presenca;


	
	@Repository
	@Transactional
	public interface PresencaRepository  extends CrudRepository<Presenca, Long>  {


		void save(Iterable<Presenca> presenca);

		Presenca saveAndFlush(Presenca presenca);



	}
	

