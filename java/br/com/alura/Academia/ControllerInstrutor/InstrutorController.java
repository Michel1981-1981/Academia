package br.com.alura.Academia.ControllerInstrutor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.alura.Academia.ModelInstrutor.Instrutor;
import br.com.alura.Academia.ServiceInstrutor.InstrutorService;

@Controller
public class InstrutorController {

	@Autowired
	private InstrutorService service;

	@RequestMapping("instrutor")
	public String index() {
		return "index";
	}

	@RequestMapping("listainstrutores")
	public String listalunos(Model model) {
		Iterable<Instrutor> instrutores = service.obterTodos();
		model.addAttribute("instrutores", instrutores);
		model.addAttribute("instrutorobj", new Instrutor());
		return "listainstrutores";

	}

	@RequestMapping(value = "salvarinstrutor", method = RequestMethod.POST)
	public String salvar(@RequestParam("nome") String nome, @RequestParam("rg") String rg,
			@RequestParam("cpf") String cpf, @RequestParam("endereco") String endereco,
			@RequestParam("idInstrutor") String idInstrutor, RedirectAttributes redirectAttrs, Model model) {

		Instrutor novoInstrutor = new Instrutor(nome, rg, cpf, endereco);
		
		if (idInstrutor != null && !"".equals(idInstrutor)) {
			novoInstrutor.setId(Long.valueOf(idInstrutor));
		}
		
		service.salvar(novoInstrutor);

		Iterable<Instrutor> instrutores = service.obterTodos();

		model.addAttribute("instrutores", instrutores);
		model.addAttribute("instrutorobj", new Instrutor());
		service.obterTodos();
		 redirectAttrs.addFlashAttribute("message", "Instrutor Salvo com Sucesso!");
		return "redirect:listainstrutores";

	}

	@RequestMapping("/editarinstrutor/{idinstrutor}")
	public ModelAndView editar(@PathVariable("idinstrutor") Long idinstrutor, RedirectAttributes redirectAttrs) {
		ModelAndView modelAndView = new ModelAndView("listainstrutores");

		for (Instrutor instrutor : service.obterTodos()) {
			if (instrutor.getId() == idinstrutor) {
				modelAndView.addObject("instrutorEdit", instrutor);
			}
		}
		 redirectAttrs.addFlashAttribute("message", "Instrutor Alterado com Sucesso!");
		return modelAndView;
		
	}
		@RequestMapping ("/deletarinstrutor/{idinstrutor}")
		public String delete(@PathVariable Long idinstrutor, RedirectAttributes redirectAttrs) {
		    service.deletar(idinstrutor);
		     redirectAttrs.addFlashAttribute("message", "Instrutor Excluído com Sucesso!");	   
			return "redirect:/listainstrutores";
		}
	}
