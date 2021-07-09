package br.com.meli.apigestaoclientes.repository;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.meli.apigestaoclientes.dto.PedidoDTO;
import br.com.meli.apigestaoclientes.exception.PedidoNaoEncontradoException;
import br.com.meli.apigestaoclientes.model.Cliente;
import br.com.meli.apigestaoclientes.model.Pedido;
import br.com.meli.apigestaoclientes.model.Produto;


@Repository
public class PedidoRepository {
	private static List<Produto> produtos = Arrays.asList(new Produto(1, "Garrafa", "Azul", 1, new BigDecimal(4)),
			new Produto(1, "Garrafa", "Verde", 1, new BigDecimal(4)),
			new Produto(1, "Garrafa", "Amarela", 1, new BigDecimal(4)));
	
	private static List<Cliente> clientes = Arrays.asList(new Cliente(1, "Elvis", "111.111.111-11", "elvis@gmail.com", "(11)11111-1111"),
			new Cliente(2, "Eldis", "111.111.111-12", "eldis@gmail.com", "(11)11111-1112"));
	
	
	private static final File FILE = new File("pedidos.json");
	@Autowired
	private ObjectMapper mapper;
	
	
	public List<Pedido> getAll(){
		List<Pedido> allpedidos = new ArrayList<>();
		try {
			FileInputStream is = new FileInputStream(FILE);
			TypeReference<List<Pedido>> typeReference = new TypeReference<List<Pedido>>() {};
			allpedidos = mapper.readValue(is, typeReference);
			
		} catch (FileNotFoundException e) {
			new RuntimeException("Arquivo não encontrado!");
		}catch (IOException e) {
			// TODO: handle exception
		}
		return allpedidos;
	}
	
	
	
	public List<Pedido> getByCliente(long id) {
		List<Pedido> pedidosCliente = new ArrayList<>();
		pedidosCliente = getAll().stream().filter(pedido -> pedido.getCliente().getId() == id).collect(Collectors.toList());
		
		return pedidosCliente;
	}
	
	public Pedido getById(long id) {
		Optional<Pedido> p = getAll().stream().filter(pedido -> pedido.getId() == id).findFirst();
		if(p.isEmpty()) {
			throw new PedidoNaoEncontradoException("Pedido não encontrado!");
		}
		return p.orElse(null);
	}
	
	public long create(Pedido p) {
		List<Pedido> pedidos = getAll();
		p.setId(pedidos.size()+1);
		pedidos.add(p);
		try {
			PrintWriter out = new  PrintWriter(new BufferedWriter(new FileWriter(FILE)));
			mapper.writeValue(out, pedidos);
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return p.getId();
	}
	
	public long update(Pedido p) {
		List<Pedido> pedidos = getAll();
		for(Pedido pedido : pedidos) {
			if(pedido.getId() == p.getId()) {
				pedido.setCliente(p.getCliente());
				pedido.setProdutos(p.getProdutos());
				pedido.setValorTotal(p.getValorTotal());
			}
		}
		try {
			PrintWriter out = new  PrintWriter(new BufferedWriter(new FileWriter(FILE)));
			mapper.writeValue(out, pedidos);
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return p.getId();
	}
	
	public void deleteByID(Pedido pedido) {
		List<Pedido> pedidos = getAll();
		Optional<Pedido> pedidoDeletar = pedidos.stream().filter(p -> p.getId() == pedido.getId()).findFirst();
		
		if(pedidoDeletar.isPresent())
			pedidos.remove(pedidoDeletar.get());
		
		try {
			PrintWriter out = new  PrintWriter(new BufferedWriter(new FileWriter(FILE)));
			mapper.writeValue(out, pedidos);
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
	}
	

}
