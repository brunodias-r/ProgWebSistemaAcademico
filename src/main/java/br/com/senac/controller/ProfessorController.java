package br.com.senac.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import br.com.senac.entity.Professor;
import br.com.senac.service.ProfessorService;

@Controller
@RequestMapping(value= "professores")
public class ProfessorController {
	
	@Autowired
	private ProfessorService professorService;
	
	@GetMapping(value= "/professores")
	public ModelAndView listarTodosAlunos() {
		ModelAndView mv = new ModelAndView("professores");
		List<Professor> professores = professorService.buscarTodosProfessores();
		mv.addObject("professores",professores);
		return mv;
	}
	
	
}
