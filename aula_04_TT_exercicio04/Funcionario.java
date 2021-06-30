package aula_04_TT_exercicio04;

import java.math.BigDecimal;

public abstract class Funcionario {
	private String nome, matricula;
	private int idade;
	private BigDecimal salario;
	
	public Funcionario() {
		super();
	}

	public Funcionario(String nome, String matricula, int idade, BigDecimal salario) {
		super();
		this.nome = nome;
		this.matricula = matricula;
		this.idade = idade;
		this.salario = salario;
	}
	
	public void pagarSalario() {
		
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}

	public BigDecimal getSalario() {
		return salario;
	}

	public void setSalario(BigDecimal salario) {
		this.salario = salario;
	}
	
	
	
	

}
