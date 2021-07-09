package br.com.meli.apigestaoclientes.model;

import java.math.BigDecimal;

public class Produto {
	private long id;
	private String descricao, cor;
	private int quantidade;
	private BigDecimal preco;
	
	public Produto() {
		
	}

	public Produto(long id, String descricao, String cor, int quantidade, BigDecimal preco) {
		super();
		this.id = id;
		this.descricao = descricao;
		this.cor = cor;
		this.quantidade = quantidade;
		this.preco = preco;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
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
