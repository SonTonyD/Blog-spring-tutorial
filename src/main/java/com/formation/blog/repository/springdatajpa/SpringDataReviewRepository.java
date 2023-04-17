package com.formation.blog.repository.springdatajpa;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;

import com.formation.blog.model.Review;
import com.formation.blog.repository.ReviewRepository;

public interface SpringDataReviewRepository extends ReviewRepository, Repository<Review, Integer> {

	@Override
	@Query(value = "SELECT * FROM Review", nativeQuery = true)
	public Collection<Review> getAll();
	
	@Override
	@Query(value = "SELECT * FROM Review WHERE article_id =:article_id", nativeQuery = true)
	public Collection<Review> findByArticleId(@Param("article_id") int articleId);
}
