package br.com.meli.apiLinkTracker.dto;

import br.com.meli.apiLinkTracker.entity.Link;

public class LinkDTO {
	private String url;
	private int acessos;
	
	public LinkDTO() {
		
	}

	public LinkDTO(String url, int acessos) {
		super();
		this.url = url;
		this.acessos = acessos;
	}
	
	public LinkDTO(Link link) {
		this.url = link.getUrl();
		this.acessos = link.getAcessos();
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public int getAcessos() {
		return acessos;
	}

	public void setAcessos(int acessos) {
		this.acessos = acessos;
	}
	
	
}
