package com.persistence.LearnJPAandHibernate.SpringData;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class User {
	@Id
	private Long id;
	private String name; 
	private String country;
	private String gender;
	private Integer age;
	public User() {
		
	}
	
	public User(Long id, String name, String country, String gender, Integer age) {
		super();
		this.id = id;
		this.name = name;
		this.country = country;
		this.gender = gender;
		this.age = age;
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

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", country=" + country + ", gender=" + gender + ", age=" + age
				+ "]";
	}
	
}
