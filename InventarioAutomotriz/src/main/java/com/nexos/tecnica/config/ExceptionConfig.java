package com.nexos.tecnica.config;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

import com.nexos.tecnica.config.exception.BadRequestException;
import com.nexos.tecnica.config.exception.DataIntegrityViolationException;
import com.nexos.tecnica.config.exception.NotFoundException;

/**
 * @author SergioHernandez
 *
 */
@ControllerAdvice(annotations = RestController.class)
@RestController
public class ExceptionConfig {
	
	@ExceptionHandler(NotFoundException.class)
	public ResponseEntity<?> notFoundException( Exception e){
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
	}
	
	@ExceptionHandler(BadRequestException.class)
	public ResponseEntity<?> badRequestException( Exception e){
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
	}
	
	@ExceptionHandler(DataIntegrityViolationException.class)
	public ResponseEntity<?> dataIntegrityViolationException( Exception e){
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
	}

}