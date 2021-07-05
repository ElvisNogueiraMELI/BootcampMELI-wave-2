package br.com.meli.apirestaurante.dao;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.meli.apirestaurante.dto.PedidoDTO;
import br.com.meli.apirestaurante.dto.PedidoRetornoDTO;
import br.com.meli.apirestaurante.model.Pedido;
import br.com.meli.apirestaurante.model.Prato;

@Repository
public class PedidoDAO {
	
	private static List<Prato> pratos = Arrays.asList(new Prato(1, 10, "Macarrão ao molho pesto" , 0),
			new Prato(2, 10, "Strogonoff de carne" , 0));
	
	
	private static final File FILE = new File("pedidos.json");
	@Autowired
	private ObjectMapper mapper;


	public long addPedido(PedidoDTO pedido) {
		Pedido p = new Pedido(pedido);
		pedido.setData(LocalDate.now());
		pedido.setStatus("Ativo");
		List<Pedido> pedidosSalvos = getAll();
		p.setId(pedidosSalvos.size()+1);
		p.setStatus("Ativo");
		pedidosSalvos.add(p);
		try {
			PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(FILE)));
			mapper.writeValue(out, pedidosSalvos);
			out.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return p.getId();
		
	}
	
	public long updatePedido(Pedido pedido) {
		List<Pedido> pedidos = getAll();
		for(Pedido p : pedidos) {
			if(p.getId() == pedido.getId()) {
				p.setData(pedido.getData());
				p.setPratos(pedido.getPratos());
				p.setStatus(pedido.getStatus());
				p.setValorTotal(pedido.getValorTotal());
			}
				
		}
		
		try {
			PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(FILE)));
			mapper.writeValue(out, pedidos);
			out.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return pedido.getId();
	}
	
	public String deletePedido(long id) {
		List<Pedido> pedidos = getAll();
		Pedido pedidoDeletado = getPedidoById(id);
		
		pedidos.remove(pedidoDeletado);
		try {
			PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(FILE)));
			mapper.writeValue(out, pedidos);
			out.close();
			
			return "Deletado com sucesso";
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "Erro ao deletar";
	}
	
	
	public List<Pedido> getAll(){
		List<Pedido> allpedidos = new ArrayList<>();
		try {
			FileInputStream is = new FileInputStream(FILE);
			TypeReference<List<Pedido>> typeReference = new TypeReference<List<Pedido>>() {};
			allpedidos = mapper.readValue(is, typeReference);
			is.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
		return allpedidos;
	}
	
	public List<Pedido> getPedidosMesa(long idMesa){
		List<Pedido> pedidosMesa = new ArrayList<>();
		
		for(Pedido p:getAll()) {
			if(p.getIdMesa() == idMesa) {
				pedidosMesa.add(p);
			}
		}

		return pedidosMesa;
	}
	
	public Pedido getPedidoById(long id) {
		Optional<Pedido> p = getAll().stream().filter(item -> item.getId() == id).findFirst();
		
		return p.orElse(null);
	}
	
	public List<PedidoRetornoDTO> getPedidosAtivos(){
		List<Pedido> pedidos = getAll().stream().filter(item -> item.getStatus().equalsIgnoreCase("Ativo")).collect(Collectors.toList());
		List<PedidoRetornoDTO> retornoDTO = new ArrayList<>();
		
		pedidos.forEach(item -> retornoDTO.add(new PedidoRetornoDTO(item)));
		
		return retornoDTO;
	}

	public double valorEmcaixa() {
		double valor = 0;
		for(Pedido p : getAll()) {
			valor+=p.getValorTotal();
		}
		
		return valor;
	}

	
	public long fecharPedido(long id) {
		Pedido p = getPedidoById(id);
		p.setStatus("Desativado");
		return updatePedido(p);
		
	}


	public static List<Prato> getPratos() {
		return pratos;
	}


	public static void setPratos(List<Prato> pratos) {
		PedidoDAO.pratos = pratos;
	}


	public ObjectMapper getMapper() {
		return mapper;
	}


}
