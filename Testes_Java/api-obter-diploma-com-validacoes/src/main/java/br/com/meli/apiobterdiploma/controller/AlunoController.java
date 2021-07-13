package br.com.meli.apiobterdiploma.controller;

import java.net.URI;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.meli.apiobterdiploma.dto.AlunoDTO;
import br.com.meli.apiobterdiploma.entity.Aluno;
import br.com.meli.apiobterdiploma.repository.AlunoRepository;

@RestController
@RequestMapping("/api")
public class AlunoController {
	
	@PostMapping("/aluno")
	public ResponseEntity<Long> salvar(@Valid @RequestBody AlunoDTO aluno, UriComponentsBuilder builder){
		long id = AlunoRepository.addAluno(aluno);
		URI uri = builder.path("/api/{id}").buildAndExpand(id).toUri();
		
		return new ResponseEntity<Long> (id,HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<AlunoDTO> getAlunoById(@PathVariable long id){
		Aluno aluno = AlunoRepository.getById(id);
		AlunoDTO dto = new AlunoDTO(aluno);
		return new ResponseEntity<AlunoDTO>(dto,HttpStatus.OK);
	}
	
}
