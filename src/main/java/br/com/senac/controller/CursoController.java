package br.com.senac.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.senac.entity.Curso;
import br.com.senac.service.CursoService;
import br.com.senac.service.ProfessorService;

@Controller
@RequestMapping(value="curso")
public class CursoController {
	
	@Autowired
	private CursoService cursoService;
	
	@Autowired
	private ProfessorService professoreService;
	
	@GetMapping(value="/listarCursos")
	public ModelAndView listarTodosCursos() {
		ModelAndView mv = new ModelAndView("curso/listarCursos");
		mv.addObject("cursos",cursoService.buscarTodosCursos());
		mv.addObject("professores",professoreService.buscarTodosProfessores());/*Cardinalidade de professores*/
		return mv;
	}	
	
	@GetMapping("/cadastrarCurso")
	public ModelAndView cadastrarCurso(Curso curso) {
		ModelAndView mv = new ModelAndView("curso/cadastrarCurso");
		mv.addObject("curso",new Curso());
		mv.addObject("professores",professoreService.buscarTodosProfessores());/*Cardinalidade de professores*/
		return mv;
	}
	
	@PostMapping("/salvar")
	public ModelAndView salvar(Curso curso) {
		cursoService.salvar(curso);
		return listarTodosCursos();
	}
	
	@GetMapping("/excluir/{idx}")
	public ModelAndView excluirCurso(@PathVariable("idx") Integer id) {
		cursoService.deletarPorId(id);
		return listarTodosCursos();
	}
	
	@GetMapping("/paginaAlterar/{id}")
	public ModelAndView alterarCurso(@PathVariable("id") Integer id) {
		ModelAndView mv = new ModelAndView("curso/alterarCurso");
		mv.addObject("curso",cursoService.buscarPorId(id));
		mv.addObject("professores",professoreService.buscarTodosProfessores());/*Cardinalidade de professores*/
		return mv;
	}
	
	@PostMapping("/salvarAlteracao")
	public ModelAndView alterar(Curso cursoAlterado) {
		cursoService.salvarAlteracao(cursoAlterado);
		return listarTodosCursos();		
	}
	
}
