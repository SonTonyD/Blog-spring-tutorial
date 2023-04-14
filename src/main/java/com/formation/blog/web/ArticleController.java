package com.formation.blog.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ArticleController {
	
	@GetMapping("/")
	public String index() {
		return "Greetings from Spring Boot!";
	}
	
}
