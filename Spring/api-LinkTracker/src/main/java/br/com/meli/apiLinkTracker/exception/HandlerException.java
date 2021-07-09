package br.com.meli.apiLinkTracker.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class HandlerException {
	
	@ExceptionHandler(LinkNotFound.class)
	public ResponseEntity<String> handlerDefault(LinkNotFound e){
		return new ResponseEntity<String>(e.getMessage(),HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(AcessDeniedException.class)
	public ResponseEntity<String> handlerDefault(AcessDeniedException e){
		return new ResponseEntity<String>(e.getMessage(),HttpStatus.FORBIDDEN);
	}
	
	
}
