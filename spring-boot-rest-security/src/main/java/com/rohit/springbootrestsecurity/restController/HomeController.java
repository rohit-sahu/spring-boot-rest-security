package com.rohit.springbootrestsecurity.restController;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

	@GetMapping(value = "/")
	public String home() {
		return "Hello Rohit";
	}
	
	@PreAuthorize("hasAnyRole('ADMIN')")
	@GetMapping(value = "/admin")
	public String adminHome() {
		return "Hello Admin";
	}
}
