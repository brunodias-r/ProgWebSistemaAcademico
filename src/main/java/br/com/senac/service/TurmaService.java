package br.com.senac.service;

import java.util.List;
import java.util.Optional;

import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.senac.entity.Turma;
import br.com.senac.repository.TurmaRepository;

@Service
public class TurmaService {
	
	@Autowired
	TurmaRepository repo;
	
	public List<Turma> buscaTodasTurmas(){
		return repo.findAll();
	}
	
	public Turma salvar(Turma turma) {
		return repo.save(turma);
	}
	
	public Turma buscarPorId(Integer id) throws ObjectNotFoundException{
		Optional<Turma> turma = repo.findById(id);
		return turma.orElseThrow(() -> new ObjectNotFoundException(1L,"Turma não encontrado."));
	}
	
	public void removerPorId(Integer id) {
		repo.deleteById(id);
	}
	
	public Turma salvarAlteracao(Turma turmaAlterada) {
		Turma turma = buscarPorId(turmaAlterada.getNumero());
		turma.setTurno(turmaAlterada.getTurno());
		return salvar(turma);
	}
}
