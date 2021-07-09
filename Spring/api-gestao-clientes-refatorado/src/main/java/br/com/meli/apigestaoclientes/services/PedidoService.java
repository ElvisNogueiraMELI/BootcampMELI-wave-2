package br.com.meli.apigestaoclientes.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.meli.apigestaoclientes.dto.PedidoDTO;
import br.com.meli.apigestaoclientes.exception.PedidoNaoEncontradoException;
import br.com.meli.apigestaoclientes.model.Pedido;
import br.com.meli.apigestaoclientes.repository.PedidoRepository;

@Service
public class PedidoService {
	@Autowired
	PedidoRepository repositorio;
	
	public List<PedidoDTO> getAll(){
		List<PedidoDTO> dtos = new ArrayList<>();
		repositorio.getAll().stream().forEach(item -> dtos.add(new PedidoDTO(item)));
		return dtos;
	}
	
	public List<PedidoDTO> getPedidosByCliente (long id){
		List<Pedido> pedidos = repositorio.getByCliente(id);
		List<PedidoDTO> dtos = new ArrayList<>();
		pedidos.stream().forEach(item -> dtos.add(new PedidoDTO(item)));
		return dtos;
	}
	
	public PedidoDTO getById(long id) {
		Pedido p = repositorio.getById(id);
		PedidoDTO dto = new PedidoDTO(p);		
		return dto;
	}
	
	private Pedido getbyId(long id) {
		return repositorio.getById(id);
	}
	
	public long create(Pedido p) {
		return repositorio.create(p);
	}
	
	public long update(Pedido p) {
		return repositorio.update(p);
	}
	
	public long deletar(long id){
		Pedido p = getbyId(id);
		repositorio.deleteByID(p);
		
		return id;
	}
	
	
}
