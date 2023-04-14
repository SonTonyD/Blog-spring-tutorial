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
	 * @param name
	 * @return
	 */
	Collection<Article> findByName(String name);
	
	/**
	 * @param id
	 * @return
	 */
	Article findById(int id);
    
	/**
     * @param article
     */
    void save(Article article);
}
