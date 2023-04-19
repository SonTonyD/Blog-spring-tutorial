package com.formation.blog.service;


import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.formation.blog.model.Review;
import com.formation.blog.repository.springdatajpa.SpringDataReviewRepository;

@Service
public class ReviewService {
	
	private SpringDataReviewRepository springDataReviewRepository;
	
	@Autowired
	public ReviewService(SpringDataReviewRepository reviewRepository) {
		this.springDataReviewRepository = reviewRepository;
	}

	@Transactional(readOnly = true)
	public Collection<Review> getReviews() {
		return springDataReviewRepository.findAll();
	}
	
	@Transactional(readOnly = true)
	public Collection<Review> getReviewsOfArticle(int articleId) {
		return springDataReviewRepository.findByArticleId(articleId);
	}
	
	@Transactional
	public void createReview(Review review) {
		springDataReviewRepository.save(review);
	}


}
