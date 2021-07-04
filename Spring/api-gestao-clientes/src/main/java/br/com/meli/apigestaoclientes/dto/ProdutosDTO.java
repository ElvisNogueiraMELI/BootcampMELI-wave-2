package br.com.meli.apigestaoclientes.dto;

import java.math.BigDecimal;

import br.com.meli.apigestaoclientes.model.Produto;

public class ProdutosDTO {
	private String descricao, cor;
	private int quantidade;
	private BigDecimal preco;
	
	public ProdutosDTO() {
		
	}
	
	public ProdutosDTO(Produto produto) {
		this.descricao = produto.getDescricao();
		this.cor = produto.getCor();
		this.quantidade = produto.getQuantidade();
		this.preco = produto.getPreco();
	}
	
	public ProdutosDTO(String descricao, String cor, int quantidade, BigDecimal preco) {
		super();
		this.descricao = descricao;
		this.cor = cor;
		this.quantidade = quantidade;
		this.preco = preco;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getCor() {
		return cor;
	}

	public void setCor(String cor) {
		this.cor = cor;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public BigDecimal getPreco() {
		return preco;
	}

	public void setPreco(BigDecimal preco) {
		this.preco = preco;
	}
	
	
	
	
}
