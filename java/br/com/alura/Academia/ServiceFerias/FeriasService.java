package br.com.alura.Academia.ServiceFerias;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.alura.Academia.ModelFerias.Ferias;
import br.com.alura.Academia.RepositoryFerias.FeriasRepository;

@Service
public class FeriasService {

	@Autowired
	private FeriasRepository Repository;
	
	public Iterable<Ferias> obterTodos(){
		
		Iterable<Ferias> Ferias = Repository.findAll();
		
		return Ferias;
		
	}
	
	public void salvar(Ferias novaFerias) {
		Repository.save(novaFerias);
	}

	public void deletar(Long idferias) {
		Repository.deleteById(idferias);
				
	
	}
}



