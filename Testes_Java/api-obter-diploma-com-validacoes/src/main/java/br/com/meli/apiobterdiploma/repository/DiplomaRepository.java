package br.com.meli.apiobterdiploma.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import br.com.meli.apiobterdiploma.entity.Aluno;
import br.com.meli.apiobterdiploma.entity.Diploma;
import br.com.meli.apiobterdiploma.entity.Disciplina;
import br.com.meli.apiobterdiploma.exception.LowAverageException;

@Repository
public class DiplomaRepository {
	private static List<Diploma> diplomas = new ArrayList<Diploma>(); 
	
	public Diploma gerarDiploma(String nome, double media, String mensagem) {
		Diploma diploma = new Diploma(nome, media,mensagem);
		diplomas.add(diploma);
		return diploma;
	}

}
