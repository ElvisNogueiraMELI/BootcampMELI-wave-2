package br.com.meli.apiobterdiploma.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.meli.apiobterdiploma.entity.Aluno;
import br.com.meli.apiobterdiploma.entity.Diploma;
import br.com.meli.apiobterdiploma.repository.AlunoRepository;
import br.com.meli.apiobterdiploma.service.DiplomaService;

@RestController
@RequestMapping("/api")
public class DiplomaController {
	
	private DiplomaService diplomaService;
	
	@Autowired
	public DiplomaController(DiplomaService diplomaService) {
		super();
		this.diplomaService = diplomaService;
	}
	
	@GetMapping("/diploma/{idAluno}")
	public ResponseEntity<Diploma> gerarDiploma(@PathVariable long idAluno) {
		Diploma diploma = diplomaService.createDiploma(idAluno);
		
		return new ResponseEntity<Diploma>(diploma,HttpStatus.CREATED);
	}

}
