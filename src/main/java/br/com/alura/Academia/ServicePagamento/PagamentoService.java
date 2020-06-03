package br.com.alura.Academia.ServicePagamento;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.alura.Academia.ModelPagamento.Pagamento;
import br.com.alura.Academia.RepositoryPagamento.PagamentoRepository;


@Service
public class PagamentoService {

	@Autowired
	private PagamentoRepository Repository;
	
	public Iterable<Pagamento> obterTodos(){
		
		Iterable<Pagamento> Pagamentos = Repository.findAll();
		
		return Pagamentos;
		
	}
	
	public void salvar(Pagamento pagamento) {
		Repository.save(pagamento);
	}

	public void deletar(String idpagamento) {
		Repository.deleteById(idpagamento);
				
	
	}
}


