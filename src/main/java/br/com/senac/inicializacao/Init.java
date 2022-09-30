package br.com.senac.inicializacao;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import br.com.senac.entity.Aluno;
import br.com.senac.entity.Curso;
import br.com.senac.entity.Professor;
import br.com.senac.entity.Turma;
import br.com.senac.repository.ProfessorRepository;
import br.com.senac.service.AlunoService;
import br.com.senac.service.CursoService;
import br.com.senac.service.ProfessorService;
import br.com.senac.service.TurmaService;

@Component
public class Init implements ApplicationListener<ContextRefreshedEvent> {

	@Autowired
	private AlunoService alunoService;

	@Autowired
	private CursoService cursoService;
	
	@Autowired
	private ProfessorService professorService;
	
	@Autowired
	private TurmaService turmaService;
	
	//@Autowired
	//private ProfessorRepository professorRepository;
	
	// @Autowired
	//private AlunoRepository repo;

	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
//		Aluno aluno1 = new Aluno();		
//		aluno1.setNome("Lucas");
//		aluno1.setIdade(13);
//		Aluno aluno2 = new Aluno();
//		aluno2.setNome("Arthur");
//		aluno2.setIdade(15);
//		Aluno aluno3 = new Aluno();
//		aluno3.setNome("José");
//		aluno3.setIdade(20);
//		alunoService.salvar(aluno1);
//		alunoService.salvar(aluno2);
//		alunoService.salvar(aluno3);
//		
//		Professor professor1 = new Professor();
//		professor1.setNome("Carlos Eduardo");
//		professor1.setIdade(32);
//		Professor professor2 = new Professor();
//		professor2.setNome("João Pedro");
//		professor2.setIdade(30);
//		Professor professor3 = new Professor();
//		professor3.setNome("Maria Fernanda");
//		professor3.setIdade(28);
//		professorService.salvar(professor1);
//		professorService.salvar(professor2);
//		professorService.salvar(professor3);
//		
//		Curso curso1 = new Curso();
//		curso1.setNome("Angular");
//		Curso curso2 = new Curso();
//		curso2.setNome("Java");
//		Curso curso3 = new Curso();
//		curso3.setNome("Python");
//		cursoService.salvar(curso1);
//		cursoService.salvar(curso2);
//		cursoService.salvar(curso3);
//		
//		Turma turma1 = new Turma();
//		turma1.setTurno("Manhã");
//		Turma turma2 = new Turma();
//		turma2.setTurno("Tarde");
//		Turma turma3 = new Turma();
//		turma3.setTurno("Noite");
//		turmaService.salvar(turma1);
//		turmaService.salvar(turma2);
//		turmaService.salvar(turma3);

		
//		Aluno aluno4 = alunoService.buscarPorId(1);
//
//		System.out.println("Aluno encontardo: " + aluno4.getNome());
//
//		alunoService.removerPorId(2);
//
//		System.out.println("\nLista de todos os alunos: ");
//		List<Aluno> listarAlunos = alunoService.buscarTodosAlunos();
//		for (Aluno aluno : listarAlunos) {
//			System.out.println(aluno.getNome());
//		}
		
		Curso curso1 = new Curso();
		curso1.setNome("Angular");
		Curso curso2 = new Curso();
		curso2.setNome("Java");
		Curso curso3 = new Curso();
		curso3.setNome("Python");
				
		Professor p1 = new Professor(); 
		p1.setNome("Erivaldo");
		p1.setIdade(35);
		
		Professor p2 = new Professor(); 
		p2.setNome("Ana Karla");
		p2.setIdade(28);
		
		Professor p3 = new Professor(); 
		p2.setNome("Kratos");
		p2.setIdade(36);
		
		professorService.salvar(p1);
		professorService.salvar(p2);
		professorService.salvar(p3);

		//professorRepository.saveAll(Arrays.asList(p1,p2,p3));
		
		curso1.setProfessor(p1);
		curso2.setProfessor(p2);
		curso3.setProfessor(p3);

		cursoService.salvar(curso1);
		cursoService.salvar(curso2);
		cursoService.salvar(curso3);
		
		//System.out.println("Funcionando");// repo.saveAll(Arrays.asList(aluno1,aluno2,aluno3));
		
	}

}
