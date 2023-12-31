package com.example.rest.webservices.restful.webservice.api.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code=HttpStatus.NOT_FOUND)
public class UserNotFoundException extends RuntimeException {
	String message;

	public UserNotFoundException(String message) {
		super();
		this.message = message;
	}
}
