package br.com.meli.apigestaoclientes.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.meli.apigestaoclientes.dto.PedidoDTO;
import br.com.meli.apigestaoclientes.services.GestaoClienteService;

@RestController
@RequestMapping("/api")
public class ClienteController {
	@Autowired
	private GestaoClienteService gestaoClienteService;
	
	@GetMapping("/cliente/{id}")
	public ResponseEntity<List<PedidoDTO>> getAllPedidosByCliente(@PathVariable long id){
		return new ResponseEntity<List<PedidoDTO>>(gestaoClienteService.getPedidosByCliente(id),HttpStatus.OK);
	}
}
