package com.formation.blog.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.formation.blog.repository.springdatajpa.SpringDataUserRepository;

public class UserService {
	
	private SpringDataUserRepository springDataUserRepository;
	
	@Autowired
	public UserService(SpringDataUserRepository userRepository) {
		this.springDataUserRepository = userRepository;
	}

}
