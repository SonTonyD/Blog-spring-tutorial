package com.formation.blog.repository.springdatajpa;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;

import com.formation.blog.model.Article;
import com.formation.blog.repository.ArticleRepository;

public interface SpringDataArticleRepository extends ArticleRepository, Repository<Article, Integer> {

//	
//	@Override
//    @Query("SELECT * FROM ARTICLE WHERE ARTICLE.id =:id")
//    public Article findById(@Param("id") int id);
//	
	@Override
	@Query("SELECT name FROM Article WHERE author =:author")
	public Collection<String> findByAuthor(@Param("author") String author);
//	
	
}
