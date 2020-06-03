package br.com.alura.Academia.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.alura.Academia.Model.Aluno;


@Repository
@Transactional
public interface AlunoRepository  extends CrudRepository<Aluno, String>  {

	static void salvar(Aluno novoAluno) {
		// TODO Auto-generated method stub
		
	}

	
	
}
