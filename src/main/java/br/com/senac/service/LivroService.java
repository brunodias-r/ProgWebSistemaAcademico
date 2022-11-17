package br.com.senac.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.senac.entity.Livro;
import br.com.senac.entity.Professor;
import br.com.senac.repository.LivroRepository;

@Service
public class LivroService {
    
    @Autowired
    private LivroRepository livroRepository;
    
    public List<Livro> buscarTodosLivros(){
        return livroRepository.findAll();
    }
    
    public Livro salvar(Livro livro) {
        return livroRepository.save(livro);
    }
    
    public List<Livro> buscar(Professor professor) {
        List<Livro> objLstLivro = livroRepository.findByProfessor(professor);
        return objLstLivro;
    }
    
    
}
