package com.formation.blog.repository.springdatajpa;

import org.springframework.data.jpa.repository.JpaRepository;

import com.formation.blog.model.User;

public interface SpringDataUserRepository extends JpaRepository<User, Integer> {
	
//	@Override
//	@Query(value = "SELECT * FROM Userdata", nativeQuery = true)
//	public Collection<User> getAll();
//	
//	@Override
//	@Query(value = "SELECT * FROM Userdata WHERE id =:id", nativeQuery = true)
//	public User findUserById(@Param("id") int userId);
//	
//	@Override
//	@Query(value = "SELECT * FROM Userdata WHERE username =:username", nativeQuery = true)
//	public Collection<User> findUserByUsername(@Param("username") String username);
//	
//	@Override
//	@Query(value = "SELECT * FROM Userdata WHERE email =:email", nativeQuery = true)
//	public Collection<User> findUserByEmail(@Param("email") String email);
	
}
