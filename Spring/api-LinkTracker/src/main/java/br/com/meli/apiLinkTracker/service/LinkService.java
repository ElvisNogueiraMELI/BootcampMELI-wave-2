package br.com.meli.apiLinkTracker.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.meli.apiLinkTracker.dto.LinkDTO;
import br.com.meli.apiLinkTracker.entity.Link;
import br.com.meli.apiLinkTracker.exception.AcessDeniedException;
import br.com.meli.apiLinkTracker.repository.LinkRepository;
@Service
public class LinkService {
	
	@Autowired
	private LinkRepository repository;
	
	public List<Link> getAll(){
		return repository.getList();
	}
	
	public Link getById(long id) {
		return repository.getById(id);
	}
	
	public String redirect(long id, String password) throws AcessDeniedException {
		Link link = getById(id);
		
		if(link.getPassword().equals(password)) {
			link.setAcessos(link.getAcessos()+1);
			repository.update(link);
		}else
			throw new AcessDeniedException("Acesso negado");
		return link.getUrl();
	}
	
	public LinkDTO metrics(long id) {
		return new LinkDTO(getById(id));
	}
	
	public void invalidate(long id) {
		repository.delete(id);
	}
	
	public long add(Link link) {
		long id = getAll().size()+1;
		link.setId(id);
		repository.add(link);
		System.err.println(link.getPassword());
		
		return id;
	}
}
