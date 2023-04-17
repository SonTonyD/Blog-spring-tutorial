package com.formation.blog.repository;

import java.util.Collection;

import com.formation.blog.model.Review;

public interface ReviewRepository {
	void save(Review review);
	
	Collection<Review> getAll();
	
	Collection<Review> findByArticleId(int articleId);
}
