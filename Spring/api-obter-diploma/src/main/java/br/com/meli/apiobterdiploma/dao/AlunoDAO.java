package br.com.meli.apiobterdiploma.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import br.com.meli.apiobterdiploma.dto.AlunoDTO;
import br.com.meli.apiobterdiploma.model.Aluno;
import br.com.meli.apiobterdiploma.model.Diploma;
import br.com.meli.apiobterdiploma.model.Disciplina;

public class AlunoDAO {
	private static List<Aluno> alunos = new ArrayList<>();
	
	public static long addAluno(AlunoDTO aluno) {
		Aluno a = new Aluno(aluno);
		a.setId(alunos.size()+1);
		System.err.println(a.getNome());
		alunos.add(a);
		System.out.println(alunos.size());
		return a.getId();
		
	}
	
	public static Aluno getById(long id) {
		Optional<Aluno> aluno = alunos.stream().filter(item -> item.getId()== id).findFirst();
		if(aluno.isPresent()) {
			return aluno.get();
		}
		return null;
	}
	
	public static Diploma gerarDiploma(long idAluno) {
		Aluno aluno = getById(idAluno);
		double media = 0;
		double soma = 0;
		Diploma diploma;
		
		for(Disciplina d : aluno.getDisciplinas()) {
			soma+=d.getNota();
		}
		media = soma/aluno.getDisciplinas().size();
		if(media>9) {
			return new Diploma(aluno.getNome(), media,"Parabéns!");
		}
		
		return new Diploma(aluno.getNome(), media,"");
	}

}
