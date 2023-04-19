package com.formation.blog.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.formation.blog.repository.springdatajpa.SpringDataReviewRepository;

@Service
public class ReviewService {
	
	private SpringDataReviewRepository springDataReviewRepository;
	
	@Autowired
	public ReviewService(SpringDataReviewRepository reviewRepository) {
		this.springDataReviewRepository = reviewRepository;
	}

//	@Transactional(readOnly = true)
//	public Collection<Review> getReviews() {
//		return reviewRepository.getAll();
//	}
//	
//	@Transactional(readOnly = true)
//	public Collection<Review> getReviewsOfArticle(int articleId) {
//		return reviewRepository.findByArticleId(articleId);
//	}
//	
//	@Transactional
//	public void createReview(Review review) {
//		reviewRepository.save(review);
//	}

}
