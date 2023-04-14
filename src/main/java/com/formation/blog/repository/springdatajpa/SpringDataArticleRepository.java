package com.formation.blog.repository.springdatajpa;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;

import com.formation.blog.model.Article;
import com.formation.blog.repository.ArticleRepository;

public interface SpringDataArticleRepository extends ArticleRepository, Repository<Article, Integer> {

	/*
	@Override
    @Query("SELECT article FROM Article WHERE article.id =:id")
    public Article findById(@Param("id") int id);
	
	@Override
	@Query("SELECT article FROM Article WHERE article.name =:name")
	public Collection<Article> findByName(@Param("name") String name);
	*/
}
