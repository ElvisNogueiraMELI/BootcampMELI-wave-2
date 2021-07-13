package br.com.meli.apiobterdiploma.entity;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class Disciplina {
	@NotNull @Size(min = 8, max = 50) @Pattern(regexp = "^[\\p{L} .'-]+$", message = "Use apenas letras de A-Z e espaços!")
	private String nome;
	@Min(value = 0) @Max(value = 10)
	private int nota;
	
	public Disciplina() {
		super();
	}

	public Disciplina(String nome, int nota) {
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

	public int getNota() {
		return nota;
	}

	public void setNota(int nota) {
		this.nota = nota;
	}
	
	
	

}
