package br.com.meli.apirestaurante.controller;

import java.net.URI;
import java.util.ArrayList;
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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.meli.apirestaurante.dao.PedidoDAO;
import br.com.meli.apirestaurante.dto.PedidoDTO;
import br.com.meli.apirestaurante.dto.PedidoRetornoDTO;
import br.com.meli.apirestaurante.model.Pedido;

@RestController
@RequestMapping("/restaurante")
public class PedidoController {
	@Autowired
	private PedidoDAO pedidoDAO;
	
	@PostMapping("/pedido")
	public ResponseEntity<Long> addPedido(@RequestBody PedidoDTO pedidoDTO, UriComponentsBuilder builder){
		System.out.println(pedidoDTO);
		long id = pedidoDAO.addPedido(pedidoDTO);
		
		URI uri = builder.path("/restaurante/pedido/{id}").buildAndExpand(id).toUri();
		
		return new ResponseEntity<Long>(id, HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<PedidoRetornoDTO> getPedidoById(@PathVariable long id){
		Pedido p = pedidoDAO.getPedidoById(id);
		PedidoDTO dto = new PedidoDTO(p);
		PedidoRetornoDTO retornoDTO = new PedidoRetornoDTO(dto);
		
		return new ResponseEntity<PedidoRetornoDTO>(retornoDTO,HttpStatus.OK);
	}
	
	@GetMapping("/pedido/mesa/{id}")
	public ResponseEntity<List<PedidoRetornoDTO>> getPedidoByMesa(@PathVariable long id){
		List<PedidoRetornoDTO>pedidos = new ArrayList<>();
		
		for(Pedido p: pedidoDAO.getPedidosMesa(id)) {
			PedidoDTO dto = new PedidoDTO(p);
			PedidoRetornoDTO retornoDTO = new PedidoRetornoDTO(dto);
			pedidos.add(retornoDTO);
			
		}
		
		return new ResponseEntity<List<PedidoRetornoDTO>>(pedidos,HttpStatus.OK);
	}
	
	@PutMapping("/pedido/update")
	public ResponseEntity<Long> updatePedido(@RequestBody Pedido pedido, UriComponentsBuilder builder){
		long id = pedidoDAO.updatePedido(pedido);
		URI uri = builder.path("/restaurante/pedido/{id}").buildAndExpand(id).toUri();
		
		return new ResponseEntity<Long>(id, HttpStatus.OK);
	}
	
	@DeleteMapping("/pedido/{id}")
	public String deletarPedido(@PathVariable long id) {
		return pedidoDAO.deletePedido(id);
	}
	
	@GetMapping("/pedido/fecharpedido/{id}")
	public ResponseEntity<Long> fecharPedido(@PathVariable long id, UriComponentsBuilder builder){
		pedidoDAO.fecharPedido(id);
		URI uri = builder.path("/restaurante/pedido/{id}").buildAndExpand(id).toUri();
		
		return new ResponseEntity<Long>(id, HttpStatus.OK);
	}
	
	@GetMapping("/pedido/ativos/")
	public ResponseEntity<List<PedidoRetornoDTO>> getAtivos(){
		List<PedidoRetornoDTO> retornoDTO = pedidoDAO.getPedidosAtivos();
		return ResponseEntity.ok(retornoDTO);
	}
	
	@GetMapping("/caixa/")
	public ResponseEntity<Double> valorEmcaixa(){
		double valor = pedidoDAO.valorEmcaixa();
		return new ResponseEntity<Double>(valor,HttpStatus.OK);
	}
	

}
