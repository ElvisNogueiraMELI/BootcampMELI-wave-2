package br.com.meli.apigestaoclientes.model;

import java.math.BigDecimal;
import java.util.List;

public class Pedido {
	private long id;
	private List<Produto> produtos;
	private BigDecimal valorTotal;
	private Cliente cliente;
	
	public Pedido() {
		
	}

	public Pedido(long id, List<Produto> produtos, BigDecimal valorTotal, Cliente cliente) {
		super();
		this.id = id;
		this.produtos = produtos;
		this.valorTotal = valorTotal;
		this.cliente = cliente;
	}
	
	

	public Pedido(long id, List<Produto> produtos, Cliente cliente) {
		super();
		this.id = id;
		this.produtos = produtos;
		this.cliente = cliente;
		this.valorTotal = new BigDecimal(0);
		for (Produto p: produtos) 
			this.valorTotal.add(this.valorTotal.add(p.getPreco()));
		
			
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public List<Produto> getProdutos() {
		return produtos;
	}

	public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
	}

	public BigDecimal getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(BigDecimal valorTotal) {
		this.valorTotal = valorTotal;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
	

}
