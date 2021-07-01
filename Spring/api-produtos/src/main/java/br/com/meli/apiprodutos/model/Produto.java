package br.com.meli.apiprodutos.model;

import java.math.BigDecimal;

public class Produto {
	private int id;
	private String nome;
	private BigDecimal preco;
	
	
	public Produto() {
		super();
	}

	public Produto(int id, String nome, BigDecimal preco) {
		super();
		this.id = id;
		this.nome = nome;
		this.preco = preco;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public BigDecimal getPreco() {
		return preco;
	}

	public void setPreco(BigDecimal preco) {
		this.preco = preco;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return this.nome+" - "+this.getId()+" - "+this.preco;
	}
	
	
}
