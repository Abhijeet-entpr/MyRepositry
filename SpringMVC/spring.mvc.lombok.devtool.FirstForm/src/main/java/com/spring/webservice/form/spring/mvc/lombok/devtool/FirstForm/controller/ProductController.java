package com.spring.webservice.form.spring.mvc.lombok.devtool.FirstForm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.spring.webservice.form.spring.mvc.lombok.devtool.FirstForm.model.Product;

import jakarta.annotation.PostConstruct;

import org.springframework.ui.Model;

@Controller
public class ProductController {
	
	@GetMapping("/pro")
	public String getProductForm(Model model) {
		
		Product product = new Product();
		model.addAttribute("product", product);
		return "index";
	}
	
	@PostMapping("/product")
	public String handleFormSubmit(Product product, Model model) {
		System.out.println(product);
		model.addAttribute("msg","Product saved successfully");
		return "success";
	}
	
}
