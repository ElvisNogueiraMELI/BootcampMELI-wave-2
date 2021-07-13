package br.com.meli.apiobterdiploma.dto;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import br.com.meli.apiobterdiploma.entity.Aluno;
import br.com.meli.apiobterdiploma.entity.Disciplina;

public class AlunoDTO {
	@NotNull @Size(min = 8, max = 50) @Pattern(regexp = "^[\\p{L} .'-]+$", message = "Use apenas letras de A-Z e espaços!")
	private String nome;
	private List<@Valid Disciplina> disciplinas;
	
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
