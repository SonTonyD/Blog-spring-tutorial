package com.formation.blog.web;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.formation.blog.model.Tag;
import com.formation.blog.service.TagService;

@RestController
public class TagController {
	
	@Autowired
	private TagService tagService;
	
	@GetMapping("/tags")
	public Collection<Tag> getArticles() {
		return tagService.getTags();
	}
	
	@GetMapping("/articles/{articleId}/tags")
	public Collection<Tag> getArticles(@PathVariable("articleId") int articleId) {
		return tagService.getArticleTags(articleId);
	}
	
	@PostMapping("/tags/new")
	public ResponseEntity<Tag> createTag(@RequestBody Tag tag) {
		tagService.createTag(tag);
		return new ResponseEntity<>(tag, HttpStatus.CREATED);
	}
	
//	@PostMapping("/articles/{articleId}/tags/add")
//	public void addTagsToArticle(@PathVariable("articleId") int articleId, @RequestBody Collection<Tag> tags) {
//		tagService.addTagsToArticle(articleId, tags);
//	}
	
	@PostMapping("/articles/{articleId}/tags/add")
	public void addTagsToArticle(@PathVariable("articleId") int articleId, @RequestBody Collection<Tag> tags) {
		tagService.addTagsToArticle(articleId, tags);
	}
}
