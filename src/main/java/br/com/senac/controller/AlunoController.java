package br.com.senac.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import br.com.senac.entity.Aluno;
import br.com.senac.service.AlunoService;

@Controller
@RequestMapping("aluno") //http:localhost:8080/aluno
public class AlunoController {
	
	@Autowired
	private AlunoService alunoService;	
	
	@GetMapping("/listarAlunos") //http://localhost:8080/aluno/listarAlunos
	public ModelAndView listarTodosAlunos() {
		ModelAndView mv = new ModelAndView("aluno/paginaAlunos");
		mv.addObject("alunos",alunoService.buscarTodosAlunos());
		return mv;
	}
	
	@GetMapping("/cadastrarAluno") //http://localhost:8080/aluno/cadastrarAluno
	public ModelAndView cadastrarAluno(Aluno aluno) {
		ModelAndView mv = new ModelAndView("aluno/cadastrarAluno");
		mv.addObject("aluno",new Aluno());
		return mv;
	}
	
	@PostMapping("/salvar")
	public ModelAndView salvarAluno(Aluno aluno) {
		alunoService.salvar(aluno);
		return listarTodosAlunos();
	}
	
}
