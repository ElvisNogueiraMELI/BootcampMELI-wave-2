package br.com.meli.apistarwars.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.meli.apistarwars.model.Personagem;
import br.com.meli.apistarwars.repository.PersonagemRepository;

@Service
public class PersonagemService {
	@Autowired
	private PersonagemRepository repository;
	
	public List<Personagem> getPersonagensByName(String nome){
		return repository.getByName(nome);
	}
}
