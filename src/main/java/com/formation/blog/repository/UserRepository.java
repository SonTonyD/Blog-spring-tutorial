package com.formation.blog.repository;

import java.util.Collection;

import com.formation.blog.model.User;

public interface UserRepository {
	
	Collection<User> getAll();
	
	User findUserById(int userId);
	
	void save(User user);
}
