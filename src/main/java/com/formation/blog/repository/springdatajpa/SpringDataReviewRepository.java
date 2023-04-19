package com.formation.blog.repository.springdatajpa;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.formation.blog.model.Review;

public interface SpringDataReviewRepository extends JpaRepository<Review, Integer> {

	@Query(value = "SELECT * FROM Review WHERE article_id =:article_id", nativeQuery = true)
	public Collection<Review> findByArticleId(@Param("article_id") int articleId);
}
