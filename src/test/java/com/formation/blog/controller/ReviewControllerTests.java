package com.formation.blog.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.formation.blog.model.Review;
import com.formation.blog.service.ReviewService;
import com.formation.blog.web.ReviewController;

@AutoConfigureMockMvc
@WebMvcTest(controllers = ReviewController.class)
public class ReviewControllerTests {

	@Autowired
	private MockMvc mockMvc;
	private static final int TEST_ARTICLE_ID = 1;

	String jsonStringReview = "{\"author\":\"Louis\",\"content\":\"Very good article !\",\"articleId\":\"3\"}";

	@MockBean
	private ReviewService reviewService;

	@Test
	public void testGetReviews() throws Exception {
		mockMvc.perform(get("/reviews")).andExpect(status().isOk());
	}

	@Test
	public void testGetReviewsOfArticle() throws Exception {
		mockMvc.perform(get("/articles/" + TEST_ARTICLE_ID + "/reviews")).andExpect(status().isOk());
	}

	@Test
	public void testCreateReview() throws Exception {
		Review review = new Review();
		review.setArticleId(3);
		review.setAuthor("Louis");
		review.setContent("Very good article !");
		review.setId(1);
		
		mockMvc.perform(post("/review/new").content(jsonStringReview).contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON)).andExpect(status().isCreated()).equals(review);
	}
}
