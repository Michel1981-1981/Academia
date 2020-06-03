package br.com.alura.Academia.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.alura.Academia.Model.Aluno;
import br.com.alura.Academia.Repository.AlunoRepository;

@Service
public class AlunoService {

	@Autowired
	private AlunoRepository Repository;
	
	public Iterable<Aluno> obterTodos(){
		
		Iterable<Aluno> alunos = Repository.findAll();
		
		return alunos;
		
	}

			
	
	public void salvar(Aluno aluno) {
		Repository.save(aluno);
	}

	public void deletar(String idaluno) {
		Repository.deleteById(idaluno);
		
	
	}

	public static void addAluno(Object aluno) {
		// TODO Auto-generated method stub
		
	}
}
