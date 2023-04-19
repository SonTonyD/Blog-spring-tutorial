package com.formation.blog.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.formation.blog.model.Article;
import com.formation.blog.repository.springdatajpa.SpringDataArticleRepository;

public class ArticleService {
	
	private SpringDataArticleRepository springDataArticleRepository;
	
	@Autowired
	public ArticleService(SpringDataArticleRepository articleRepository) {
		this.springDataArticleRepository = articleRepository;
	}
	
	@Transactional(readOnly = true)
	public Article findArticleById(int id) {
		
		
		return springDataArticleRepository.findById(id).orElseThrow();
		
		
		
	}

}
