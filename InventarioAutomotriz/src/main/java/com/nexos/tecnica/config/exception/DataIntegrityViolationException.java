package com.nexos.tecnica.config.exception;

/**
 * @author SergioHernandez
 *
 */
public class DataIntegrityViolationException extends RuntimeException {

	private static final long serialVersionUID = -3992117164592475693L;

	public DataIntegrityViolationException() {
		super();
	}

	public DataIntegrityViolationException(String message) {
		super(message);
	}
	
	
}