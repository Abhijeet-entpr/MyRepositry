package com.example.rest.webservices.restful.webservice.api.Exceptions;

import java.time.LocalDateTime;

public class ErrorDetails {
	LocalDateTime timesstamp;
	String message;
	String description;
	public ErrorDetails(LocalDateTime timesstamp, String message, String description) {
		super();
		this.timesstamp = timesstamp;
		this.message = message;
		this.description = description;
	}
	public LocalDateTime getTimesstamp() {
		return timesstamp;
	}
	public String getMessage() {
		return message;
	}
	public String getDescription() {
		return description;
	}
	
}
