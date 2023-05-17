package br.com.projeto.pessoal.controler;



import java.util.Comparator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.projeto.pessoal.entidades.Pessoa;
import br.com.projeto.pessoal.service.PessoaService;

@Controller
public class pessoaControler {
	
	@Autowired
	PessoaService repo;
	
	@RequestMapping("/")
	public String paginaInicial(Model model) {
		List<Pessoa> pessoa = repo.listarPessoa();
		pessoa.sort(Comparator.comparing(Pessoa::getNome));
		int quantidadeRegistros = pessoa.size();
		model.addAttribute("pessoas",pessoa);
		model.addAttribute("quantidadeRegistros", quantidadeRegistros);
		
		return "index";
	}
	
	
	@RequestMapping("/novo")
	public String novaPessoa(Model model) {
		Pessoa pessoa = new Pessoa();
		
		model.addAttribute("pessoa",pessoa);
		return "novapessoa";
	}
	
	
	@PostMapping("/salvar")
	public String adicionarP(@ModelAttribute("pessoas") Pessoa pessoa) {
		repo.adicionar(pessoa);
		return "redirect:/";
		}
	
	@RequestMapping("/editar/{id}")
	public ModelAndView paginaEditar(@PathVariable(name="id") long id) {
	ModelAndView mav = new ModelAndView("editarpessoa");
	Pessoa pessoa = repo.modificar(id);
	mav.addObject("pessoa", pessoa);
	return mav;
	}
	
	@RequestMapping("/deletar/{id}")
	public String deletar(@PathVariable(name="id") long id) {
	repo.deletar(id);
	return "redirect:/";
	}

}
