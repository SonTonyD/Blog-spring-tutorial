package com.formation.blog.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.formation.blog.repository.springdatajpa.SpringDataArticleRepository;
import com.formation.blog.repository.springdatajpa.SpringDataReviewRepository;
import com.formation.blog.repository.springdatajpa.SpringDataUserRepository;

public class BlogService {
	
	private ArticleService articleService;
	private ReviewService reviewService;
	private UserService userService;
	private TagService tagService;
	
	@Autowired
	public BlogService(ArticleService articleService,
			ReviewService reviewService,
			UserService userService,
			TagService tagService) 
	{
		this.articleService = articleService;
		this.reviewService = reviewService;
		this.userService = userService;
		this.tagService = tagService;
	}

}
