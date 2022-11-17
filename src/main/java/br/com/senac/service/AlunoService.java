package br.com.senac.service;

import java.util.List;
import java.util.Optional;
import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.com.senac.entity.Aluno;
import br.com.senac.repository.AlunoRepository;

@Service
public class AlunoService {
	
	@Autowired /*Autoriza o uso da classe*/
	private AlunoRepository alunoRepository;
	
	public List<Aluno> buscarTodosAlunos(){
		return alunoRepository.findAll();
	}
	
	public Aluno salvar(Aluno aluno) {
		return alunoRepository.save(aluno);
	}
	
	public Aluno buscarPorId(Integer id) throws ObjectNotFoundException{
		Optional<Aluno> aluno = alunoRepository.findById(id);
		return aluno.orElseThrow(() -> new ObjectNotFoundException(1L,"Aluno não encontrado."));
	}
	
	public void deletarPorId(Integer id) {
	    alunoRepository.deleteById(id);
	}
	
	public Aluno salvarAlteracao(Aluno alunoAlterado) {  
		Aluno aluno = buscarPorId(alunoAlterado.getId());
		aluno.setNome(alunoAlterado.getNome());
		aluno.setIdade(alunoAlterado.getIdade());
		aluno.setTurma(alunoAlterado.getTurma());
		return salvar(aluno);
	}
	
	public Aluno buscarPorNome(String nome) {
		Aluno aluno = alunoRepository.findByNome(nome);
		return aluno;
	}
	
	public List<Aluno> buscarAlunoComEndereco(){
		List<Aluno> lista = alunoRepository.buscarAlunoComEndereco();
		return lista;
	}
	
	public List<Aluno> buscaAlunoPeloNomeComEndereco(String nome){
		List<Aluno> lista = alunoRepository.buscaAlunoPeloNome(nome);
		return lista;
	}
}
