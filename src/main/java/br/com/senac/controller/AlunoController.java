package br.com.senac.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import br.com.senac.entity.Aluno;
import br.com.senac.service.AlunoService;

@Controller
@RequestMapping("aluno")
public class AlunoController {
	
	@Autowired
	private AlunoService alunoService;	
	
	@GetMapping("/listarAlunos")
	public ModelAndView listarTodosAlunos() {
		ModelAndView mv = new ModelAndView("aluno/paginaAlunos");
		mv.addObject("alunos",alunoService.buscarTodosAlunos());
		return mv;
	}
	
	@GetMapping(value="/alunoPorId")
	public ModelAndView buscarPOrId(@PathVariable("id") Integer id) {
		ModelAndView mv = new ModelAndView("alunoPorId");
		Aluno aluno = alunoService.buscarPorId(id);
		mv.addObject("aluno",aluno);
		return mv;
	}
	
	@RequestMapping(value="/salvarAluno", method= RequestMethod.POST)
	public ModelAndView salvar(Aluno aluno) {
		ModelAndView mv = new ModelAndView("/salvarAluno");
		mv.addObject("aluno",alunoService.salvar(aluno));
		return mv;
	}
	
}

