package com.todomanagement.app.ToDoApplication.ToDo;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Size;

@Entity
public class ToDo {
	@Id
	@GeneratedValue
	private long id;
	private String username;
	@Size(min=5,message = "Enter atleast 5 character")
	private String description;
	private LocalDate targetdate;
	private boolean done;

	public LocalDate getTargetdate() {
		return targetdate;
	}

	public void setTargetdate(LocalDate targetdate) {
		this.targetdate = targetdate;
	}
	public ToDo() {
		
	}

	
	public ToDo(long id, String username, String description, LocalDate targetDate, boolean done) {
		super();
		this.id = id;
		this.username = username;
		this.description = description;
		this.targetdate = targetDate;
		this.done = done;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public LocalDate getTargetDate() {
		return targetdate;
	}

	public void setTargetDate(LocalDate targerDate) {
		this.targetdate = targerDate;
	}

	public boolean getDone() {
		return done;
	}

	public void setDone(boolean done) {
		this.done = done;
	}

	@Override
	public String toString() {
		return "ToDo [id=" + id + ", username=" + username + ", description=" + description + ", targetDate="
				+ targetdate + ", done=" + done + "]";
	}
	
}
