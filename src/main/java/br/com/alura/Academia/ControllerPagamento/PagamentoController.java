package br.com.alura.Academia.ControllerPagamento;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import br.com.alura.Academia.ModelPagamento.Pagamento;
import br.com.alura.Academia.ServicePagamento.PagamentoService;

@Controller
public class PagamentoController {
	
		
	@Autowired
	private PagamentoService service;
	
	
	@RequestMapping ("pagamento")
	public String index() {
		return "index";
	}

	@RequestMapping("listapagamentos")
	public String listapagamentos(Model model) {
		Iterable<Pagamento> pagamentos = service.obterTodos();
		model.addAttribute("pagamentos", pagamentos);
		return "/listapagamentos";	
						
		
	}
	
		
	@RequestMapping(value = "salvarpagamento", method = RequestMethod.POST)	
		public String salvar(@RequestParam("matricula") String matricula, @RequestParam("plano") String plano,
			@RequestParam("valor") String valor, 
			@RequestParam("datapagamento") String datapagamento, 			
			@RequestParam("proximopagamento") String proximopagamento, @RequestParam("idPagamento") String idPagamento, 			
			RedirectAttributes redirectAttrs, Model model){
	
		Pagamento novoPagamento = new Pagamento(matricula, plano, valor, datapagamento, proximopagamento);	
		
		if (idPagamento != null && !"".equals(idPagamento)) {
			novoPagamento.setId(Long.valueOf(idPagamento));
		}
		
		service.salvar(novoPagamento);

	 Iterable<Pagamento> pagamentos = service.obterTodos();	
		 
		 model.addAttribute("pagamentos", pagamentos);
		 
		 
	 service.obterTodos();
		 redirectAttrs.addFlashAttribute("message", "Pagamento Salvo com Sucesso!");	
		return "redirect:/listapagamentos";
		}
	
	
	@RequestMapping("/editarpagamento/{idpagamento}")
	public ModelAndView editar(@PathVariable("idpagamento") Long idpagamento, RedirectAttributes redirectAttrs) {
		ModelAndView modelAndView = new ModelAndView("listapagamentos");

		for (Pagamento pagamento : service.obterTodos()) {
			if (pagamento.getId() == idpagamento) {
				modelAndView.addObject("pagamentoEdit", pagamento);
			}
		}
		redirectAttrs.addFlashAttribute("message", "Pagamento Alterado com Sucesso!");	
		return modelAndView;
		
		
	}
		@RequestMapping ("/deletarpagamento/{idpagamento}")
		public String delete(@PathVariable String idpagamento, RedirectAttributes redirectAttrs) {
		    service.deletar(idpagamento);
		     redirectAttrs.addFlashAttribute("message", "Pagamento Excluído com Sucesso!");	   
			return "redirect:/listapagamentos";
		}
	}

	

