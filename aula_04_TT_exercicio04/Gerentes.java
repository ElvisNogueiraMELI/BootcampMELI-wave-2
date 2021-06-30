package aula_04_TT_exercicio04;

import java.math.BigDecimal;

public class Gerentes extends FuncionarioCLT{
	public int  horasSemanais;
	public int  horasDescansoSemanais;
	public BigDecimal bonificacao;
	public BigDecimal salarioBase;
	
	
	public Gerentes() {
		super();
		this.horasSemanais = 36;
		this.horasDescansoSemanais = 4;
		this.bonificacao =  new BigDecimal(0.125);
		this.salarioBase =  new BigDecimal(6000);
		
	}
	public Gerentes(String nome, String matricula, int idade, BigDecimal salario) {
		super(nome, matricula, idade, salario);
		this.horasSemanais = 36;
		this.horasDescansoSemanais = 4;
		this.bonificacao =  new BigDecimal(0.125);
		this.salarioBase =  new BigDecimal(6000);
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
	public int getHorasDescansoSemanais() {
		return horasDescansoSemanais;
	}
	public void setHorasDescansoSemanais(int horasDescansoSemanais) {
		this.horasDescansoSemanais = horasDescansoSemanais;
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
