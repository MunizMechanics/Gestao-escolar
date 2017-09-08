package controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import entities.*;
import repositories.*;


@org.springframework.web.bind.annotation.RestController
public class RestController {

	private AlunoRepository ar;
	private CursoRepository cr;
	private DisciplinaRepository dr;
	private GestorRepository gr;
	
	@Autowired
	public RestController(AlunoRepository ar, CursoRepository cr, DisciplinaRepository dr, GestorRepository gr) {
		this.ar = ar;
		this.cr = cr;
		this.dr = dr;
		this.gr = gr;
	}
	
	@GetMapping("/cursosRest")
	public Iterable<Curso> cursosRest() {
		
		return cr.findAll();
	}
	
	@GetMapping("/alunosRest")
	public Iterable<Aluno> alunoRest() {
		
		return ar.findAll();
	}
	
	@GetMapping("/disciplinasRest")
	public Iterable<Disciplina> disciplinaRest() {
		
		return dr.findAll();
	}
	
	@GetMapping("/gestoresRest")
	public Iterable<Gestor> gestoresRest() {
		
		return gr.findAll();
	}
	
}