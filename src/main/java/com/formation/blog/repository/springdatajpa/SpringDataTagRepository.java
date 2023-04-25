package com.formation.blog.repository.springdatajpa;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.formation.blog.model.Tag;

public interface SpringDataTagRepository extends JpaRepository<Tag, Integer> {

	@Query(value = "SELECT TAG.* FROM HAVE_TAG INNER JOIN TAG ON HAVE_TAG.tagid = TAG.id WHERE HAVE_TAG.articleid =:articleid", nativeQuery = true)
	public Collection<Tag> findTagsById(int articleid);
	
	@Query(value = "SELECT id FROM Tag WHERE name =:tagName", nativeQuery = true)
	public int findIdByName(@Param("tagName") String tagName);
}
