package com.formation.blog.web;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.formation.blog.model.User;
import com.formation.blog.service.BlogService;

@RestController
public class UserController {
	
	@Autowired
	private BlogService blogService;
	
	@GetMapping("/users")
	public Collection<User> getUsers() {
		return blogService.getUsers();
	}
	
	@GetMapping("/users/{id}")
	public User getUser(@PathVariable("id") int userId) {
		return blogService.getUserById(userId);
	}
	
	@PostMapping("/auth/signup")
	public void signUp(@RequestBody User user) {
		blogService.signUp(user);
	}
}
