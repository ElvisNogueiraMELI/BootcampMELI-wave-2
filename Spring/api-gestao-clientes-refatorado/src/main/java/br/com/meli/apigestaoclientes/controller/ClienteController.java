package br.com.meli.apigestaoclientes.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.meli.apigestaoclientes.dto.PedidoDTO;
import br.com.meli.apigestaoclientes.model.Pedido;
import br.com.meli.apigestaoclientes.services.PedidoService;

@RestController
@RequestMapping("/api")
public class ClienteController {
	@Autowired
	private PedidoService service;
	
	@GetMapping("/cliente/{id}")
	public ResponseEntity<List<PedidoDTO>> getAllPedidosByCliente(@PathVariable long id){
		return new ResponseEntity<List<PedidoDTO>>(service.getPedidosByCliente(id),HttpStatus.OK);
	}
	
	@GetMapping("/pedidos")
	public ResponseEntity<List<PedidoDTO>> getAll(){
		return new ResponseEntity<List<PedidoDTO>>(service.getAll(),HttpStatus.OK);
	}
	
	@GetMapping("/pedido/{id}")
	public ResponseEntity<PedidoDTO> getById(@PathVariable long id){
		PedidoDTO p = service.getById(id);
		return ResponseEntity.ok(p);
	}
	
	@PostMapping("/pedido/create")
	public ResponseEntity<Long> create(@RequestBody Pedido pedido, UriComponentsBuilder builder){
		long id = service.create(pedido);
		URI uri = builder.path("/pedido/{id}").buildAndExpand(id).toUri();
		
		return ResponseEntity.created(uri).build();
	}
	
	@PutMapping("/pedido/update")
	public ResponseEntity<Long> update(@RequestBody Pedido pedido){
		long id = service.update(pedido);
		
		return new ResponseEntity<Long>(id,HttpStatus.OK);
	}
	
	@DeleteMapping("/pedido/delete/{id}")
	public void delete(@PathVariable long id) {
		service.deletar(id);
	}
	
}
