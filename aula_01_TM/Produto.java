package aula_01_TM;

public class Produto {
	private String nome;
	private double preço;
	
	public Produto() {}
	
	public Produto(String nome, double preço) {
		super();
		this.nome = nome;
		this.preço = preço;
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public double getPreço() {
		return preço;
	}
	public void setPreço(double preço) {
		this.preço = preço;
	}

	
}
