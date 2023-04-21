package com.formation.blog.repository.springdatajpa;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.formation.blog.model.Article;

public interface SpringDataArticleRepository extends JpaRepository<Article, Integer> {
	
	@Query(value = "SELECT * FROM Article WHERE author =:author", nativeQuery = true)
	public Collection<Article> findByAuthor(@Param("author") String author);
	
	@Modifying
	@Query(value = "UPDATE Article SET Article.content=:newContent WHERE id =:id", nativeQuery = true)
	public void updateContent(@Param("newContent") String newContent, @Param("id") int id);
	
}
