package br.com.projeto.pessoal.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.projeto.pessoal.entidades.Pessoa;

public interface PessoaRepository extends JpaRepository<Pessoa, Long> {

}
