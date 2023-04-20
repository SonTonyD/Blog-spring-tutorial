package com.formation.blog.web;

import java.util.Collection;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.formation.blog.exceptions.EntityNotFoundException;
import com.formation.blog.model.Article;
import com.formation.blog.service.ArticleService;



@RestController
public class ArticleController {
	
	@Autowired
	private ArticleService articleService;
	
	@GetMapping("/articles")
	public Collection<Article> getArticles() {
		return articleService.getArticles();
	}
	
//	@GetMapping("/article/{articleId}")
//	public Optional<Article> getArticleById(@PathVariable("articleId") int articleId) {
//		Optional<Article> article = articleService.findArticleById(articleId);
//		return Optional.ofNullable(article.orElseThrow(() -> new EntityNotFoundException("article not found")));
//	}
	
//	@GetMapping("/article/{articleId}")
//	public Optional<Article> getArticleById(@PathVariable("articleId") int articleId) throws EntityNotFoundException{
//		Optional<Article> article = articleService.findArticleById(articleId);
//		
//		if (article.isEmpty()) {
//			throw new EntityNotFoundException("article is not found");
//		}
//		
//		return article;
//	}
	
//	@GetMapping("/article/{articleId}")
//	public ResponseEntity<Article> getArticleById(@PathVariable("articleId") int articleId) throws ArticleNotFoundException {
//		Article article = articleService.findArticleById(articleId)
//				.orElseThrow(() -> new ArticleNotFoundException(articleId));	
//		return new ResponseEntity<>(article, HttpStatus.OK);
//	}
	
	@GetMapping("/article/{articleId}")
	public Optional<Article> getArticleById(@PathVariable("articleId") int articleId) {
		Optional<Article> article = Optional.ofNullable(articleService.findArticleById(articleId)
				.orElseThrow(() -> new EntityNotFoundException("article not found with id: "+articleId)));	
		return article;
	}
	
	@GetMapping("/articles/author/{articleAuthor}")
	public Collection<Article> getArticlesByAuthor(@PathVariable("articleAuthor") String articleAuthor) {
		Collection<Article> articles = articleService.findArticleByAuthor(articleAuthor);
		return articles;
	}
	
	@PutMapping("/articles/{articleId}")
	public void updateArticleContent(@PathVariable("articleId") int articleId, @RequestBody String content) {
		Optional.ofNullable(articleService.findArticleById(articleId)
				.orElseThrow(() -> new EntityNotFoundException("article not found with id: "+articleId)));
		articleService.updateArticleContent(content, articleId);
	}
	
	@PostMapping("/articles/new")
	public void createArticle(@RequestBody Article article) {
		articleService.createArticle(article);
	}
	
	@DeleteMapping("/articles/{articleId}")
	public void deleteArticleById(@PathVariable("articleId") int articleId) {
		articleService.deleteArticleById(articleId);
	}
	

	
}
