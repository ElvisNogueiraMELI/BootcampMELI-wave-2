package aula_04_TT_exercicio04;

import java.math.BigDecimal;

public abstract class FuncionarioCLT extends Funcionario {
	
	public FuncionarioCLT() {
		super();
		// TODO Auto-generated constructor stub
	}

	public FuncionarioCLT(String nome, String matricula, int idade, BigDecimal salario) {
		super(nome, matricula, idade, salario);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void pagarSalario() {
		// TODO Auto-generated method stub
		
	}


}
