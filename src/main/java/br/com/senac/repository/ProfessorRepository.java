package br.com.senac.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.senac.entity.Professor;

@Repository
public interface ProfessorRepository extends JpaRepository<Professor, Integer>{

    Professor findByNome(String nome);
    
    @Query(value = "SELECT DISTINCT p FROM Professor p JOIN FETCH p.livros b")
    List<Professor> buscarProfessorComLivro();
    
    @Query(value = "SELECT DISTINCT p FROM Professor p JOIN FETCH p.livros b WHERE b.nome = ?1")
    List<Professor> buscarProfessorPeloNome(String nome);
    
}
