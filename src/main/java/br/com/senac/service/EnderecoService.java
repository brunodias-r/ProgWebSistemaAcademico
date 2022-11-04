package br.com.senac.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.senac.entity.Endereco;
import br.com.senac.repository.EnderecoRepository;

@Service
public class EnderecoService {
	
	@Autowired
	private EnderecoRepository repo;
	
	public List<Endereco> buscarTodosEnderecos(){
		return repo.findAll();
	}

	public Endereco salvar(Endereco endereco) {
		return repo.save(endereco);
	}
	
}
