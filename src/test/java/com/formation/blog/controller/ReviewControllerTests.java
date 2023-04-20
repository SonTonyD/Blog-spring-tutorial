package com.formation.blog.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import com.formation.blog.service.ReviewService;
import com.formation.blog.web.ReviewController;

@AutoConfigureMockMvc
@WebMvcTest(controllers = ReviewController.class)
public class ReviewControllerTests {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private ReviewService reviewService;
	
	@Test
	public void testGetReviews() throws Exception {
		mockMvc.perform(get("/reviews")).andExpect(status().isOk());
	}
	
	@Test
	public void testGetReviewsOfArticle() throws Exception {
		mockMvc.perform(get("/reviews/article/"+1)).andExpect(status().isOk());
	}
}
