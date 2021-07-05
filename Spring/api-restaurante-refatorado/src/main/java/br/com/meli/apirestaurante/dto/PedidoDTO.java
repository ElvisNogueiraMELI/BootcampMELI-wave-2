package br.com.meli.apirestaurante.dto;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import br.com.meli.apirestaurante.model.Pedido;
import br.com.meli.apirestaurante.model.Prato;

public class PedidoDTO {
	private long idMesa;
	private List<Long> idPratos;
	private double valorTotal = 0;
	private LocalDate data;
	private String status;
	
	public PedidoDTO() {
		
	}
	
	public PedidoDTO(Pedido p){
		
		this.idMesa = p.getIdMesa();
		List<Long> idspratos = new ArrayList<>();
		for(Prato prato : p.getPratos()) {
			idspratos.add(prato.getId());
			this.valorTotal+=prato.getPreco();
		}
		this.idPratos = idspratos;
		this.data = p.getData();
		this.status = p.getStatus();
	}
	
	public PedidoDTO(long idMesa, List<Long> idPratos, double valorTotal) {
		super();
		this.idMesa = idMesa;
		this.idPratos = idPratos;
		this.valorTotal = valorTotal;
	}

	public long getIdMesa() {
		return idMesa;
	}

	public void setIdMesa(long idMesa) {
		this.idMesa = idMesa;
	}

	public List<Long> getIdPratos() {
		return idPratos;
	}

	public void setIdPratos(List<Long> idPratos) {
		this.idPratos = idPratos;
	}

	public double getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(double valorTotal) {
		this.valorTotal = valorTotal;
	}

	@Override
	public String toString() {
		return "PedidoDTO [idMesa=" + idMesa + ", idPratos=" + idPratos + ", valorTotal=" + valorTotal + "]";
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
	
	
	

}
