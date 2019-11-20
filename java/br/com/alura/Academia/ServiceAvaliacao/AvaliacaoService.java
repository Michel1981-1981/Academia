package br.com.alura.Academia.ServiceAvaliacao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.alura.Academia.ModelAvaliacao.Avaliacao;
import br.com.alura.Academia.RepositoryAvaliacao.AvaliacaoRepository;

@Service
public class AvaliacaoService {

	@Autowired
	private AvaliacaoRepository Repository;
	
	public Iterable<Avaliacao> obterTodos(){
		
		Iterable<Avaliacao> Avaliacao = Repository.findAll();
		
		return Avaliacao;
		
	}
		
	
	public void salvar(Avaliacao avaliacao) {
		Repository.save(avaliacao);
	}

	public void deletar(String idavaliacao) {
		Repository.deleteById(idavaliacao);
		
		
		
	

		
	}
}
