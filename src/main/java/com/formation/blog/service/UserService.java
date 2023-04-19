package com.formation.blog.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.formation.blog.repository.springdatajpa.SpringDataUserRepository;

@Service
public class UserService {
	
	private SpringDataUserRepository springDataUserRepository;
	
	@Autowired
	public UserService(SpringDataUserRepository userRepository) {
		this.springDataUserRepository = userRepository;
	}

}
