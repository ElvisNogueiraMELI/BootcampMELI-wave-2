package br.com.meli.apirestaurante.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import br.com.meli.apirestaurante.model.Prato;

public class PratosDAO {
	
	public static List<Prato> pratosPedido(List<Long> idPratos){
		List<Prato> pratos = new ArrayList<>();
			
		for(long id : idPratos) {
			pratos.add(pratoById(id));
			System.out.println(pratos.get(pratos.size()-1).getDescricao());
		}
		
		return pratos;
	}
	
	public static Prato pratoById(long id) {
		Optional<Prato> p = PedidoDAO.getPratos().stream().filter(item -> item.getId()==id).findFirst();
		
		return p.orElse(null);
	}

}
