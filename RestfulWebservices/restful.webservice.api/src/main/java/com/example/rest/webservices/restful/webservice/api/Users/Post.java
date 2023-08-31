package com.example.rest.webservices.restful.webservice.api.Users;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Post {
	@Id
	@GeneratedValue
	private long postId;
	private String description;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JsonIgnore
	private User user;
	
	public long getId() {
		return postId;
	}
	public void setId(Long postId) {
		this.postId = postId;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	public User getUser() {
		return user;
	}
	@Override
	public String toString() {
		return "Post [id=" + postId + ", description=" + description + "]";
	}
	public void setUser(User user) {
		// TODO Auto-generated method stub
		this.user = user;
	}
	
}
