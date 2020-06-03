package br.com.alura.Academia.ServicePresenca;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.com.alura.Academia.ModelPresenca.Presenca;
import br.com.alura.Academia.RepositoryPresenca.PresencaRepository;

@Service
public class PresencaService {
	

	@Autowired
	private PresencaRepository Repository;
	
	public Iterable<Presenca> obterTodos(){
		
		Iterable<Presenca> Presenca = Repository.findAll();
		
		return Presenca;
		
	}
	
	public void salvar(Presenca novaPresenca) {
		Repository.save(novaPresenca);
	}

	public void deletar(Long idpresenca) {
		Repository.deleteById(idpresenca);
				
	
	}
}




