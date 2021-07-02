package br.com.meli.apirestaurante.model;

import java.util.List;

import br.com.meli.apirestaurante.dao.MesaDao;
import br.com.meli.apirestaurante.dao.PratosDAO;
import br.com.meli.apirestaurante.dto.PedidoDTO;

public class Pedido {
	private long id;
	private Mesa mesa;
	private List<Prato> pratos;
	private double valorTotal;


	public Pedido(PedidoDTO pedidoDTO) {
		this.mesa = MesaDao.getMesaId(pedidoDTO.getIdMesa());
		this.pratos = PratosDAO.pratosPedido(pedidoDTO.getIdPratos());

		double total = 0;

		for(Prato p : pratos)
			total+=p.getPreco();
		
		this.valorTotal = total;
	}

	public Pedido(long id, Mesa mesa, List<Prato> pratos, double valorTotal) {
		super();
		this.id = id;
		this.mesa = mesa;
		this.pratos = pratos;
		this.valorTotal = valorTotal;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public Mesa getMesa() {
		return mesa;
	}
	public void setMesa(Mesa mesa) {
		this.mesa = mesa;
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



}
