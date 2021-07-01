package br.com.meli.apiobterdiploma.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.meli.apiobterdiploma.dao.AlunoDAO;
import br.com.meli.apiobterdiploma.model.Aluno;
import br.com.meli.apiobterdiploma.model.Diploma;

@RestController
@RequestMapping("/api")
public class DiplomaController {
	
	@GetMapping("/diploma/{idAluno}")
	public Diploma gerarDiploma(@PathVariable long idAluno) {
		return AlunoDAO.gerarDiploma(idAluno);
	}
}
