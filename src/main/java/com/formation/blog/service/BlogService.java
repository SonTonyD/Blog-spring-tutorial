package com.formation.blog.service;

import org.springframework.beans.factory.annotation.Autowired;

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
