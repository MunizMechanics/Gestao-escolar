package entities;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@SequenceGenerator(name="SEQ", sequenceName="SEQ_ALUNO", initialValue = 1, allocationSize = 1)
@Table(name = "Alunos")
public class Aluno extends Pessoa{
	
	
	private BigDecimal mensalidade;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="id_curso")
	private Curso curso;
	
	public BigDecimal getMensalidade() {
		return mensalidade;
	}
	public void setMensalidade(BigDecimal mensalidade) {
		this.mensalidade = mensalidade;
	}
	public Curso getCurso() {
		return curso;
	}
	public void setCurso(Curso curso) {
		this.curso = curso;
	}
	
	

}
