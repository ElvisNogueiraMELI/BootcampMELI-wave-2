package br.com.meli.apistarwars.repository;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.meli.apistarwars.model.Personagem;
@Repository
public class PersonagemRepository {
	
	private static final java.io.File FILE = new File("starwars.json");
	@Autowired
	private ObjectMapper mapper;
	
	public List<Personagem> getList(){
		List<Personagem> personagens = new ArrayList<>();
		try {
			FileInputStream is = new FileInputStream(FILE);
			TypeReference<List<Personagem>> typeReference = new TypeReference<List<Personagem>>() {};
			personagens = mapper.readValue(is, typeReference);
			is.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return personagens;
	}
	
	public List<Personagem> getByName(String nome){
		List<Personagem> result = new ArrayList<Personagem>();
		List<Personagem> personagems = getList();
		
		int i = 0;
		personagems.stream().forEach(item -> {
			if(item.getName().contains(nome))
				result.add(item);
		});
		
		return result;
	}
	


}
