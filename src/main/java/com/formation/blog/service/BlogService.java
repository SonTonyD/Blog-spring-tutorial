package com.formation.blog.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.formation.blog.model.Article;
import com.formation.blog.model.Review;
import com.formation.blog.model.User;
import com.formation.blog.repository.ArticleRepository;
import com.formation.blog.repository.ReviewRepository;
import com.formation.blog.repository.UserRepository;

@Service
public class BlogService {
	
	private ArticleRepository articleRepository;
	private ReviewRepository reviewRepository;
	private UserRepository userRepository;
	
	@Autowired
	public BlogService(ArticleRepository articleRepository, ReviewRepository reviewRepository, UserRepository userRepository) {
		this.articleRepository = articleRepository;
		this.reviewRepository = reviewRepository;
		this.userRepository = userRepository;
	}
	
	@Transactional(readOnly = true)
	public Article findArticleById(int id) {
		return articleRepository.findById(id);
	}
	
	@Transactional(readOnly = true)
	public Collection<Article> findArticleByAuthor(String author) {
		return articleRepository.findByAuthor(author);
	}
	
	@Transactional(readOnly = true)
	public Collection<Article> getArticles() {
		return articleRepository.getAll();
	}
	
	@Transactional
	public void saveArticle(Article article) {
		articleRepository.save(article);
	}
	
	@Transactional
	public void updateArticleContent(String newContent, int id) {
		articleRepository.updateContent(newContent, id);
	}
	
	@Transactional
	public void createArticle(Article article) {
		articleRepository.save(article);
	}
	
	@Transactional
	public void deleteArticleById(int articleId) {
		articleRepository.deleteById(articleId);
	}
	
	@Transactional(readOnly = true)
	public Collection<Review> getReviews() {
		return reviewRepository.getAll();
	}
	
	@Transactional(readOnly = true)
	public Collection<Review> getReviewsOfArticle(int articleId) {
		return reviewRepository.findByArticleId(articleId);
	}
	
	@Transactional
	public void createReview(Review review) {
		reviewRepository.save(review);
	}
	
	@Transactional
	public Collection<User> getUsers() {
		return userRepository.getAll();
	}
	
	@Transactional
	public User getUserById(int userId) {
		return userRepository.findUserById(userId);
	}
}
