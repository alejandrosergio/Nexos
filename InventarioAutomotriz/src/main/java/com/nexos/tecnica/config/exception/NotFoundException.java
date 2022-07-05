package com.nexos.tecnica.config.exception;

/**
 * @author SergioHernandez
 *
 */
public class NotFoundException extends RuntimeException {

	
	private static final long serialVersionUID = 3962438968906686427L;

	public NotFoundException() {
		super();
	}

	public NotFoundException(String message) {
		super(message);
	}
	
}
