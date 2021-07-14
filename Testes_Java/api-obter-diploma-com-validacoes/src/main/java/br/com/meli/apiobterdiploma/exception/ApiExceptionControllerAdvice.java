package br.com.meli.apiobterdiploma.exception;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;


@ControllerAdvice
public class ApiExceptionControllerAdvice {

	@org.springframework.web.bind.annotation.ExceptionHandler(AlunoNotFoundException.class)
	public ResponseEntity<String> defaultHandler(AlunoNotFoundException e){
		return new ResponseEntity<String>(e.getMessage(),HttpStatus.NOT_FOUND);
	}
	
	@org.springframework.web.bind.annotation.ExceptionHandler(LowAverageException.class)
	public ResponseEntity<String> defaultHandler(LowAverageException e){
		return new ResponseEntity<String>(e.getMessage(),HttpStatus.BAD_REQUEST);
	}
	
}
