package com.nexos.tecnica.config.exception;

/**
 * @author SergioHernandez
 *
 */
public class BadRequestException extends RuntimeException{


	private static final long serialVersionUID = 2822087838054427055L;

	public BadRequestException() {
		super();
	}

	public BadRequestException(String message) {
		super(message);
	}


}
