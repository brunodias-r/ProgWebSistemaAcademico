package br.com.senac.inicializacao;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import br.com.senac.entity.Aluno;
import br.com.senac.service.AlunoService;

@Component
public class Init implements ApplicationListener<ContextRefreshedEvent>{
	
	@Autowired
	AlunoService alunoService;
	
//	@Autowired
//	AlunoRepository repo;
	
	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		Aluno aluno1 = new Aluno();
		aluno1.setNome("Lucas");
		
		Aluno aluno2 = new Aluno();
		aluno2.setNome("Arthur");
		
		Aluno aluno3 = new Aluno();
		aluno3.setNome("José");
		
		alunoService.salvar(aluno1);
		alunoService.salvar(aluno2);
		alunoService.salvar(aluno3);
		
		Aluno aluno4 = alunoService.buscarPorId(1);
		
		System.out.println("Aluno encontardo: "+aluno4.getNome());
		
		//alunoService.removerPorId(2);
//		
//		System.out.println("\nLista de todos os alunos: ");
//		List<Aluno> listarAlunos = alunoService.buscarTodosAlunos();
//		for (Aluno aluno : listarAlunos) {
//			System.out.println(aluno.getNome());
//		}
		//repo.saveAll(Arrays.asList(aluno1,aluno2,aluno3));
		
		Aluno alunoAlterado = new Aluno();
		alunoAlterado.setId(1);
		alunoAlterado.setNome("Lucas Silva");
		
		alunoService.salvarAlteracao(alunoAlterado);
	}

}
