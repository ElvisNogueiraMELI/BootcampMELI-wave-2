package br.com.meli.apiobterdiploma.model;

public class Diploma {
	private String nome;
	private double media;
	private String mensagem;
	
	
	public Diploma(String nome, double media, String mensagem) {
		super();
		this.nome = nome;
		this.media = media;
		this.mensagem = mensagem;
	}


	public Diploma() {
		super();
	}



	public String getAluno() {
		return nome;
	}


	public void setAluno(String nome) {
		this.nome = nome;
	}


	public double getMedia() {
		return media;
	}


	public void setMedia(double media) {
		this.media = media;
	}


	public String getMensagem() {
		return mensagem;
	}


	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}
	
	
	
}
