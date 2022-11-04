package br.com.senac.inicializacao;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import br.com.senac.entity.Aluno;
import br.com.senac.entity.AlunoCurso;
import br.com.senac.entity.Avaliacao;
import br.com.senac.entity.Curso;
import br.com.senac.entity.Endereco;
import br.com.senac.entity.Professor;
import br.com.senac.entity.Turma;
import br.com.senac.repository.ProfessorRepository;
import br.com.senac.repository.TurmaRepository;
import br.com.senac.service.AlunoService;
import br.com.senac.service.AvaliacaoService;
import br.com.senac.service.CursoService;
import br.com.senac.service.EnderecoService;
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
	
	@Autowired
	private AvaliacaoService avaliacaoService;
	
	@Autowired
	private TurmaRepository turmaRepository;
	
	@Autowired
	private EnderecoService enderecoService;
	
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
	/********************************************************************************************************/	
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
		p3.setNome("Kratos");
		p3.setIdade(36);
		

		
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

		List<Curso> listaCursos1 = new ArrayList();
		listaCursos1.add(curso1);
		listaCursos1.add(curso2);
		
		List<Curso> listaCursos2 = new ArrayList();
		listaCursos2.add(curso2);
		listaCursos2.add(curso3);
		
		List<Curso> listaCursos3 = new ArrayList();
		listaCursos3.add(curso1);
		listaCursos3.add(curso3);
		
		Turma turma1 = new Turma();
		turma1.setTurno("turma 1");
		turma1.setCursos(listaCursos1);
		
		Turma turma2 = new Turma();
		turma2.setTurno("turma 2");
		turma2.setCursos(listaCursos2);

		Turma turma3 = new Turma();
		turma3.setTurno("turma 3");
		turma3.setCursos(listaCursos3);
		
		turmaService.salvar(turma1);
		turmaService.salvar(turma2);
		turmaService.salvar(turma3);
		
		Aluno aluno1 = new Aluno();		
		aluno1.setNome("Lucas");
		aluno1.setIdade(13);
		aluno1.setTurma(turma3);
		
		Aluno aluno2 = new Aluno();
		aluno2.setNome("Arthur");
		aluno2.setIdade(15);
		aluno2.setTurma(turma2);
		
		Aluno aluno3 = new Aluno();
		aluno3.setNome("José");
		aluno3.setIdade(20);
		aluno3.setTurma(turma1);
		
		Aluno aluno4 = new Aluno();		
		aluno4.setNome("Walter");
		aluno4.setIdade(13);
		aluno4.setTurma(turma3);
		
		alunoService.salvar(aluno1);
		alunoService.salvar(aluno2);
		alunoService.salvar(aluno3);
		alunoService.salvar(aluno4);
		
		Avaliacao avaliacao01 = new Avaliacao();
		AlunoCurso alunoCurso01 = new AlunoCurso();
		alunoCurso01.setAluno(aluno1);
		alunoCurso01.setCurso(curso3);
		
		avaliacao01.setAlunoCurso(alunoCurso01);
		avaliacao01.setConceito("I");
		
		avaliacaoService.save(avaliacao01);
		
//		List<Turma> listaTurmas = turmaService.buscarTodasTurmas();
//		for(Turma turma : listaTurmas) {
//			System.out.println(turma.getTurno());
//			for(Aluno aluno : turma.getAlunos()) {
//				System.out.println(aluno.getNome());
//			}
//		}		
		
//		List<Turma> listaTurmas = turmaRepository.findAllByIdTurma(3);
//		for(Turma turma : listaTurmas) {			
//			for(Aluno aluno : turma.getAlunos()) {
//				System.out.println(aluno.getNome());
//			}
//		}
		
		Endereco endereco1 = new Endereco();
		endereco1.setRua("Rua Sacadura Cabral");
		endereco1.setNumero(125);
		endereco1.setBairro("Leme");
		endereco1.setComplemento("Praia");
		endereco1.setCep("21536487");
		endereco1.setAluno(aluno1);
		enderecoService.salvar(endereco1);
		
		Endereco endereco2 = new Endereco();
		endereco2.setRua("Rua Visconde de Sepetiba");
		endereco2.setNumero(196);
		endereco2.setBairro("Porto Maravilha");
		endereco2.setComplemento("Santo Cristo");
		endereco2.setCep("18241589");
		endereco2.setAluno(aluno1);
		enderecoService.salvar(endereco2);
		
		//Forma errada
		Aluno al1 = alunoService.buscarPorNome("Lucas");
		al1.getEnderecos().forEach((e) -> System.out.println("Rua: " + e.getRua() + ", " + e.getNumero() + ", " + e.getComplemento() + ", " +  e.getBairro()));
		
		
		
		//System.out.println("Funcionando");// repo.saveAll(Arrays.asList(aluno1,aluno2,aluno3));
		/********************************************************************************************************************/
		

