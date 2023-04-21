package com.formation.blog.repository.springdatajpa;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;

import com.formation.blog.model.Review;

public interface SpringDataReviewRepository extends JpaRepository<Review, Integer> {

	public Collection<Review> findByArticleId(int articleId);
}
