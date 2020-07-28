package com.example.exceptions;

import org.jboss.logging.Logger;
import org.jboss.logging.Logger.Level;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST)
public class AccountAlreadyExistsException extends RuntimeException {
	
	private static final Logger logger = Logger.getLogger(AccountAlreadyExistsException.class.getName());

	public AccountAlreadyExistsException(String string) {
		logger.log(Level.DEBUG, string);
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

}