//		Curso curso1 = new Curso();
//		curso1.setNome("Angular");
//		Curso curso2 = new Curso();
//		curso2.setNome("Java");
//		Curso curso3 = new Curso();
//		curso3.setNome("Python");
//		Curso curso4 = new Curso();
//		curso4.setNome("NodeJS");
//
//		Professor p1 = new Professor(); 
//		p1.setNome("Erivaldo");
//		p1.setIdade(35);
//		Professor p2 = new Professor();
//		p2.setNome("Joao");
//		p2.setIdade(36);
//		Professor p3 = new Professor();
//		p3.setNome("Claudio");
//		p3.setIdade(39);
//		Professor p4 = new Professor();
//		p4.setNome("Junior");
//		p4.setIdade(31);
//
//		professorService.salvar(p1);
//		professorService.salvar(p2);
//		professorService.salvar(p3);
//		professorService.salvar(p4);
//		
//		Curso curso1 = new Curso();
//		curso1.setNome("NodeJs");
//		Curso curso2 = new Curso();
//		curso2.setNome("ASP.NET");
//		Curso curso3 = new Curso();
//		curso3.setNome("Spring Boot");
//		Curso curso4 = new Curso();
//		curso4.setNome("Angular");
//
//		List<Curso> listaCursos1 =  new ArrayList<>();
//		listaCursos1.add(curso1);
//		listaCursos1.add(curso4);
//
//		List<Curso> listaCursos2 =  new ArrayList<>();
//		listaCursos2.add(curso1);
//		listaCursos2.add(curso3);
//
//		List<Curso> listaCursos3 =  new ArrayList<>();
//		listaCursos3.add(curso1);
//		listaCursos3.add(curso3);
//
//		curso1.setProfessor(p1);
//		curso2.setProfessor(p3);
//		curso3.setProfessor(p2);
//		curso4.setProfessor(p4);
//		cursoService.salvar(curso1);
//		cursoService.salvar(curso2);
//		cursoService.salvar(curso3);
//		cursoService.salvar(curso4);
//
//		Turma t1 = new Turma();
//		t1.setTurno("turma 1");
//		t1.setCursos(listaCursos1);
//		Turma t2 = new Turma();
//		t2.setTurno("turma 2");
//		t2.setCursos(listaCursos2);
//		Turma t3 = new Turma();
//		t3.setTurno("turma 3");
//		t3.setCursos(listaCursos3);
//		turmaService.salvar(t1);
//		turmaService.salvar(t2);
//		turmaService.salvar(t3);	
//		
//		List<Curso> listaCursos1 = new ArrayList();
//		listaCursos1.add(curso1);
//		listaCursos1.add(curso4);
//		
//		List<Curso> listaCursos2 = new ArrayList();
//		listaCursos2.add(curso2);
//		listaCursos2.add(curso3);
//		
//		List<Curso> listaCursos3 = new ArrayList();
//		listaCursos3.add(curso1);
//		listaCursos3.add(curso3);
//		
//		Turma turma1 = new Turma();
//		turma1.setTurno("turma 1");
//		turma1.setCursos(listaCursos1);
//		
//		Turma turma2 = new Turma();
//		turma2.setTurno("turma 2");
//		turma1.setCursos(listaCursos2);
//
//		Turma turma3 = new Turma();
//		turma3.setTurno("turma 3");
//		
//		turmaService.salvar(turma1);
//		turmaService.salvar(turma2);
//		turmaService.salvar(turma3);
//		
//		Aluno aluno1 = new Aluno();		
//		aluno1.setNome("Lucas");
//		aluno1.setIdade(13);
//		aluno1.setTurma(turma3);
		
//		Aluno aluno2 = new Aluno();
//		aluno2.setNome("Arthur");
//		aluno2.setIdade(15);
//		aluno2.setTurma(turma2);
//		
//		Aluno aluno3 = new Aluno();
//		aluno3.setNome("José");
//		aluno3.setIdade(20);
//		aluno3.setTurma(turma1);
//		
//		alunoService.salvar(aluno1);
//		alunoService.salvar(aluno2);
//		alunoService.salvar(aluno3);
//		//System.out.println("Funcionando");// repo.saveAll(Arrays.asList(aluno1,aluno2,aluno3));
//		
//		
//		Aluno aluno1 = new Aluno();		
//		aluno1.setNome("Lucas Santanna");
//		aluno1.setIdade(13);
//		aluno1.setTurma(t3);
//		
//		Aluno aluno2 = new Aluno();
//		aluno2.setNome("Arthur Goméz");
//		aluno2.setIdade(15);
//		aluno2.setTurma(t2);
//		
//		Aluno aluno3 = new Aluno();
//		aluno3.setNome("José Mendoza");
//		aluno3.setIdade(20);
//		aluno3.setTurma(t1);
//		
//		alunoService.salvar(aluno1);
//		alunoService.salvar(aluno2);
//		alunoService.salvar(aluno3);
			
	}

}
