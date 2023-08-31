package com.example.rest.webservices.restful.webservice.api.Users;

import java.net.URI;
import java.util.List;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.example.rest.webservices.restful.webservice.api.Exceptions.UserNotFoundException;

import jakarta.validation.Valid;

@RestController
public class UserResource {
		
	private UserServiceDao serviceDao;
	
	public UserResource(UserServiceDao serviceDao) {
		super();
		this.serviceDao = serviceDao;
	}
	@GetMapping(path="/users")
	public List<User> findAll(){
		return serviceDao.retrieveUsers();
	}
	@GetMapping(path="/users/{userId}")
	public EntityModel <User> findOne(@PathVariable long userId) {
		User user = serviceDao.retreiveUser(userId);
		if(user==null) { 
			throw new UserNotFoundException("userId :"+userId);
		}
		
		EntityModel<User> entityModel = EntityModel.of(user);
		WebMvcLinkBuilder link = linkTo(methodOn(this.getClass()).findAll());
				entityModel.add(link.withRel("all-user"));
				return entityModel;
	}
	
	@DeleteMapping(path="/users/{userId}")
	public void deleteOne(@PathVariable long userId) {
		serviceDao.deleteUser(userId);
	}
	
	
	@PostMapping(path="/users")
	public ResponseEntity<User> createUser(@Valid @RequestBody User user) {
		User savedUser=  serviceDao.addUser(user);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{userId}")
				.buildAndExpand(savedUser.getUserId())
				.toUri();
		return ResponseEntity.created(location).build();
		}
}
