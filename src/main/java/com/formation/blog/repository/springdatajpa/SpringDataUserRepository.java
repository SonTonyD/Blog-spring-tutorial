package com.formation.blog.repository.springdatajpa;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;

import com.formation.blog.model.User;
import com.formation.blog.repository.UserRepository;

public interface SpringDataUserRepository extends UserRepository, Repository<User, Integer> {
	
	@Override
	@Query(value = "SELECT * FROM Userdata", nativeQuery = true)
	public Collection<User> getAll();
	
	@Override
	@Query(value = "SELECT * FROM Userdata WHERE id =:id", nativeQuery = true)
	public User findUserById(@Param("id") int userId);
}
