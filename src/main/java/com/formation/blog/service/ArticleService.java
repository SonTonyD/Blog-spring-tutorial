package com.formation.blog.service;

import java.util.Collection;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.formation.blog.model.Article;
import com.formation.blog.model.Tag;
import com.formation.blog.repository.springdatajpa.SpringDataArticleRepository;

@Service
public class ArticleService {
	
	private SpringDataArticleRepository springDataArticleRepository;
	
	@Autowired
	public ArticleService(SpringDataArticleRepository articleRepository) {
		this.springDataArticleRepository = articleRepository;
	}
	
	@Transactional(readOnly = true)
	public Collection<Article> getArticles() {
		return springDataArticleRepository.findAll();
	}
	
	@Transactional(readOnly = true)
	public Optional<Article> findArticleById(int id) {
		return springDataArticleRepository.findById(id);
	}
	
	@Transactional(readOnly = true)
	public Collection<Article> findArticleByAuthor(String author) {
		return springDataArticleRepository.findByAuthor(author);
	}
	
	@Transactional(readOnly = true)
	public Collection<Tag> findTags(int article_id) {
		return springDataArticleRepository.findTags(article_id);
	}
	
	@Transactional
	public void updateArticleContent(String newContent, int id) {
		springDataArticleRepository.updateContent(newContent, id);
	}
	
	@Transactional
	public void createArticle(Article article) {
		springDataArticleRepository.save(article);
	}
	
	@Transactional
	public void deleteArticleById(int articleId) {
		springDataArticleRepository.deleteById(articleId);;
	}
	
	
	
	

}
