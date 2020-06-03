package br.com.alura.Academia.RepositoryInstrutor;

import java.util.Optional;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.alura.Academia.ModelInstrutor.Instrutor;



@Repository
@Transactional
public interface InstrutorRepository extends CrudRepository<Instrutor, Long> {

	void save(Iterable<Instrutor> instrutor);

	static Optional<Instrutor> FindById(Long idinstrutor) {
		// TODO Auto-generated method stub
		return null;
	}

	static Optional<Instrutor> FindById(Optional<Instrutor> instrutor) {
		// TODO Auto-generated method stub
		return null;
	}

	static Optional<Instrutor> finfAll(Long idinstrutor) {
		// TODO Auto-generated method stub
		return null;
	}

	static Instrutor findOne(Object nome) {
		// TODO Auto-generated method stub
		return null;
	}
	

}
