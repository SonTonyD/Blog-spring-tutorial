package com.formation.blog.web;

import java.util.Collection;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.formation.blog.exceptions.EntityNotFoundException;
import com.formation.blog.model.User;
import com.formation.blog.service.UserService;
import com.formation.blog.util.ResponseTransfer;

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
		Optional<User> user = Optional.ofNullable(userService.getUserById(userId)
				.orElseThrow(() -> new EntityNotFoundException("User not found with id: "+userId)));
		return user;
	}
	
	@PostMapping("/auth/signup")
	@ResponseBody
	public ResponseTransfer signUp(@RequestBody User user) {
		return userService.signUp(user);
	}
}
