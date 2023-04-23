package com.formation.blog.service;

import java.util.Collection;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.formation.blog.exceptions.EntityNotFoundException;
import com.formation.blog.exceptions.UserAlreadyExistException;
import com.formation.blog.model.User;
import com.formation.blog.repository.springdatajpa.SpringDataUserRepository;

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
		Optional<User> user = springDataUserRepository.findById(userId);
		return Optional
				.ofNullable(user.orElseThrow(() -> new EntityNotFoundException("article not found with id: " + userId)));
	}

	@Transactional
	public ResponseEntity<User> signUp(User user) throws UserAlreadyExistException {

		boolean isUserUnique = springDataUserRepository.findUserByUsername(user.getUsername()).size() == 0
				&& springDataUserRepository.findUserByEmail(user.getEmail()).size() == 0;

		if (!isUserUnique) {
			throw new UserAlreadyExistException(
					"User already exist with username :" + user.getUsername() + " and email: " + user.getEmail());
		}
		springDataUserRepository.save(user);
		return new ResponseEntity<>(user, HttpStatus.CREATED);
	}

}
