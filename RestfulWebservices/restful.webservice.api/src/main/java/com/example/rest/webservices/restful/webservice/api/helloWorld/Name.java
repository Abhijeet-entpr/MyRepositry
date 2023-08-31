package com.example.rest.webservices.restful.webservice.api.helloWorld;

public class Name {
	private String firstName;
	private String lastName;
	public String getFirstName() {
		return firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public Name(String firstName, String lastName) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
	}
	
	@Override
	public String toString() {
		return "PersonV2 [firstName=" + firstName + ", lastName=" + lastName + "]";
	}
	
}
