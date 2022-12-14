package br.com.senac.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.senac.entity.Aluno;
import br.com.senac.entity.Turma;
import br.com.senac.service.CursoService;
import br.com.senac.service.TurmaService;

@Controller
@RequestMapping(value= "turma")
public class TurmaController {
	
	@Autowired
	private TurmaService turmaService;
	
	@Autowired
	private CursoService cursoService;
	
	@GetMapping(value= "/listarTurmas")
	public ModelAndView listarTodasTurmas() {
		ModelAndView mv = new ModelAndView("turma/listarTurmas");
		mv.addObject("turmas",turmaService.buscarTodasTurmas());
		return mv;
	}
	
	@GetMapping("/cadastrarTurma")
	public ModelAndView cadastrarTurma(Turma turma) {
		ModelAndView mv = new ModelAndView("turma/cadastrarTurma");
		mv.addObject("turma",new Turma());
		mv.addObject("listaCursos",cursoService.buscarTodosCursos());
		return mv;
	}
	
	@PostMapping("/salvar")
	public ModelAndView salvar(Turma turma) {
		turmaService.salvar(turma);
		return listarTodasTurmas();
	}
	
	@GetMapping("/excluir/{idx}")
	public ModelAndView excluirTurma(@PathVariable("idx") Integer id) {
		turmaService.deletarPorId(id);
		return listarTodasTurmas();
	}
	
	@GetMapping("/paginaAlterar/{id}")
	public ModelAndView alterarTruma(@PathVariable("id") Integer id) {
		ModelAndView mv = new ModelAndView("turma/alterarTurma");
		mv.addObject("turma",turmaService.buscarPorId(id));
		mv.addObject("listaCursos",cursoService.buscarTodosCursos());
		return mv;
	}
	
//	@PostMapping("/salvarAlteracao")
//	public ModelAndView alterar(Turma turmaAlterada) {
//		turmaService.salvarAlteracao(turmaAlterada);
//		return listarTodasTurmas();
//	}
	
	@PostMapping("/salvarAlteracao")
	public ModelAndView alterar(Turma turmaAlterada) {
		Turma turma = turmaService.buscarPorId(turmaAlterada.getId());
		turma.setTurno(turmaAlterada.getTurno());
		turma.setCursos(turmaAlterada.getCursos());
		return listarTodasTurmas();
	}
}
