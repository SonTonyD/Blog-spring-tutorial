package com.formation.blog.repository.springdatajpa;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;

import com.formation.blog.model.Article;
import com.formation.blog.repository.ArticleRepository;

public interface SpringDataArticleRepository extends ArticleRepository, Repository<Article, Integer> {

	
	@Override
    @Query(value = "SELECT * FROM Article WHERE id =:id", nativeQuery = true)
    public Article findById(@Param("id") int id);
	
	@Override
	@Query("SELECT name FROM Article WHERE author =:author")
	public Collection<String> findByAuthor(@Param("author") String author);
	
	@Override
	@Query(value = "SELECT * FROM Article", nativeQuery = true)
	public Collection<Article> getAll();
	
}
