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



import entities.Disciplina;
import repositories.CursoRepository;
import repositories.DisciplinaRepository;

@Controller
public class DisciplinaController {
	
	private DisciplinaRepository dr;
	private CursoRepository cr;
	
	@Autowired
	public DisciplinaController(DisciplinaRepository dr, CursoRepository cr) {
		this.dr = dr;
		this.cr = cr;
	}
	
	@GetMapping("/disciplinas")
	public String disciplinas(Model model) {
		
		model.addAttribute("dr", dr.findAll());
		return "disciplinas";
	}
	
	@GetMapping("/disciplina")
	public String disciplinaForm(Model model, @RequestParam(value = "id", required = false) Long id) {
		model.addAttribute("cursos", cr.findAll());
		if (id == null) {
			model.addAttribute("disciplina", new Disciplina());
		} else {
			Disciplina disciplina = dr.findOne(id);
			model.addAttribute("disciplina", disciplina);
		}
		return "disciplina";
	}
	
	@PostMapping("/disciplina")
	public String disciplinaAdiciona(@ModelAttribute @Valid Disciplina disciplina, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			return "disciplina";
		} else {
			dr.save(disciplina);
			return "redirect:/disciplinas";
		}
	}

	@GetMapping("/deletarDisciplina")
	public String deleteDisciplina(@RequestParam(value = "id") Long id) {
			dr.delete(id);
			return "redirect:/disciplinas";
		
	}

}