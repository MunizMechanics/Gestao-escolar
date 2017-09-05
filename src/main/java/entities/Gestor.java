package entities;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@SequenceGenerator(name="SEQ", sequenceName="SEQ_GESTOR", initialValue = 1, allocationSize = 1)
@Table(name = "Gestores")
public class Gestor extends Pessoa{

    @NotNull
    @Min(0)
	private BigDecimal salario;

	public BigDecimal getSalario() {
		return salario;
	}

	public void setSalario(BigDecimal salario) {
		this.salario = salario;
	}
	
	
}
