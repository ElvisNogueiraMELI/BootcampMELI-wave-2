package br.com.meli.apiobterdiploma.dto;

import java.util.List;

import br.com.meli.apiobterdiploma.model.Aluno;
import br.com.meli.apiobterdiploma.model.Disciplina;

public class AlunoDTO {

	private String nome;
	private List<Disciplina> disciplinas;
	
	public AlunoDTO(String nome, List<Disciplina> disciplinas) {
		super();
		this.nome = nome;
		this.disciplinas = disciplinas;
	}
	
	public AlunoDTO(Aluno aluno) {
		super();
		this.nome = aluno.getNome();
		this.disciplinas = aluno.getDisciplinas();
	}

	public AlunoDTO() {
		super();
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
