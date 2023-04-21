package com.formation.blog.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.formation.blog.service.ArticleService;
import com.formation.blog.web.ArticleController;

@AutoConfigureMockMvc
@WebMvcTest(controllers = ArticleController.class)
public class ArticleControllerTests {

	@Autowired
	private MockMvc mockMvc;
	
	private static final int TEST_ARTICLE_ID = 1;
	

	String jsonStringArticle = "{\"name\":\"Louis Article\",\"author\":\"Louis\",\"content\":\"Article about Japan\"}";

	@MockBean
	private ArticleService articleService;

	@Test
	public void testGetArticles() throws Exception {
		mockMvc.perform(get("/articles")).andExpect(status().isOk());
	}

	@Test
	public void testGetArticleById() throws Exception {
		mockMvc.perform(get("/article/" + TEST_ARTICLE_ID)).andExpect(status().isOk());
	}

	@Test
	public void testGetArticlesByAuthor() throws Exception {
		mockMvc.perform(get("/articles/author/Bob")).andExpect(status().isOk());
	}

	@Test
	public void testCreateArticle() throws Exception {
		mockMvc.perform(post("/articles/new").content(jsonStringArticle).contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON)).andExpect(status().isCreated());
	}

	@Test
	public void testUpdateArticleContent() throws Exception {
		mockMvc.perform(put("/articles/"+TEST_ARTICLE_ID).content("NEW CONTENT")).andExpect(status().isOk());
	}
	
	@Test
	public void testDeleteArticleById() throws Exception {
		mockMvc.perform(delete("/articles/"+TEST_ARTICLE_ID)).andExpect(status().isNotFound());
	}

}
