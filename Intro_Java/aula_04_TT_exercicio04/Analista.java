package aula_04_TT_exercicio04;

import java.math.BigDecimal;

public class Analista extends FuncionarioCLT{
	public int  horasSemanais ;
	public int  horasDescansoSemanais;
	public BigDecimal bonificacao;
	public BigDecimal salarioBase;
	
	
	public Analista(String nome, String matricula, int idade, BigDecimal salario) {
		super(nome, matricula, idade, salario);
		this.horasSemanais = 40;
		this.horasDescansoSemanais  = 4;
		this.bonificacao = new BigDecimal(1.08);
		this.salarioBase = new BigDecimal(4000);
	}
	
	public void pagarSalario(BigDecimal numMetasBatidas) {
		super.setSalario(this.salarioBase.multiply(numMetasBatidas.multiply(this.salarioBase)));
		System.out.println("Salario pago no valor de "+super.getSalario());
	}
	
	public Analista() {
		super();
		// TODO Auto-generated constructor stub
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
