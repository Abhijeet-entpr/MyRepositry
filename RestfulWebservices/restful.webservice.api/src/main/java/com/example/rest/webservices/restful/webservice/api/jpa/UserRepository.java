package com.example.rest.webservices.restful.webservice.api.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.rest.webservices.restful.webservice.api.Users.User;

public interface UserRepository extends JpaRepository<User, Long>{

}
