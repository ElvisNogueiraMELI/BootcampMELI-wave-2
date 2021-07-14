package br.com.meli.apiobterdiploma.controller;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
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
import br.com.meli.apiobterdiploma.service.AlunoService;

@RestController
@RequestMapping("/api")
public class AlunoController {
	
	private AlunoService alunoService;
	
	@Autowired
	public AlunoController(AlunoService alunoService) {
		super();
		this.alunoService = alunoService;
	}
	
	@PostMapping("/aluno")
	public ResponseEntity<Long> salvar(@Valid @RequestBody AlunoDTO aluno, UriComponentsBuilder builder){
		long id = alunoService.addAluno(aluno);
		
		return new ResponseEntity<Long> (id,HttpStatus.CREATED);
	}
	

	@GetMapping("/{id}")
	public ResponseEntity<AlunoDTO> getAlunoById(@PathVariable long id){
		Aluno aluno = alunoService.getById(id);
		AlunoDTO dto = new AlunoDTO(aluno);
		
		return new ResponseEntity<AlunoDTO>(dto,HttpStatus.OK);
	}
	
	@GetMapping("/aluno/getall")
	public ResponseEntity<List<AlunoDTO>> getAll(){
		List<AlunoDTO> alunosDTO = alunoService.getAll();
		
		return new ResponseEntity<List<AlunoDTO>>(alunosDTO,HttpStatus.OK);
	}
	
}
