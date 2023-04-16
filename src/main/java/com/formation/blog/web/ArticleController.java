package com.formation.blog.web;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
	
	@GetMapping("/articles")
	public Collection<Article> getArticles() {
		return blogService.getArticles();
	}
	
	@GetMapping("/articles/{articleId}")
	public Article getArticleObject(@PathVariable("articleId") int articleId) {
		Article article = blogService.findArticleById(articleId);
		return article;
	}
	
	@GetMapping("/articles/author/{articleAuthor}")
	public Collection<String> getArticlesByName(@PathVariable("articleAuthor") String articleAuthor) {
		Collection<String> articles = blogService.findArticleByAuthor(articleAuthor);
		return articles;
	}
	
	@PutMapping("/articles/{articleId}")
	public void updateArticleContent(@PathVariable("articleId") int articleId, @RequestBody String content) {
		blogService.updateArticleContent(content, articleId);
	}
	
	@PostMapping("/articles/new")
	public void createArticle(@RequestBody Article article) {
		blogService.createArticle(article);
	}
	
	@DeleteMapping("/articles/{articleId}")
	public void deleteArticle(@PathVariable("articleId") int articleId) {
		blogService.deleteArticleById(articleId);
	}
	

	
}
