package br.com.alura.Academia.RepositoryPagamento;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.alura.Academia.ModelPagamento.Pagamento;


@Repository
@Transactional
public interface PagamentoRepository  extends CrudRepository<Pagamento, String>  {



	static Pagamento findOne(Long idpagamento) {
		// TODO Auto-generated method stub
		return null;
	}



}
