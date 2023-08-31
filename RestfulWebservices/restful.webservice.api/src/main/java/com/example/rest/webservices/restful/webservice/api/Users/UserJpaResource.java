package com.example.rest.webservices.restful.webservice.api.Users;

import java.net.URI;
import java.util.List;
import java.util.Optional;

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
import com.example.rest.webservices.restful.webservice.api.jpa.PostRepository;
import com.example.rest.webservices.restful.webservice.api.jpa.UserRepository;

import jakarta.validation.Valid;

@RestController
public class UserJpaResource {
		
	private UserServiceDao serviceDao;
	private UserRepository repository;
	private PostRepository postRepository;
	public UserJpaResource(UserRepository repository,PostRepository postRepository) {
		super();
		this.repository=repository;
		this.postRepository=postRepository;
	}
	@GetMapping(path="/jpa/users")
	public List<User> findAllUser(){
		return repository.findAll();
	}
	@GetMapping(path="/jpa/users/{userId}")
	public EntityModel <User> findOne(@PathVariable long userId) {
		Optional<User> user = repository.findById(userId);
		if(user.isEmpty()) { 
			throw new UserNotFoundException("userId :"+userId);
		}
		
		EntityModel<User> entityModel = EntityModel.of(user.get());
		WebMvcLinkBuilder link = linkTo(methodOn(this.getClass()).findAllUser());
				entityModel.add(link.withRel("all-user"));
				return entityModel;
	}
	
	@DeleteMapping(path="/jpa/users/{userId}")
	public void deleteOne(@PathVariable long userId) {
		repository.deleteById(userId);
	}
	
	
	@PostMapping(path="/jpa/users")
	public ResponseEntity<User> createUser(@Valid @RequestBody User user) {
		User savedUser=  repository.save(user);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{userId}")
				.buildAndExpand(savedUser.getUserId())
				.toUri();
		return ResponseEntity.created(location).build();
		}
	@GetMapping(path="/jpa/users/{userId}/posts")
	public List<Post> findPostByUser(@PathVariable long userId) {
		Optional<User> user = repository.findById(userId);
		if(user.isEmpty()) { 
			throw new UserNotFoundException("userId :"+userId);
		}
		 return user.get().getPosts();
	}	 
	
	@PostMapping(path="/jpa/users/{userId}/posts")
	public ResponseEntity<Post> createPostByUser(@PathVariable long userId,@Valid @RequestBody Post post) {
		Optional<User> user = repository.findById(userId);
		if(user.isEmpty()) { 
			throw new UserNotFoundException("userId :"+userId);
		}
		 post.setUser(user.get());
	
		Post savedPost = postRepository.save(post);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{postId}")
				.buildAndExpand(savedPost.getId())
				.toUri();
		return ResponseEntity.created(location).build();
		}
}
