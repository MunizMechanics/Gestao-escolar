package entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import javax.persistence.CascadeType;
import org.springframework.beans.factory.annotation.Autowired;

@Entity
@SequenceGenerator(name="SEQ", sequenceName="SEQ_CURSO", initialValue = 1, allocationSize = 1)
@Table(name="Cursos")
public class Curso extends BaseEntity{
	
    
	@ManyToMany
	@JoinTable( name="Curso_Disciplina", joinColumns={ @JoinColumn(name="id_curso")}, inverseJoinColumns={@JoinColumn(name="id_disciplina")})
	private List<Disciplina> disciplinas;

//	@OneToMany(cascade = CascadeType.ALL, mappedBy = "curso", fetch = FetchType.LAZY)
	//@JoinColumn(name="id_aluno")
	//private List<Aluno> alunos = new ArrayList<Aluno>();
	private String nome;
	private String tipo;
	
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public List<Disciplina> getDisciplinas() {
		return disciplinas;
	}
	public void setDisciplinas(List<Disciplina> disciplinas) {
		this.disciplinas = disciplinas;
	}

	
	
	
	
	
}
