package com.formation.blog.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.formation.blog.model.Tag;
import com.formation.blog.service.TagService;
import com.formation.blog.web.TagController;

@AutoConfigureMockMvc
@WebMvcTest(controllers = TagController.class)
public class TagControllerTests {

	@Autowired
	private MockMvc mockMvc;

	String jsonStringTag = "{\"name\":\"Science\"}";
	
	String jsonListTags = "[{\"articleid\":\"1\", \"tagid\":\"2\"},{\"articleid\":\"1\", \"tagid\":\"3\"}]";
	
	
	
	private static final int TEST_ARTICLE_ID = 1;

	@MockBean
	private TagService tagService;

	@Test
	public void testGetTags() throws Exception {
		mockMvc.perform(get("/tags")).andExpect(status().isOk());
	}

	@Test
	public void testCreateTag() throws Exception {
		Tag tag = new Tag();
		tag.setId(1);
		tag.setName("Science");
		
		
		mockMvc.perform(post("/tags/new").content(jsonStringTag).contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON)).andExpect(status().isCreated()).equals(tag);
	}

	@Test
	public void testGetArticleTags() throws Exception {
		mockMvc.perform(get("/articles/" + TEST_ARTICLE_ID + "/tags")).andExpect(status().isOk()).andDo(print());
	}

	@Test
	public void addTagsToArticle() throws Exception {
		mockMvc.perform(post("/articles/" + TEST_ARTICLE_ID + "/tags/add")
				.contentType(MediaType.APPLICATION_JSON_VALUE).content(jsonListTags)).andExpect(status().isOk());
	}

}
