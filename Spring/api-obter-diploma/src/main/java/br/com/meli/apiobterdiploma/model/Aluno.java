package br.com.meli.apiobterdiploma.model;

import java.util.List;

import br.com.meli.apiobterdiploma.dto.AlunoDTO;

public class Aluno {
	
	private long id;
	private String nome;
	private List<Disciplina> disciplinas;
	
	
	public Aluno() {
		super();
	}


	public Aluno(String nome, List<Disciplina> disciplinas) {
		super();
		this.nome = nome;
		this.disciplinas = disciplinas;
	}


	public Aluno(AlunoDTO aluno) {
		super();
		this.nome = aluno.getNome();
		this.disciplinas = aluno.getDisciplinas();
	}


	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public List<Disciplina> getDisciplinas() {
		return disciplinas;
	}


	public void setDisciplinas(List<Disciplina> disciplinas) {
		this.disciplinas = disciplinas;
	}
	
	
	
	
	
}
