package aula_04_TT_exercicio04;

import java.math.BigDecimal;

public class Tecnicos extends FuncionarioCLT{
	public int  horasSemanais;
	public BigDecimal bonificacao;
	public BigDecimal salarioBase;
	
	
	
	public Tecnicos() {
		super();
		this.horasSemanais = 40;
		this.bonificacao = new BigDecimal(0.05);
		this.salarioBase = new BigDecimal(3200);
	}



	public Tecnicos(String nome, String matricula, int idade, BigDecimal salario) {
		super(nome, matricula, idade, salario);
		this.horasSemanais = 40;
		this.bonificacao = new BigDecimal(0.05);
		this.salarioBase = new BigDecimal(3200);
	}



	public void pagarSalario(BigDecimal numMetas) {
		super.setSalario(this.salarioBase.add(this.salarioBase.multiply(this.bonificacao).multiply(numMetas)));
		System.out.println("Salario pago no valor de "+super.getSalario());
	}



	public int getHorasSemanais() {
		return horasSemanais;
	}



	public void setHorasSemanais(int horasSemanais) {
		this.horasSemanais = horasSemanais;
	}



	public BigDecimal getBonificacao() {
		return bonificacao;
	}



	public void setBonificacao(BigDecimal bonificacao) {
		this.bonificacao = bonificacao;
	}



	public BigDecimal getSalarioBase() {
		return salarioBase;
	}



	public void setSalarioBase(BigDecimal salarioBase) {
		this.salarioBase = salarioBase;
	}
	
	
}
