package com.formation.blog.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.formation.blog.repository.springdatajpa.SpringDataArticleRepository;
import com.formation.blog.repository.springdatajpa.SpringDataReviewRepository;
import com.formation.blog.repository.springdatajpa.SpringDataUserRepository;

public class BlogService {
	
	private SpringDataArticleRepository springDataArticleRepository;
	private SpringDataReviewRepository springDataReviewRepository;
	private SpringDataUserRepository springDataUserRepository;
	
	@Autowired
	public BlogService(SpringDataArticleRepository articleRepository,
			SpringDataReviewRepository reviewRepository,
			SpringDataUserRepository userRepository) 
	{
		this.springDataArticleRepository = articleRepository;
		this.springDataReviewRepository = reviewRepository;
		this.springDataUserRepository = userRepository;
	}

}
