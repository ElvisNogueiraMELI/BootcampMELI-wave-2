package br.com.meli.apigestaoclientes.handlerException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import br.com.meli.apigestaoclientes.exception.PedidoNaoEncontradoException;

@ControllerAdvice
public class HandlerExceptionDefault {
	
	@ExceptionHandler(PedidoNaoEncontradoException.class)
	public ResponseEntity<String> defaultHandler(PedidoNaoEncontradoException e){
		return new ResponseEntity<String>(e.getMessage(),HttpStatus.NOT_FOUND);
	}

}
