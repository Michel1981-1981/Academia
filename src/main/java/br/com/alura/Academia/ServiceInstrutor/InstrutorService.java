package br.com.alura.Academia.ServiceInstrutor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.alura.Academia.ModelInstrutor.Instrutor;
import br.com.alura.Academia.RepositoryInstrutor.InstrutorRepository;

@Service
public class InstrutorService {
	
	@Autowired
	private InstrutorRepository Repository;
	
	public Iterable<Instrutor> obterTodos(){
		
		Iterable<Instrutor> instrutores = Repository.findAll();
		
		return instrutores;
		
	}
	
	public void salvar(Instrutor instrutor) {
		Repository.save(instrutor);
	}

	
	public void deletar(Long idinstrutor) {
		Repository.deleteById(idinstrutor);
		
	}
}


