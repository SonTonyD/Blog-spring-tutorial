package com.formation.blog.web;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.formation.blog.model.Review;
import com.formation.blog.service.BlogService;

@RestController
public class ReviewController {
	@Autowired
	private BlogService blogService;
	
	@GetMapping("/reviews")
	public Collection<Review> getReviews() {
		return blogService.getReviews();
	}
	
	@GetMapping("/reviews/{articleId}")
	public Collection<Review> getReviewsOfArticle(@PathVariable("articleId") int articleId) {
		return blogService.getReviewsOfArticle(articleId);
	}
	
	@PostMapping("/review/new")
	public void createReview(@RequestBody Review review) {
		blogService.createReview(review);
	}
}
