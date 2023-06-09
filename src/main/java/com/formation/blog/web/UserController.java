package com.formation.blog.web;

import java.util.Collection;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.formation.blog.exceptions.UserAlreadyExistException;
import com.formation.blog.model.User;
import com.formation.blog.service.UserService;

@RestController
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@GetMapping("/users")
	public Collection<User> getUsers() {
		return userService.getUsers();
	}
	
	@GetMapping("/users/{id}")
	public Optional<User> getUserById(@PathVariable("id") int userId) {
		return userService.getUserById(userId);
	}
	
	@PostMapping("/auth/signup")
	@ResponseBody
	public ResponseEntity<User> signUp(@RequestBody User user) throws UserAlreadyExistException {
		return userService.signUp(user);
	}
}
