package br.com.meli.apiobterdiploma.controller;

import java.net.URI;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriBuilder;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.meli.apiobterdiploma.dao.AlunoDAO;
import br.com.meli.apiobterdiploma.dto.AlunoDTO;
import br.com.meli.apiobterdiploma.model.Aluno;

@RestController
@RequestMapping("/api")
public class AlunoController {
	
	@PostMapping("/aluno")
	public ResponseEntity<Long> salvar(@RequestBody AlunoDTO aluno, UriComponentsBuilder builder){
		System.out.println(aluno.getNome());
		long id = AlunoDAO.addAluno(aluno);
		URI uri = builder.path("/api/{id}").buildAndExpand(id).toUri();
		
		return new ResponseEntity<Long> (id,HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<AlunoDTO> getAlunoById(@PathVariable long id){
		Aluno aluno = AlunoDAO.getById(id);
		System.err.println(aluno);
		AlunoDTO dto = new AlunoDTO(aluno);
		System.out.println(dto);
		return new ResponseEntity<AlunoDTO>(dto,HttpStatus.OK);
	}
	
}
