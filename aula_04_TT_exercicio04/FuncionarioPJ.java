package aula_04_TT_exercicio04;

import java.math.BigDecimal;

public class FuncionarioPJ extends Funcionario {

	private BigDecimal horasTrabalhadas;
	private BigDecimal valorHoraTrabalhada;
	
		
	public FuncionarioPJ() {
		super();
	}

	public FuncionarioPJ(BigDecimal horasTrabalhadas, BigDecimal valorHoraTrabalhada) {
		super();
		this.horasTrabalhadas = horasTrabalhadas;
		this.valorHoraTrabalhada = valorHoraTrabalhada;
	}

	public FuncionarioPJ(String nome, String matricula, int idade, BigDecimal salario) {
		super(nome, matricula, idade, salario);
		// TODO Auto-generated constructor stub
	}
	
	public FuncionarioPJ(String nome, String matricula, int idade, BigDecimal salario, BigDecimal horasTrabalhadas) {
		super(nome, matricula, idade, salario);
		this.horasTrabalhadas = horasTrabalhadas;
	}

	@Override
	public void pagarSalario() {
		BigDecimal salario = valorHoraTrabalhada.multiply(horasTrabalhadas);
		System.out.println("Salário pago no valor de: "+salario);
	}

	public BigDecimal getHorasTrabalhadas() {
		return horasTrabalhadas;
	}

	public BigDecimal getValorHoraTrabalhada() {
		return valorHoraTrabalhada;
	}

	public void setValorHoraTrabalhada(BigDecimal valorHoraTrabalhada) {
		this.valorHoraTrabalhada = valorHoraTrabalhada;
	}

	public void setHorasTrabalhadas(BigDecimal horasTrabalhadas) {
		this.horasTrabalhadas = horasTrabalhadas;
	}
	
	
	

}
