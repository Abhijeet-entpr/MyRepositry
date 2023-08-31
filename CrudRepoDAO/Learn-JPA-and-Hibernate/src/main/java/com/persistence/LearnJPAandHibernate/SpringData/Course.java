package com.persistence.LearnJPAandHibernate.SpringData;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Course {
	@Id
	Long id;
	String name;
	String author;
	public Course(Long id, String name, String author) {
		super();
		this.id = id;
		this.name = name;
		this.author = author;
	}
	public Course() {
		
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	@Override
	public String toString() {
		return "Course [id=" + id + ", name=" + name + ", author=" + author + "]";
	}
	
	
	
}
