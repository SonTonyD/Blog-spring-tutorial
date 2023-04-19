package com.formation.blog.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.formation.blog.repository.springdatajpa.SpringDataArticleRepository;
import com.formation.blog.repository.springdatajpa.SpringDataReviewRepository;

public class ReviewService {
	
	private SpringDataReviewRepository springDataReviewRepository;
	
	@Autowired
	public ReviewService(SpringDataReviewRepository reviewRepository) {
		this.springDataReviewRepository = reviewRepository;
	}

}
