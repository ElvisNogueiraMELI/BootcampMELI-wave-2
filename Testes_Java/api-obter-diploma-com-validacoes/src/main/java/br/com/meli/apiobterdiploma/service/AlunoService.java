package br.com.meli.apiobterdiploma.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.meli.apiobterdiploma.dto.AlunoDTO;
import br.com.meli.apiobterdiploma.entity.Aluno;
import br.com.meli.apiobterdiploma.repository.AlunoRepository;

@Service
public class AlunoService {
	
	private AlunoRepository repository;

	@Autowired
	public AlunoService(AlunoRepository repository) {
		super();
		this.repository = repository;
	} 
	
	public long addAluno(AlunoDTO alunoDTO) {
		return repository.addAluno(alunoDTO);
	}
	
	public Aluno getById(long id) {
		return repository.getById(id);
	}

	public List<AlunoDTO> getAll() {
		List<Aluno> alunos = repository.getAll();
		List<AlunoDTO> dtos = new ArrayList<>();
		
		alunos.stream().forEach(aluno -> dtos.add(new AlunoDTO(aluno)));
		
		return dtos;
	}
	
}
