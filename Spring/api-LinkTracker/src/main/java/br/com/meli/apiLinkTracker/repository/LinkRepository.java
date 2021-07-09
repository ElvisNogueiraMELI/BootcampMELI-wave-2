package br.com.meli.apiLinkTracker.repository;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import br.com.meli.apiLinkTracker.entity.Link;
import br.com.meli.apiLinkTracker.exception.LinkNotFound;

@Repository
public class LinkRepository {
    private static final File FILE = new File("link.json");

    private final ObjectMapper mapper;

    @Autowired
    public LinkRepository(ObjectMapper mapper) {
        this.mapper = mapper;
    }

    public List<Link> getList(){
        List<Link> links = new ArrayList<>();
        try {
            FileInputStream is = new FileInputStream(FILE);
            TypeReference<List<Link>> typeReference = new TypeReference<List<Link>>() {};
            links = mapper.readValue(is, typeReference);
            is.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return links;
    }
    
    public Link getById(long id) {
    	Optional<Link> link = getList().stream().filter(l -> l.getId()==id).findFirst();
    	if(link.isEmpty())
    		throw new LinkNotFound("Link inválido");
    	return link.get();
    }

    public void add(Link link) {
        try {
            List<Link> links = getList();
            links.add(link);
            PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(FILE)));
            mapper.writeValue(out, links);
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public void update(Link link) {
    	List<Link> links = getList();
    	links.forEach(l -> {
    		if(l.getId()==link.getId()) {
    			l.setAcessos(link.getAcessos());
    			l.setUrl(l.getUrl());
    		}
    	});
    	try {
            PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(FILE)));
            mapper.writeValue(out, links);
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

	public void delete(long id) {
		List<Link> links = getList();
		Link linkDeletar = getById(id);
		links.remove(links.indexOf(linkDeletar));
		
		try {
            PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(FILE)));
            mapper.writeValue(out, links);
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
	}

}
