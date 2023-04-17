package com.formation.blog.service;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Collection;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.formation.blog.model.Article;

public class BlogServiceTests {
	
	@Autowired
    protected BlogService blogService;
	
	@Test
    void shouldFindArticlesByAuthor() {
        Collection<Article> articles = this.blogService.findArticleByAuthor("Alice");
        assertThat(articles.size()).isEqualTo(2);

        articles = this.blogService.findArticleByAuthor("Alice");
        assertThat(articles.isEmpty()).isTrue();
    }

}
