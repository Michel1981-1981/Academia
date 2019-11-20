package br.com.alura.Academia.ControllerAtividade;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.alura.Academia.ModelInstrutor.Atividade;
import br.com.alura.Academia.RepositoryInstrutor.InstrutorRepository;
import br.com.alura.Academia.ServiceInstrutor.AtividadeService;

@Controller
public class AtividadeController<InstrutorEntity, Instrutor> {

	
	@Autowired
	private AtividadeService service;
	private InstrutorRepository instrutorRepository;
	@RequestMapping ("atividade")
	public String index() {
		return "index";
	}

	@RequestMapping("listaatividades")
	public String listaatividades(Model model) {
		Iterable<Atividade> atividades = service.obterTodos();
		model.addAttribute("atividades", atividades);
		return "listaatividades";	
		
	}
	

	
	@Query(name="listainstrutores",value="SELECT p FROM instrutores")

	
	@RequestMapping(value = "salvaratividade", method = RequestMethod.POST)
		public String salvar(@RequestParam("aula") String aula, @RequestParam("horario") String horario,
			@RequestParam("dia") String diadasemana,
			@RequestParam("instrutor") String instrutor,
			@RequestParam("sala") String sala, @RequestParam("tipoaula") String tipoaula,
			@RequestParam("idAtividade") String idAtividade,
			RedirectAttributes redirectAttrs, Model model){
	
		Atividade novaAtividade = new Atividade(aula, horario, instrutor, diadasemana, sala, tipoaula);	
		
		if (idAtividade != null && !"".equals(idAtividade)) {
			novaAtividade.setId(Long.valueOf(idAtividade));
		}
		
		service.salvar(novaAtividade);
		
		 Iterable<Atividade> atividades = service.obterTodos();
		 
		 model.addAttribute("atividades", atividades);	
		 
		 
		 service.obterTodos();
		 redirectAttrs.addFlashAttribute("message", "Atividade Salva com Sucesso!");	
		return "redirect:listaatividades";
		}
	

	
	@RequestMapping("/editaratividade/{idatividade}")
	public ModelAndView editar(@PathVariable("idatividade") Long idatividade, String idinstrutor, RedirectAttributes redirectAttrs) {
		ModelAndView modelAndView = new ModelAndView("listaatividades");

		for (Atividade atividade : service.obterTodos()) {
			if (atividade.getId() == idatividade) {
				modelAndView.addObject("atividadeEdit", atividade);
				
			}
		}
			
		
    	redirectAttrs.addFlashAttribute("message", "Atividade Alterada com Sucesso!");	
		return modelAndView;
		
	}
	

	
	
		@RequestMapping ("/deletaratividade/{idatividade}")
		public String delete(@PathVariable Long idatividade, RedirectAttributes redirectAttrs) {
		    service.deletar(idatividade);
		     redirectAttrs.addFlashAttribute("message", "Atividade Excluída com Sucesso!");	   
			return "redirect:/listainstrutores";
		}

		public InstrutorRepository getInstrutorRepository() {
			return instrutorRepository;
		}

		public void setInstrutorRepository(InstrutorRepository instrutorRepository) {
			this.instrutorRepository = instrutorRepository;
		}
	}

	

