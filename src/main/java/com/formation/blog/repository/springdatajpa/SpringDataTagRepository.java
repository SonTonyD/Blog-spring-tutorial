package com.formation.blog.repository.springdatajpa;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.formation.blog.model.Tag;

public interface SpringDataTagRepository extends JpaRepository<Tag, Integer> {
	
	@Query(value = "SELECT tags FROM Article WHERE id =:id", nativeQuery = true)
	public Collection<Tag> findTags(@Param("id") int id);
}
