package br.com.meli.apirestaurante.dto;

import java.util.List;

import br.com.meli.apirestaurante.dao.MesaDao;
import br.com.meli.apirestaurante.dao.PratosDAO;
import br.com.meli.apirestaurante.dto.PedidoDTO;
import br.com.meli.apirestaurante.model.Mesa;
import br.com.meli.apirestaurante.model.Prato;

public class PedidoRetornoDTO {
	private Mesa mesa;
	private List<Prato> pratos;
	private double valorTotal;


	public PedidoRetornoDTO(PedidoDTO pedidoDTO) {
		this.mesa = MesaDao.getMesaId(pedidoDTO.getIdMesa());
		this.pratos = PratosDAO.pratosPedido(pedidoDTO.getIdPratos());

		double total = 0;

		for(Prato p : pratos)
			total+=p.getPreco();
		
		this.valorTotal = total;
	}

	public PedidoRetornoDTO(Mesa mesa, List<Prato> pratos, double valorTotal) {
		super();
		this.mesa = mesa;
		this.pratos = pratos;
		this.valorTotal = valorTotal;
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
