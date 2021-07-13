package br.com.meli.apiobterdiploma.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.meli.apiobterdiploma.entity.Aluno;
import br.com.meli.apiobterdiploma.entity.Diploma;
import br.com.meli.apiobterdiploma.repository.AlunoRepository;

@RestController
@RequestMapping("/api")
public class DiplomaController {
	
	@GetMapping("/diploma/{idAluno}")
	public Diploma gerarDiploma(@PathVariable long idAluno) {
		return AlunoRepository.gerarDiploma(idAluno);
	}
}
