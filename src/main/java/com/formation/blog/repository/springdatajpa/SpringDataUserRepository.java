package com.formation.blog.repository.springdatajpa;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.formation.blog.model.User;

public interface SpringDataUserRepository extends JpaRepository<User, Integer> {
	
	@Query(value = "SELECT * FROM Userdata WHERE username =:username", nativeQuery = true)
	public Collection<User> findUserByUsername(@Param("username") String username);
	
	@Query(value = "SELECT * FROM Userdata WHERE email =:email", nativeQuery = true)
	public Collection<User> findUserByEmail(@Param("email") String email);
	
}
