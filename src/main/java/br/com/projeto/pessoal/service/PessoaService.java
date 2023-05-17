package br.com.projeto.pessoal.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.projeto.pessoal.entidades.Pessoa;
import br.com.projeto.pessoal.repositorio.PessoaRepository;

@Service
public class PessoaService {

	@Autowired
	PessoaRepository repo;
	
	public void adicionar(Pessoa pessoa) {
		repo.save(pessoa);
	}
	
	public List<Pessoa> listarPessoa(){
		return repo.findAll();
	}
	
	public Pessoa modificar(long id) {
		return repo.findById(id).get();
	}
	
	public void deletar(long id) {
		repo.deleteById(id);
	}
}
