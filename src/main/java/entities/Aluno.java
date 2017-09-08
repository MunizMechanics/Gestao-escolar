package entities;

import java.math.BigDecimal;

import javax.jws.soap.SOAPBinding.Style;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.*;

@Entity
@SequenceGenerator(name="SEQ", sequenceName="SEQ_ALUNO", initialValue = 1, allocationSize = 1)
@Table(name = "Alunos")
public class Aluno extends Pessoa{

	private BigDecimal mensalidade;
	@ManyToOne(fetch = FetchType.EAGER)
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
