package com.example.rest.webservices.restful.webservice.api.helloWorld;

import java.util.Locale;

import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class HelloRestWorld {
	private MessageSource messageSource;
	public HelloRestWorld(MessageSource messageSource) {
		super();
		this.messageSource = messageSource;
	} 

	@GetMapping(path="/hello-world")
	public HelloWorldBean sayHello() {
		return new HelloWorldBean("Hello World in Rest Api");
	}
	
	@GetMapping(path="/hello-world-internationalized")
	public String sayHelloInternationalized() {
		Locale locale = LocaleContextHolder.getLocale();
		return messageSource.getMessage("good.morning.message", null,"Default message",locale);
	}
	
	// #1 URL Versioning
	@GetMapping(path="/v1/person")
	public Person sayHelloVersion1() {
		return new Person("Bob Marley");
	}
	@GetMapping(path="/v2/person")
	public PersonV2 sayHelloVersion2() {
		return new PersonV2(new Name("Bob","Marley"));
	}
	
	// #2 Request Parameter
	@GetMapping(path="/person",params = "Version=1")
	public Person sayHelloUsingRequestParamVersion1() {
		return new Person("Bob Marley");

	}
	@GetMapping(path="/person",params = "Version=2")
	public PersonV2 sayHelloUsingRequestParamVersion2() {
		return new PersonV2(new Name("Bob","Marley"));
	}
	// #3 Custom header versioning
	@GetMapping(path="/person",headers="X-API-VERSION=1")
	public Person personsusing() { 
		return new Person("Bob Marley");
	}
	@GetMapping(path="/person",headers="X-API-VERSION=2")
	public PersonV2 personsusingHeaders() { 
		return new PersonV2(new Name("Bob","Marley"));
	}
	// #4 Media type (MIME)
	@GetMapping(path="/person/header",produces="application/vnd.company.app-v1+json")
	public Person personsusingMediaType() { 
		return new Person("Bob Marley");
	}
	
	@GetMapping(path="/person/header",produces="application/vnd.company.app-v2+json")
	public PersonV2 personsusingMediaType2() { 
		return new PersonV2(new Name("Bob", "Marley") );
	}
}
