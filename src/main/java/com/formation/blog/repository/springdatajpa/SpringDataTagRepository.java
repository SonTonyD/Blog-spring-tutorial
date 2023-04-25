package com.formation.blog.repository.springdatajpa;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;

import com.formation.blog.model.Tag;

public interface SpringDataTagRepository extends JpaRepository<Tag, Integer> {
	
	public Collection<Tag> findTagsById(int articleid);
}
