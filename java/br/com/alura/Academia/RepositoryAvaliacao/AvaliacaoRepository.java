package br.com.alura.Academia.RepositoryAvaliacao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.alura.Academia.ModelAvaliacao.Avaliacao;



@Repository
@Transactional
public interface AvaliacaoRepository  extends CrudRepository<Avaliacao, String>  {
	

	static Avaliacao findOne(Long idavaliacao) {
		// TODO Auto-generated method stub
		return null;
	}
	
	



}

