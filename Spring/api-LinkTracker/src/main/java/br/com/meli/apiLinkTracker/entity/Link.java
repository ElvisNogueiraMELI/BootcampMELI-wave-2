package br.com.meli.apiLinkTracker.entity;

import java.util.Objects;

import br.com.meli.apiLinkTracker.dto.LinkDTO;

public class Link {
	private long id;
	private String url;
	private int acessos;
	private String password;
	
	private Link() {
		
	}
	
	public Link(long id, String url, int acessos) {
		super();
		this.id = id;
		this.url = url;
		this.acessos = acessos;
	}
	
	public Link(long id, LinkDTO linkDTO) {
		this.id = id;
		this.url = linkDTO.getUrl();
		this.acessos = linkDTO.getAcessos();
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
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
	
	@Override
	public String toString() {
		return "Id: "+id+" -  Url: "+url;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Link other = (Link) obj;
		return acessos == other.acessos && id == other.id && Objects.equals(password, other.password)
				&& Objects.equals(url, other.url);
	}
}
