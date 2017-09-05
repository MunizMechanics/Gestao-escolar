package controllers;


import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import entities.Endereco;
import repositories.EnderecoRepository;


@RestController
public class EnderecoController {
	
	private EnderecoRepository er;
	
	@Autowired
	public EnderecoController(EnderecoRepository er) {
		this.er = er;
	}
	
	@GetMapping("/enderecos")
	public Iterable<Endereco> enderecos(Model model) {
		
		//model.addAttribute("er", er.findAll());
		return er.findAll();
	}
	
	@GetMapping("/endereco")
	public String enderecoForm(Model model, @RequestParam(value = "id", required = false) Long id) {
		if (id == null) {
			model.addAttribute("endereco", new Endereco());
		} else {
			Endereco endereco = er.findOne(id);
			model.addAttribute("endereco", endereco);
		}
		return "endereco";
	}
	
	@PostMapping("/endereco")
	public String enderecoAdiciona(@ModelAttribute @Valid Endereco endereco, BindingResult bindineresult) {
		if (bindineresult.hasErrors()) {
			return "endereco";
		} else {
			er.save(endereco);
			return "redirect:/enderecos";
		}
	}

	@PostMapping("/deletaEndereco")
	public String deleteEndereco(@RequestParam(value = "id") Long id) {
			er.delete(id);
			return "redirect:/enderecos";
		
	}

}
	

