package com.formation.blog.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.formation.blog.model.Article;
import com.formation.blog.repository.ArticleRepository;

@Service
public class BlogService {
	
	private ArticleRepository articleRepository;
	
	@Autowired
	public BlogService(ArticleRepository articleRepository) {
		this.articleRepository = articleRepository;
	}
	
	@Transactional(readOnly = true)
	public Article findArticleById(int id) {
		return articleRepository.findById(id);
	}
	
	@Transactional(readOnly = true)
	public Collection<String> findArticleByAuthor(String author) {
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
}
