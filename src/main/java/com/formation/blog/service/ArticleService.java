package com.formation.blog.service;

import java.util.Collection;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.formation.blog.exceptions.EntityNotFoundException;
import com.formation.blog.model.Article;
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
		Optional<Article> article = springDataArticleRepository.findById(id);
		return Optional
				.ofNullable(article.orElseThrow(() -> new EntityNotFoundException("article not found with id: " + id)));
	}

	@Transactional(readOnly = true)
	public Collection<Article> findArticleByAuthor(String author) {
		return springDataArticleRepository.findByAuthor(author);
	}

	@Transactional
	public Optional<Article> updateArticleContent(String newContent, int id) {
		Optional<Article> article = Optional
				.ofNullable(springDataArticleRepository.findById(id).orElseThrow(() -> new EntityNotFoundException(
						"Unable to update article content, it was not found with id: " + id)));
		springDataArticleRepository.updateContent(newContent, id);
		return article;
	}

	@Transactional
	public void createArticle(Article article) {
		springDataArticleRepository.save(article);
	}

	@Transactional
	public Optional<Article> deleteArticleById(int articleId) {
		Optional<Article> deletedArticle = Optional.ofNullable(
				springDataArticleRepository.findById(articleId).orElseThrow(() -> new EntityNotFoundException(
						"Unable to delete this article, it was not found with id: " + articleId)));
		springDataArticleRepository.deleteById(articleId);
		return deletedArticle;
	}

//	@Transactional
//	public Collection<Tag> addTagToArticle(int articleId) {
//		springDataArticleRepository.findTags(articleId)
//		
//	}

}
