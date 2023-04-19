package com.formation.blog.service;

import java.util.Collection;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.formation.blog.model.User;
import com.formation.blog.repository.springdatajpa.SpringDataUserRepository;
import com.formation.blog.util.ResponseTransfer;

@Service
public class UserService {
	
	private SpringDataUserRepository springDataUserRepository;
	
	@Autowired
	public UserService(SpringDataUserRepository userRepository) {
		this.springDataUserRepository = userRepository;
	}
	
	@Transactional
	public Collection<User> getUsers() {
		return springDataUserRepository.findAll();
	}
	
	@Transactional
	public Optional<User> getUserById(int userId) {
		return springDataUserRepository.findById(userId);
	}

	@Transactional
	public ResponseTransfer signUp(User user) {
		
		boolean isUserUnique = springDataUserRepository.findUserByUsername(user.getUsername()).size() == 0
				&& springDataUserRepository.findUserByEmail(user.getEmail()).size() == 0;
		
		if (!isUserUnique) {
			return new ResponseTransfer("Username or Email already exists");
		}
		springDataUserRepository.save(user);
		return new ResponseTransfer("Registration complete !");
	}

}
