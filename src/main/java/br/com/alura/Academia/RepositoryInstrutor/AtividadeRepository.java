package br.com.alura.Academia.RepositoryInstrutor;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.alura.Academia.ModelInstrutor.Atividade;


@Repository
@Transactional
public interface AtividadeRepository extends CrudRepository<Atividade, Long> {

	void save(Iterable<Atividade> atividade);

}
