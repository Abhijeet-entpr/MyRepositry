package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {
	@GetMapping("/help")
	public String show() {
		System.out.println("sing");
		return "this is my first project";
	}

}
