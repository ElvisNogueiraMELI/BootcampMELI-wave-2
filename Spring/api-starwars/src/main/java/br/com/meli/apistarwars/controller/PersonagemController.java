package br.com.meli.apistarwars.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.meli.apistarwars.model.Personagem;
import br.com.meli.apistarwars.service.PersonagemService;

@RestController
@RequestMapping("/starwars")
public class PersonagemController {
	@Autowired
	private PersonagemService service;
	
	@GetMapping("/personagem/{nome}")
	public ResponseEntity<List<Personagem>> getPersonagemByName(@PathVariable String nome){
		return new ResponseEntity<List<Personagem>>(service.getPersonagensByName(nome),HttpStatus.OK);
	}
	
}
