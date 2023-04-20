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

import com.formation.blog.service.UserService;
import com.formation.blog.web.UserController;

@AutoConfigureMockMvc
@WebMvcTest(controllers = UserController.class)
public class UserControllerTests {
	
	@Autowired
	private MockMvc mockMvc;

	String jsonStringUser = "{\"username\":\"Louis21\",\"password\":\"5f4d8e5f5\",\"email\":\"Louis362@gmail.com\"}";
	
	@MockBean
	private UserService userService;
	
	@Test
	public void testGetUsers() throws Exception {
		mockMvc.perform(get("/users")).andExpect(status().isOk());
	}
	
	@Test
	public void testGetUserById() throws Exception {
		mockMvc.perform(get("/users/" + 1)).andExpect(status().isNotFound());
	}
	
	@Test
	public void testSignUpUser() throws Exception {
		mockMvc.perform(post("/auth/signup").content(jsonStringUser).contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON)).andExpect(status().isCreated());
	}

}
