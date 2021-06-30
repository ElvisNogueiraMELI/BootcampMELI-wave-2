package br.com.meli.apimorse.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.meli.apimorse.model.Moorse;

@RestController
public class MorseController {
	
	@PostMapping("/")
	public String codificarToMorse(@RequestBody String palavra) {
		return Moorse.codificarMorse(palavra);
	}
	
	
}
