package br.com.senac.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import br.com.senac.entity.Aluno;
import br.com.senac.service.AlunoService;
import br.com.senac.service.TurmaService;

@Controller
@RequestMapping("aluno") // http:localhost:8080/aluno
public class AlunoController {

	@Autowired
	private AlunoService alunoService;
	
	@Autowired
	private TurmaService turmaService;

	@GetMapping("/listarAlunos") // http://localhost:8080/aluno/listarAlunos
	public ModelAndView listarTodosAlunos() {
		ModelAndView mv = new ModelAndView("aluno/listarAlunos");
		mv.addObject("alunos", alunoService.buscarTodosAlunos());
		return mv;
	}

	@GetMapping("/cadastrarAluno") // http://localhost:8080/aluno/cadastrarAluno
	public ModelAndView cadastrarAluno(Aluno aluno) {
		ModelAndView mv = new ModelAndView("aluno/cadastrarAluno");
		mv.addObject("aluno", new Aluno());
		mv.addObject("listaTurma",turmaService.buscarTodasTurmas());
		return mv;
	}

	@PostMapping("/salvar")
	public ModelAndView salvarAluno(Aluno aluno) {
		alunoService.salvar(aluno);
		return listarTodosAlunos();
	}

	@GetMapping("/excluir/{idx}")
	public ModelAndView excluirAluno(@PathVariable("idx") Integer id) {
		alunoService.deletarPorId(id);
		return listarTodosAlunos();
	}
	
	@GetMapping("/paginaAlterar/{id}")
	public ModelAndView alterarAluno(@PathVariable("id") Integer id) {
		ModelAndView mv = new ModelAndView("aluno/alterarAluno");
		mv.addObject("aluno",alunoService.buscarPorId(id));
		mv.addObject("listaTurma",turmaService.buscarTodasTurmas());
		return mv;
	}
	
//	@PostMapping("/salvarAlteracao")
//	public ModelAndView alterar(Aluno alunoAlterado) {
//		alunoService.salvarAlteracao(alunoAlterado);
//		return listarTodosAlunos();
//	}
	
	@PostMapping("/salvarAlteracao")
	public ModelAndView alterar(Aluno alunoAlterado) {
		Aluno aluno = alunoService.buscarPorId(alunoAlterado.getId());
		aluno.setNome(alunoAlterado.getNome());
		aluno.setIdade(alunoAlterado.getIdade());
		aluno.setTurma(alunoAlterado.getTurma());
		return listarTodosAlunos();
	}
}
