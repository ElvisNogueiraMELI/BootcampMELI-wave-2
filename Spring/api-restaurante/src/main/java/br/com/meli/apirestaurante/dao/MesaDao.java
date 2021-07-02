package br.com.meli.apirestaurante.dao;

import java.util.Optional;

import br.com.meli.apirestaurante.model.Mesa;

public class MesaDao {
	
	public static Mesa getMesaId(long id) {
		Optional<Mesa> mesa = PedidoDAO.getMesas().stream().filter(m -> m.getId() == id).findFirst();
		return mesa.orElse(null);
	}

}
