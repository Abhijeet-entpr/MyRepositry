package com.example.rest.webservices.restful.webservice.api.Users;

import java.time.LocalDate;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;

@Entity(name="user_details")
public class User {
		@Id
		@GeneratedValue
	private long userId;
	@Size(min=2,message = "Enter atleast 2 character")
	//@JsonProperty("username")
	private String name;
	@Past(message = "Enter Past Date")
	//@JsonProperty("DateOfBirth")
	private LocalDate dob;
	
	@OneToMany(mappedBy = "user")
	@JsonIgnore
	private List<Post> posts;
	
	
	public User(long userId, String name, LocalDate dob) {
		super();
		this.userId = userId;
		this.name = name;
		this.dob = dob;
	}
	protected User() {  
		
	}
	
	public long getUserId() {
		return userId;
	}
	public void setUserId(long userId) {
		this.userId = userId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public LocalDate getDob() {
		return dob;
	}
	public void setDob(LocalDate dob) {
		this.dob = dob;
	}
	
	public void setPosts(List<Post> posts) {
		this.posts = posts;
	}
	@Override
	public String toString() {
		return "User [userId=" + userId + ", name=" + name + ", dob=" + dob + ", posts=" + posts + "]";
	}
	public List<Post> getPosts() {
		// TODO Auto-generated method stub
		return posts;
	}
	
	
	
}
