package com.sharma.loginservice.customexceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @author Srivatsa
 * 
 *         CreationException is a custom exception handles exception occurred
 *         during creation.
 *
 */
@ResponseStatus(value = HttpStatus.BAD_GATEWAY)
public class CreationException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	/**
	 * @param error message
	 */
	public CreationException(String message) {
		super(message.split(";")[3]);
	}

}
