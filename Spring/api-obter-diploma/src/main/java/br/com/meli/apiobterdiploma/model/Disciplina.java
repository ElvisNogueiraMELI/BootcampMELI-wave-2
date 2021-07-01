package br.com.meli.apiobterdiploma.model;

public class Disciplina {
	private String nome;
	private double nota;
	
	public Disciplina() {
		super();
	}
	
	

	public Disciplina(String nome, double nota) {
		super();
		this.nome = nome;
		this.nota = nota;
	}



	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public double getNota() {
		return nota;
	}

	public void setNota(double nota) {
		this.nota = nota;
	}
	
	
	

}
