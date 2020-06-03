package br.com.alura.Academia.ControllerAvaliacao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.alura.Academia.ModelAvaliacao.Avaliacao;
import br.com.alura.Academia.ServiceAvaliacao.AvaliacaoService;

@Controller
public class AvaliacaoController{
	
	@Autowired
	private AvaliacaoService service;
	
	@RequestMapping ("avaliacao")
	public String index() {
		return "index";
	}
	
	
	@RequestMapping("listaavaliacao")
	public String listaavaliacao(Model model) {
		Iterable<Avaliacao> avaliacao = service.obterTodos();
		model.addAttribute("avaliacao", avaliacao);
		return "listaavaliacao";		
			
		
	}
	
	
	@RequestMapping(value = "salvaravaliacao", method = RequestMethod.POST)
		public String salvar(@RequestParam("matricula") String matricula, @RequestParam("exame") String exame,
				@RequestParam ("dataavaliacao") String dataavaliacao,
			@RequestParam("idavaliacao") String idavaliacao, 			
			RedirectAttributes redirectAttrs, Model model){	
		
		Avaliacao novaAvaliacao = new Avaliacao(matricula, exame, dataavaliacao);
		
		if (idavaliacao != null && !"".equals(idavaliacao)) {
			novaAvaliacao.setId(Long.valueOf(idavaliacao));
		}
		
		service.salvar(novaAvaliacao);
		
		 Iterable<Avaliacao> avaliacao = service.obterTodos();
		 
		 model.addAttribute("avaliacao", avaliacao);	
		 
		 service.obterTodos();
		 redirectAttrs.addFlashAttribute("message", "Avaliação Física Salva com Sucesso!");
		return "redirect:listaavaliacao";
		}

	
	
	
	@RequestMapping("/editaravaliacao/{idavaliacao}")	
		public ModelAndView editar(@PathVariable("idavaliacao") Long idavaliacao, RedirectAttributes redirectAttrs) {
			ModelAndView modelAndView = new ModelAndView("listaavaliacao");

			for (Avaliacao avaliacao : service.obterTodos()) {
				if (avaliacao.getId() == idavaliacao) {
					modelAndView.addObject("avaliacaoEdit", avaliacao);
				}
			}
			redirectAttrs.addFlashAttribute("message", "Avaliação Alterada com Sucesso!");	
			return modelAndView;
			
	}
	
		
	@RequestMapping ( "/deletaravaliacao/{idavaliacao}")
	public String delete(@PathVariable String idavaliacao, RedirectAttributes redirectAttrs) {
	    service.deletar(idavaliacao);
	     redirectAttrs.addFlashAttribute("message", "Avaliação Física Excluída com Sucesso!");	   
		return "redirect:/listaavaliacao";

	}


}
	

	
		
	








	


