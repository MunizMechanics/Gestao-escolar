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



import entities.Curso;
import repositories.CursoRepository;
import repositories.DisciplinaRepository;

@Controller
public class CursoController {
	
	private CursoRepository cr;
	private DisciplinaRepository dr;
	
	@Autowired
	public CursoController(CursoRepository cr, DisciplinaRepository dr) {
		this.cr = cr;
		this.dr = dr;
	}
	
	@GetMapping("/cursos")
	public String cursos(Model model) {
		
		model.addAttribute("cr", cr.findAll());
		return "cursos";
	}
	
	@GetMapping("/curso")
	public String cursoForm(Model model, @RequestParam(value = "id", required = false) Long id) {
		model.addAttribute("disciplinas", dr.findAll());
		if (id == null) {
			model.addAttribute("curso", new Curso());
		} else {
			Curso curso = cr.findOne(id);
			model.addAttribute("curso", curso);
		}
		return "curso";
	}
	
	@PostMapping("/curso")
	public String cursoAdiciona(@ModelAttribute @Valid Curso curso, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			return "curso";
		} else {
			cr.save(curso);
			return "redirect:/cursos";
		}
	}

	@GetMapping("/deletarCurso")
	public String deleteCurso(@RequestParam(value = "id") Long id) {
		try {
		    Curso curso = cr.findOne(id);
			cr.delete(curso);
		} catch (Exception e) {
			return "redirect:/cursos?error=error";
			}
			return "redirect:/cursos";
		
	}

}