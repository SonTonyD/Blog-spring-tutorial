package com.formation.blog.repository;

import java.util.Collection;

import com.formation.blog.model.Article;



/**
 * @author sodin
 *
 */
public interface ArticleRepository {
	/**
	 * Retrieve an <code>Owner</code> from the data store by id.
	 * 
	 * @param author
	 * @return
	 */
	Collection<String> findByAuthor(String author);
	
	/**
	 * @param id
	 * @return
	 */
	Article findById(int id);
	
	/**
	 * @return
	 */
	Collection<Article> getAll();
	
	void updateContent(String newContent, int id);
	
//	void create(Article article);
    
	/**
     * @param article
     */
    void save(Article article);
    
    void deleteById(int id);
}
