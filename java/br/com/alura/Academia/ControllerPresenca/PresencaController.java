package br.com.alura.Academia.ControllerPresenca;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.alura.Academia.ModelPresenca.Presenca;
import br.com.alura.Academia.ServicePresenca.PresencaService;

@Controller
public class PresencaController<idpresenca> {
	
	@Autowired
	private PresencaService service;
	
	@RequestMapping ("presenca")
	public String index() {
		return "index";
	}

	@RequestMapping("listapresencas")
	public String listapresencas(Model model) {
		Iterable<Presenca> presencas = service.obterTodos();
		model.addAttribute("presenca", presencas);
		return "listapresencas";		
			
		
	}
	
	@RequestMapping(value = "salvarpresenca", method = RequestMethod.POST)	
	public String salvar(@RequestParam("matricula") String matricula, @RequestParam("diaaula") String diaaula,				
		@RequestParam("idPresenca") String idPresenca, 			
		RedirectAttributes redirectAttrs, Model model){

	Presenca novaPresenca = new Presenca(matricula, diaaula);	
	
	if (idPresenca != null && !"".equals(idPresenca)) {
		novaPresenca.setId(Long.valueOf(idPresenca));
	}
	
	service.salvar(novaPresenca);

 Iterable<Presenca> presencas = service.obterTodos();	
	 
	 model.addAttribute("presenca", presencas);
	 
	 
 service.obterTodos();
	 redirectAttrs.addFlashAttribute("message", "Presença Salva com Sucesso!");	
	return "redirect:/listapresencas";
	}


	
	
	
	@RequestMapping("/editarpresenca/{idpresenca}")
	public ModelAndView editar(@PathVariable("idpresenca") Long idpresenca, RedirectAttributes redirectAttrs) {
		ModelAndView modelAndView = new ModelAndView("listapresencas");

		for (Presenca presenca : service.obterTodos()) {
			if (presenca.getId() == idpresenca) {
				modelAndView.addObject("presencaEdit", presenca);
			}
		}
		redirectAttrs.addFlashAttribute("message", "Presença Alterada com Sucesso!");	
		return modelAndView;
		
	}
	
		
	@RequestMapping ( "/deletarpresenca/{idpresenca}")
	public String delete(@PathVariable Long idpresenca, RedirectAttributes redirectAttrs) {
	    service.deletar(idpresenca);
	     redirectAttrs.addFlashAttribute("message", "Presença Excluída com Sucesso!");	   
		return "redirect:/listapresenca";

	}


}
	

	
		
	








	




