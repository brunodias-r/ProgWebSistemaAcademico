package br.com.senac.service;

import java.util.List;
import java.util.Optional;
import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.senac.entity.Professor;
import br.com.senac.repository.ProfessorRepository;

@Service
public class ProfessorService {

    @Autowired
    private ProfessorRepository professorRepository;

    public List<Professor> buscarTodosProfessores() {
        return professorRepository.findAll();
    }

    public Professor salvar(Professor professor) {
        return professorRepository.save(professor);
    }

    public Professor buscarPorId(Integer id) {
        String resposta = "Professor não encontrado";
        Optional<Professor> professor = professorRepository.findById(id);
        return professor.orElseThrow(() -> new ObjectNotFoundException(1L, resposta));
    }

    public void deletarPorId(Integer id) {
        professorRepository.deleteById(id);
    }

    public Professor salvarAlteracao(Professor professorAlterado) {
        Professor professor = buscarPorId(professorAlterado.getId());
        professor.setNome(professorAlterado.getNome());
        professor.setIdade(professorAlterado.getIdade());
        return salvar(professor);
    }

    public Professor buscarPorNome(String nome) {
        Professor professor = professorRepository.findByNome(nome);
        return professor;
    }

    public List<Professor> buscarProfessorComLivro() {
        List<Professor> lista = professorRepository.buscarProfessorComLivro();
        return lista;
    }

    public List<Professor> buscaProfessorPeloNomeComLivro(String nome) {
        List<Professor> lista = professorRepository.buscarProfessorPeloNome(nome);
        return lista;
    }
}
