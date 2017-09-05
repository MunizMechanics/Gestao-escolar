package entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@SequenceGenerator(name="SEQ", sequenceName="SEQ_DISCIPLINA", initialValue = 1, allocationSize = 1)
@Table(name = "Disciplinas")
public class Disciplina extends BaseEntity{
	
    @NotNull
    @Size(min=2, max=100)
	private String nome;
	
	@ManyToMany(mappedBy="disciplinas")
	private List<Curso> cursos = new ArrayList<Curso>();
	private int creditos;
	
	
	public List<Curso> getCursos() {
		return cursos;
	}
	public void setCursos(List<Curso> cursos) {
		this.cursos = cursos;
	}
	public int getCreditos() {
		return creditos;
	}
	public void setCreditos(int creditos) {
		this.creditos = creditos;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	

}
