package br.com.alura.Academia.ControllerFerias;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.alura.Academia.ModelFerias.Ferias;
import br.com.alura.Academia.ServiceFerias.FeriasService;

@Controller
public class FeriasController {
	
	@Autowired
	private FeriasService service;
	
	@RequestMapping ("ferias")
	public String index() {
		return "index";
	}

	@RequestMapping("listaferias")
	public String listaferias(Model model) {
		Iterable<Ferias> ferias = service.obterTodos();
		model.addAttribute("ferias", ferias);
		return "listaferias";		
			
		
	}
	
	@RequestMapping(value = "salvarferias", method = RequestMethod.POST)	
	public String salvar(@RequestParam("matricula") String matricula, @RequestParam("dataini") String dataini,
		@RequestParam("numdias") String numdias, 		 			
		@RequestParam("idFerias") String idFerias, 			
		RedirectAttributes redirectAttrs, Model model){

	Ferias novaFerias = new Ferias(matricula, dataini, numdias);	
	
	if (idFerias != null && !"".equals(idFerias)) {
		novaFerias.setId(Long.valueOf(idFerias));
	}
	
	service.salvar(novaFerias);

 Iterable<Ferias> ferias = service.obterTodos();	
	 
	 model.addAttribute("ferias", ferias);
	 
	 
 service.obterTodos();
	 redirectAttrs.addFlashAttribute("message", "Férias Salva com Sucesso!");	
	return "redirect:/listaferias";
	}


	
	
	
	@RequestMapping(value="/editarferias/{idferias}", method = RequestMethod.GET)
	public ModelAndView editar(@PathVariable("idferias") Long idferias, RedirectAttributes redirectAttrs) {
		ModelAndView modelAndView = new ModelAndView("listaferias");
		
		for (Ferias ferias : service.obterTodos()) {
			if (ferias.getId() == idferias) {
				modelAndView.addObject("feriasEdit", ferias);
				
			}
		}
		redirectAttrs.addFlashAttribute("message", "Férias Alteradas com Sucesso!");
		return modelAndView;
			
	}
	
		
	@RequestMapping ( "/deletarferias/{idferias}")
	public String delete(@PathVariable Long idferias, RedirectAttributes redirectAttrs) {
	    service.deletar(idferias);
	     redirectAttrs.addFlashAttribute("message", "Férias Excluídas com Sucesso!");	   
		return "redirect:/listaferias";

	}


}
	

	
		
	








	



