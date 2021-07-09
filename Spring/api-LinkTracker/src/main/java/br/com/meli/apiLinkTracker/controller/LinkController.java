package br.com.meli.apiLinkTracker.controller;

import java.net.URI;
import java.util.List;

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

import br.com.meli.apiLinkTracker.dto.LinkDTO;
import br.com.meli.apiLinkTracker.entity.Link;
import br.com.meli.apiLinkTracker.exception.AcessDeniedException;
import br.com.meli.apiLinkTracker.service.LinkService;

@RestController
@RequestMapping("/link")
public class LinkController {
	
	@Autowired
	private LinkService service;
	
	@PostMapping("/create")
	public ResponseEntity<Long> create(@RequestBody Link link, UriComponentsBuilder builder){
		long id = service.add(link);
		URI uri = builder.path("/all").build().toUri();
		
		return ResponseEntity.created(uri).build();
	}
	
	@GetMapping("/all")
	public ResponseEntity<List<Link>> getAll(){
		List<Link> links = service.getAll();
		
		return new ResponseEntity<List<Link>>(links,HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Void> redirect(@PathVariable long id, @RequestBody String password) throws AcessDeniedException{
		String url="";
		try {
			url = service.redirect(id, password);
		} catch (AcessDeniedException e) {
			throw new AcessDeniedException("Acesso negado!");
		}
		return ResponseEntity.status(HttpStatus.FOUND).location(URI.create(url)).build();
	}
	
	@GetMapping("/metrics/{id}")
	public ResponseEntity<LinkDTO> metrics(@PathVariable long id){
		LinkDTO linkDTO = service.metrics(id);
		return new ResponseEntity<LinkDTO>(linkDTO,HttpStatus.OK);
	}
	
	
	@PostMapping("/invalidate/{id}")
	public ResponseEntity<String> invalidate(@PathVariable long id){
		service.invalidate(id);
		return new ResponseEntity<String>("Link invalidado!",HttpStatus.OK);
	}
}
