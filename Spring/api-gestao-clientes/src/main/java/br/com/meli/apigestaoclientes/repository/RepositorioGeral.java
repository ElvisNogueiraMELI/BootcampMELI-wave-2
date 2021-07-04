package br.com.meli.apigestaoclientes.repository;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Repository;

import br.com.meli.apigestaoclientes.model.Cliente;
import br.com.meli.apigestaoclientes.model.Pedido;
import br.com.meli.apigestaoclientes.model.Produto;

@Repository
public class RepositorioGeral {
	private static List<Produto> produtos = Arrays.asList(new Produto(1, "Garrafa", "Azul", 1, new BigDecimal(4)),
			new Produto(1, "Garrafa", "Verde", 1, new BigDecimal(4)),
			new Produto(1, "Garrafa", "Amarela", 1, new BigDecimal(4)));
	
	private static List<Cliente> clientes = Arrays.asList(new Cliente(1, "Elvis", "111.111.111-11", "elvis@gmail.com", "(11)11111-1111"),
			new Cliente(2, "Eldis", "111.111.111-12", "eldis@gmail.com", "(11)11111-1112"));
	
	private static List<Pedido> pedidos = Arrays.asList(new Pedido(1, produtos, clientes.get(0)),
			new Pedido(2, produtos, clientes.get(0)),
			new Pedido(3, produtos, clientes.get(1)));
	
	public static List<Pedido> getAllPedidosCliente(long id) {
		List<Pedido> pedidosCliente = new ArrayList<>();
		for(Pedido p : pedidos) {
			if (p.getCliente().getId() == id)
				pedidosCliente.add(p);
		}
		
		return pedidosCliente;
	}

}
