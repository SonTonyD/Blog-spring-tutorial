package com.formation.blog.web;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.formation.blog.model.Article;
import com.formation.blog.service.BlogService;

@RestController
public class ArticleController {
	
	@Autowired
	private BlogService blogService;
	
	@GetMapping("/")
	public String index() {
		return "Greetings from Spring Boot!";
	}
	
	@GetMapping("/article/{articleId}")
	public Article getArticleObject(@PathVariable("articleId") int articleId) {
		Article article = blogService.findArticleById(articleId);
		return article;
	}
	
	@GetMapping("/search/{articleName}")
	public Collection<String> getArticlesByName(@PathVariable("articleName") String articleName) {
		Collection<String> articles = blogService.findArticleByName(articleName);
		return articles;
	}
	
}
