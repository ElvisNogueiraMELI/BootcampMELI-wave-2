package br.com.meli.apigestaoclientes.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.meli.apigestaoclientes.dto.PedidoDTO;
import br.com.meli.apigestaoclientes.model.Pedido;
import br.com.meli.apigestaoclientes.repository.RepositorioGeral;

@Service
public class GestaoClienteService {
	@Autowired
	RepositorioGeral repositorioGeral;
	
	public List<PedidoDTO> getPedidosByCliente (long id){
		List<Pedido> pedidos = repositorioGeral.getAllPedidosCliente(id);
		List<PedidoDTO> dtos = new ArrayList<>();
		pedidos.stream().forEach(item -> dtos.add(new PedidoDTO(item)));
		return dtos;
	}
}
