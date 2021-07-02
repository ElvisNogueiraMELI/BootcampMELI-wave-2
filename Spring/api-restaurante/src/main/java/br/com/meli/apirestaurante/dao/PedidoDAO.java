package br.com.meli.apirestaurante.dao;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import br.com.meli.apirestaurante.dto.PedidoDTO;
import br.com.meli.apirestaurante.model.Mesa;
import br.com.meli.apirestaurante.model.Pedido;
import br.com.meli.apirestaurante.model.Prato;

public class PedidoDAO {
	private static List<Pedido> pedidos = new ArrayList<>();
	private static List<Mesa> mesas = Arrays.asList(new Mesa(1, new ArrayList<>(), 0), new Mesa(2, null, 0),new Mesa(3, null, 0));
	private static List<Prato> pratos = Arrays.asList(new Prato(1, 10, "Macarrão ao molho pesto" , 0),new Prato(2, 10, "Strogonoff de carne" , 0));


	public static long addPedido(PedidoDTO pedido) {
		Pedido p = new Pedido(pedido);
		p.setId(pedidos.size()+1);
		pedidos.add(p);
		
		return p.getId();
		
	}
	
	
	public static List<Pedido> getPedidosMesa(long idMesa){
		List<Pedido> pedidosMesa = new ArrayList<>();

		for(Pedido p:pedidos) {
			if(p.getMesa().getId() == idMesa) {
				pedidosMesa.add(p);
			}
		}

		return pedidosMesa;
	}
	
	public static Pedido getPedidoById(long id) {
		Optional<Pedido> p = pedidos.stream().filter(item -> item.getId() == id).findFirst();
		
		return p.orElse(null);
	}

	public static double valorEmcaixa() {
		double valor = 0;
		for(Pedido p : pedidos) {
			valor+=p.getValorTotal();
		}
		
		return valor;
	}
	
	
	public static List<Pedido> getPedidos() {
		return pedidos;
	}


	public static void setPedidos(List<Pedido> pedidos) {
		PedidoDAO.pedidos = pedidos;
	}


	public static List<Mesa> getMesas() {
		return mesas;
	}


	public static void setMesas(List<Mesa> mesas) {
		PedidoDAO.mesas = mesas;
	}


	public static List<Prato> getPratos() {
		return pratos;
	}


	public static void setPratos(List<Prato> pratos) {
		PedidoDAO.pratos = pratos;
	}

	

}
