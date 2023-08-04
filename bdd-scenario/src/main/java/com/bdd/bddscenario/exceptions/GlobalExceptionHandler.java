package com.bdd.bddscenario.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(value=UserNotFoundException.class)
	public ResponseEntity<String> userNotFound(UserNotFoundException userNotFound){
		
		return new ResponseEntity<String>(userNotFound.getMessage(),HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(value=AuthenticationException.class)
	public ResponseEntity<String> oktaNotVerified(AuthenticationException authenticationExp){
		
		return new ResponseEntity<String>(authenticationExp.getMessage(),HttpStatus.FORBIDDEN);
	}

}
