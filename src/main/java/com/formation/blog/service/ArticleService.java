package com.formation.blog.service;

import java.util.Collection;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.formation.blog.model.Article;
import com.formation.blog.repository.springdatajpa.SpringDataArticleRepository;

@Service
public class ArticleService {
	
	private SpringDataArticleRepository articleRepository;
	
	@Autowired
	public ArticleService(SpringDataArticleRepository articleRepository) {
		this.articleRepository = articleRepository;
	}
	
	@Transactional(readOnly = true)
	public Collection<Article> getArticles() {
		return articleRepository.findAll();
	}
	
	@Transactional(readOnly = true)
	public Optional<Article> findArticleById(int id) {
		return articleRepository.findById(id);
	}
	
	@Transactional(readOnly = true)
	public Collection<Article> findArticleByAuthor(String author) {
		return articleRepository.findByAuthor(author);
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
		articleRepository.deleteById(articleId);;
	}

}
