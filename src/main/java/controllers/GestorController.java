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



import entities.Gestor;
import repositories.GestorRepository;

@Controller
public class GestorController {
	
	private GestorRepository gr;
	
	@Autowired
	public GestorController(GestorRepository gr) {
		this.gr = gr;
	}
	
	@GetMapping("/gestores")
	public String gestores(Model model) {
		
		model.addAttribute("gr", gr.findAll());
		return "gestores";
	}
	
	@GetMapping("/gestor")
	public String gestorForm(Model model, @RequestParam(value = "id", required = false) Long id) {
		if (id == null) {
			model.addAttribute("gestor", new Gestor());
		} else {
			Gestor gestor = gr.findOne(id);
			model.addAttribute("gestor", gestor);
		}
		return "gestor";
	}
	
	@PostMapping("/gestor")
	public String gestorAdiciona(@ModelAttribute @Valid Gestor gestor, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			return "gestor";
		} else {
			gr.save(gestor);
			return "redirect:/gestores";
		}
	}

	@GetMapping("/deletarGestor")
	public String deleteGestor(@RequestParam(value = "id") Long id) {
			gr.delete(id);
			return "redirect:/gestores";
		
	}

}
