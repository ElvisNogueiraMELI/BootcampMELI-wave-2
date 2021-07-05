package br.com.meli.apirestaurante.model;

import java.time.LocalDate;
import java.util.List;

import br.com.meli.apirestaurante.dao.PratosDAO;
import br.com.meli.apirestaurante.dto.PedidoDTO;

public class Pedido {
	private long id;
	private long idMesa;
	private List<Prato> pratos;
	private double valorTotal;
	private String status;
	private LocalDate data;

	public Pedido(PedidoDTO pedidoDTO) {
		this.idMesa = pedidoDTO.getIdMesa();
		this.pratos = PratosDAO.pratosPedido(pedidoDTO.getIdPratos());

		double total = 0;

		for(Prato p : pratos)
			total+=p.getPreco();
		
		this.valorTotal = total;
	}

	public Pedido(long id, long mesa, List<Prato> pratos, double valorTotal) {
		super();
		this.id = id;
		this.idMesa = mesa;
		this.pratos = pratos;
		this.valorTotal = valorTotal;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}

	
	public long getIdMesa() {
		return idMesa;
	}

	public void setIdMesa(long idMesa) {
		this.idMesa = idMesa;
	}

	public List<Prato> getPratos() {
		return pratos;
	}
	public void setPratos(List<Prato> pratos) {
		this.pratos = pratos;
	}
	public double getValorTotal() {
		return valorTotal;
	}
	public void setValorTotal(double valorTotal) {
		this.valorTotal = valorTotal;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public LocalDate getData() {
		return data;
	}

	public void setData(LocalDate data) {
		this.data = data;
	}

	


}
