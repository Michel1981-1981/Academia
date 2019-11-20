package br.com.alura.Academia.ServiceInstrutor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.alura.Academia.ModelInstrutor.Atividade;
import br.com.alura.Academia.RepositoryInstrutor.AtividadeRepository;

@Service
public class AtividadeService {
	
	@Autowired
	private AtividadeRepository Repository;
	
	public Iterable<Atividade> obterTodos(){
		
		Iterable<Atividade> atividades = Repository.findAll();
		
		return atividades;
		
	}
	
	public void salvar(Atividade atividade) {
		Repository.save(atividade);
	}

	
	public void deletar(Long idatividade) {
		Repository.deleteById(idatividade);
		
	}
}