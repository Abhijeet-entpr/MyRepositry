package com.example.rest.webservices.restful.webservice.api.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.rest.webservices.restful.webservice.api.Users.Post;

public interface PostRepository extends JpaRepository<Post, Long>{

}
