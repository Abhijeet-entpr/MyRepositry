package com.example.googleMap.GoogleMapApi.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MapController {
	@GetMapping("/showMap")
	public String getMap() {
		return "index";
	}
	
	@GetMapping("/first")
	public String first() {
		return "first";
	}
}
