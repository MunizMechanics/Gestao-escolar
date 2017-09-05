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



import entities.Aluno;
import entities.Curso;
import repositories.AlunoRepository;
import repositories.CursoRepository;

@Controller
public class AlunoController {
	
	private AlunoRepository ar;
	private CursoRepository cr;
	
	@Autowired
	public AlunoController(AlunoRepository ar, CursoRepository cr) {
		this.ar = ar;
		this.cr = cr;
	}
	
	@GetMapping("/alunos")
	public String alunos(Model model) {
		
		model.addAttribute("ar", ar.findAll());
		return "alunos";
	}
	
	@GetMapping("/aluno")
	public String alunoForm(Model model, @RequestParam(value = "id", required = false) Long id) {
		model.addAttribute("cursos", cr.findAll());
		if (id == null) {
			model.addAttribute("aluno", new Aluno());
		} else {
			Aluno aluno = ar.findOne(id);
			model.addAttribute("aluno", aluno);
		}
		return "aluno";
	}
	
	@PostMapping("/aluno")
	public String alunoAdiciona(@ModelAttribute @Valid Aluno aluno, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			return "aluno";
		} else {
			ar.save(aluno);
			return "redirect:/alunos";
		}
	}

	@GetMapping("/deletarAluno")
	public String deleteAluno(@RequestParam(value = "id") Long id) {
			ar.delete(id);
			return "redirect:/alunos";
		
	}

}
