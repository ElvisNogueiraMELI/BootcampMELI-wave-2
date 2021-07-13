package br.com.meli.apiobterdiploma.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import br.com.meli.apiobterdiploma.dto.AlunoDTO;
import br.com.meli.apiobterdiploma.entity.Aluno;
import br.com.meli.apiobterdiploma.entity.Diploma;
import br.com.meli.apiobterdiploma.entity.Disciplina;
import br.com.meli.apiobterdiploma.exception.AlunoNotFoundException;

@Repository
public class AlunoRepository {
	private static List<Aluno> alunos = new ArrayList<>();
	
	public static long addAluno(AlunoDTO aluno) {
		Aluno a = new Aluno(aluno);
		a.setId(alunos.size()+1);
		alunos.add(a);
		return a.getId();
		
	}
	
	public static Aluno getById(long id) {
		Optional<Aluno> aluno = alunos.stream().filter(item -> item.getId()== id).findFirst();
		if(aluno.isEmpty()) {
			throw new AlunoNotFoundException("Aluno não existe!");
		}
		return aluno.get();
	}
	
	public static Diploma gerarDiploma(long idAluno) {
		Aluno aluno = getById(idAluno);
		String mensagem = "Sua média é ";
		double media = aluno.getDisciplinas().stream()
				.mapToInt(Disciplina::getNota)
				.average().getAsDouble();
		
		mensagem += media;
		
		if(media>9) {
			return new Diploma(aluno.getNome(), media,mensagem + " Parabéns!");
		}
		
		return new Diploma(aluno.getNome(), media,mensagem);
	}

}
