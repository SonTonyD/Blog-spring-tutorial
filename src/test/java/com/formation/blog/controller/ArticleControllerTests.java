package com.formation.blog.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.formation.blog.model.Article;
import com.formation.blog.service.ArticleService;
import com.formation.blog.web.ArticleController;

@AutoConfigureMockMvc
@WebMvcTest(controllers = ArticleController.class)
public class ArticleControllerTests {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private ArticleService articleService;

	@Test
	public void testGetArticles() throws Exception {
		mockMvc.perform(get("/articles")).andExpect(status().isOk());
	}

	@Test
	public void testGetArticleById() throws Exception {
		mockMvc.perform(get("/article/1")).andExpect(status().isNotFound());
	}

	@Test
	public void testGetArticlesByAuthor() throws Exception {
		mockMvc.perform(get("/articles/author/Bob")).andExpect(status().isOk());
	}
}
