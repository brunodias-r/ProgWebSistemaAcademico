package br.com.senac.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import br.com.senac.entity.Turma;
import br.com.senac.service.TurmaService;

@Controller
@RequestMapping(value= "turmas")
public class TurmaController {
	
	@Autowired
	private TurmaService turmaService;
	
	@GetMapping(value= "/turmas")
	public ModelAndView listarTodasTurmas() {
		ModelAndView mv = new ModelAndView("turmas");
		List<Turma> turmas = turmaService.buscarTodasTurmas();
		mv.addObject("turmas",turmas);
		return mv;
	}
	
}
