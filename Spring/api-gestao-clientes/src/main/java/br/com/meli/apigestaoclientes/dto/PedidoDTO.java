package br.com.meli.apigestaoclientes.dto;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import br.com.meli.apigestaoclientes.model.Pedido;

public class PedidoDTO {
	
	public String nomeCliente;
	public List<ProdutosDTO> produtos;
	public BigDecimal valorTotal;
	
	public PedidoDTO() {
		
	}
	
	public PedidoDTO(Pedido pedido) {
		this.nomeCliente = pedido.getCliente().getNome();
		this.produtos = new ArrayList<>();
		pedido.getProdutos().stream().forEach(item -> this.produtos.add(new ProdutosDTO(item)));
		this.valorTotal = pedido.getValorTotal();				
	}

	public String getNomeCliente() {
		return nomeCliente;
	}

	public void setNomeCliente(String nomeCliente) {
		this.nomeCliente = nomeCliente;
	}

	public List<ProdutosDTO> getProdutos() {
		return produtos;
	}

	public void setProdutos(List<ProdutosDTO> produtos) {
		this.produtos = produtos;
	}

	public BigDecimal getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(BigDecimal valorTotal) {
		this.valorTotal = valorTotal;
	}
	
	

}
