package com.formation.blog.repository;

import java.util.Collection;

import com.formation.blog.model.Article;



/**
 * @author sodin
 *
 */
public interface ArticleRepository {

	Collection<Article> findByAuthor(String author);
	
	Article findById(int id);
	
	Collection<Article> getAll();
	
	void updateContent(String newContent, int id);
	
    void save(Article article);
    
    void deleteById(int id);
}
