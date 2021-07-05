package br.com.meli.apirestaurante.dto;

import java.time.LocalDate;
import java.util.List;

import br.com.meli.apirestaurante.dao.PratosDAO;
import br.com.meli.apirestaurante.dto.PedidoDTO;
import br.com.meli.apirestaurante.model.Pedido;
import br.com.meli.apirestaurante.model.Prato;

public class PedidoRetornoDTO {
	private long idMesa;
	private List<Prato> pratos;
	private double valorTotal;
	private LocalDate data;
	private String status;


	public PedidoRetornoDTO(PedidoDTO pedidoDTO) {
		this.idMesa = pedidoDTO.getIdMesa();
		this.pratos = PratosDAO.pratosPedido(pedidoDTO.getIdPratos());

		double total = 0;

		for(Prato p : pratos)
			total+=p.getPreco();
		
		this.valorTotal = total;
		this.data = pedidoDTO.getData();
		this.status = pedidoDTO.getStatus();
	}

	public PedidoRetornoDTO(long idMesa, List<Prato> pratos, double valorTotal) {
		super();
		this.idMesa = idMesa;
		this.pratos = pratos;
		this.valorTotal = valorTotal;
	}
	
	public PedidoRetornoDTO(Pedido p) {
		this.data = p.getData();
		this.idMesa = p.getIdMesa();
		this.pratos = p.getPratos();
		this.status = p.getStatus();
		this.valorTotal = p.getValorTotal();
	}
	
	public long getIdMesa() {
		return idMesa;
	}
	public void setMesa(long idMesa) {
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

	public LocalDate getData() {
		return data;
	}

	public void setData(LocalDate data) {
		this.data = data;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public void setIdMesa(long idMesa) {
		this.idMesa = idMesa;
	}

	

}
