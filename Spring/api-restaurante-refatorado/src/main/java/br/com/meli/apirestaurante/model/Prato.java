package br.com.meli.apirestaurante.model;

public class Prato {
	private long id;
	private double preco;
	private String descricao;
	private int quantidade;
	
	
	public Prato() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Prato(long id, double preco, String descricao, int quantidade) {
		super();
		this.id = id;
		this.preco = preco;
		this.descricao = descricao;
		this.quantidade = quantidade;
	}


	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public double getPreco() {
		return preco;
	}


	public void setPreco(double preco) {
		this.preco = preco;
	}


	public String getDescricao() {
		return descricao;
	}


	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}


	public int getQuantidade() {
		return quantidade;
	}


	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
	
	

	
}
