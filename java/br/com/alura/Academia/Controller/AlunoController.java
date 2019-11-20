package br.com.alura.Academia.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import br.com.alura.Academia.Model.Aluno;
import br.com.alura.Academia.service.AlunoService;


@Controller
public class AlunoController <PlanoEntity>  {
	
	@Autowired
	private AlunoService service;

	
	
	@RequestMapping ("alunos")
	public String index() {
		return "index";
	}

	@RequestMapping("listaalunos")
	public String listaalunos(Model model) {
		Iterable<Aluno> alunos = service.obterTodos();
		model.addAttribute("alunos", alunos);
		return "listaalunos";		
			
		
	}
	@RequestMapping(value = "/salvaraluno", method = RequestMethod.POST)
		public String salvar(@RequestParam("matricula") String matricula, @RequestParam("nome") String nome, @RequestParam("rg") String rg,
			@RequestParam("cpf") String cpf, @RequestParam("endereco") String endereco, 
			@RequestParam("plano") String plano, @RequestParam("idPlano") String idPlano,
			@RequestParam("idAluno") String idAluno, 
			RedirectAttributes redirectAttrs, Model model){
	
		Aluno novoAluno = new Aluno(matricula, nome, rg, cpf, endereco, plano);
		
		if (idAluno != null && !"".equals(idAluno)) {
			novoAluno.setId(Long.valueOf(idAluno));
		}
		
		service.salvar(novoAluno);
		
		 Iterable<Aluno> alunos = service.obterTodos();
		 
		 model.addAttribute("alunos", alunos);	
		 
		 service.obterTodos();
		 redirectAttrs.addFlashAttribute("message", "Aluno Salvo com Sucesso!");
		return "redirect:listaalunos";
		}
	
	
	
	@RequestMapping("/editaraluno/{idaluno}")
	public ModelAndView editar(@PathVariable("idaluno") Long idaluno, RedirectAttributes redirectAttrs) {
		ModelAndView modelAndView = new ModelAndView("listaalunos");
		
		for (Aluno alunos : service.obterTodos()) {
			if (alunos.getId() == idaluno) {
				modelAndView.addObject("alunoEdit", alunos);
				
			}
		}
		redirectAttrs.addFlashAttribute("message", "Aluno Alterado com Sucesso!");
		return modelAndView;
			
	}
	
	
	
		
	@RequestMapping ( "/deletaraluno/{idaluno}")
	public String delete(@PathVariable String idaluno, RedirectAttributes redirectAttrs) {
	    service.deletar(idaluno);
	     redirectAttrs.addFlashAttribute("message", "Aluno Excluído com Sucesso!");	   
		return "redirect:/listaalunos";

	}


}
	

	
		
	








	


