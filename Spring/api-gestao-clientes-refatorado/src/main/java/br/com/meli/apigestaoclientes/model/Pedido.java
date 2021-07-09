package br.com.meli.apigestaoclientes.model;

import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;

import br.com.meli.apigestaoclientes.dto.PedidoDTO;

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
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pedido other = (Pedido) obj;
		return Objects.equals(cliente, other.cliente) && id == other.id && Objects.equals(produtos, other.produtos)
				&& Objects.equals(valorTotal, other.valorTotal);
	}

}
