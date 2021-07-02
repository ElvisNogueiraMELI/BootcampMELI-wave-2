package br.com.meli.apirestaurante.model;

import java.util.List;

public class Mesa {
	private long id;
	private List<Pedido> pedidos;
	private double valorTotalConsumido;
	
	
	public Mesa() {
		super();
	}

	public Mesa(long id) {
		
	}

	public Mesa(long id, List<Pedido> pedidos, double valorTotalConsumido) {
		super();
		this.id = id;
		this.pedidos = pedidos;
		this.valorTotalConsumido = valorTotalConsumido;
	}


	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public List<Pedido> getPedidos() {
		return pedidos;
	}


	public void setPedidos(List<Pedido> pedidos) {
		this.pedidos = pedidos;
	}


	public double getValorTotalConsumido() {
		return valorTotalConsumido;
	}


	public void setValorTotalConsumido(double valorTotalConsumido) {
		this.valorTotalConsumido = valorTotalConsumido;
	}
	
	

}
