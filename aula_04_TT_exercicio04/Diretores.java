package aula_04_TT_exercicio04;

import java.math.BigDecimal;

public class Diretores extends FuncionarioCLT{
	private BigDecimal participacaoLucro;
	private  BigDecimal salarioBase ;
	
	
	
	public Diretores() {
		super();
		this.participacaoLucro =  new BigDecimal(1.03);
		this.salarioBase = new BigDecimal(15000);
	}



	public Diretores(String nome, String matricula, int idade, BigDecimal salario) {
		super(nome, matricula, idade, salario);
		this.participacaoLucro =  new BigDecimal(0.03);
		this.salarioBase = new BigDecimal(15000);
		// TODO Auto-generated constructor stub
	}



	
	public void pagarSalario(BigDecimal lucro) {
		super.setSalario(super.getSalario().add((participacaoLucro.multiply(lucro))));
		System.out.println("Salário pago no valor de "+super.getSalario());
	}
	
}
