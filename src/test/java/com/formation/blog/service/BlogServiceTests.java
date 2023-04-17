package com.formation.blog.service;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import com.formation.blog.web.ArticleController;

//@RunWith(SpringRunner.class)
//@WebMvcTest(ArticleController.class)
@WebMvcTest(controllers = ArticleController.class)
public class BlogServiceTests {
	
	@Autowired
    private MockMvc mockMvc;

    @MockBean
    private BlogService blogService;

    @Test
    public void testGetArticles() throws Exception {
        mockMvc.perform(get("/articles"))
            .andExpect(status().isOk());
    }
	
//	@Autowired
//    private BlogService blogService;
//	
//	@Test
//    void shouldFindArticlesByAuthor() {
//        Collection<Article> articles = this.blogService.findArticleByAuthor("Bob");
//        assertThat(articles.size()).isEqualTo(2);
//
//        articles = this.blogService.findArticleByAuthor("Bobb");
//        assertThat(articles.isEmpty()).isTrue();
//    }
	
//	@Autowired
//    private BlogService blogService;
//
//    @Test
//    void shouldFindOwnersByLastName() {
//        Collection<Article> articles = this.blogService.findArticleByAuthor("Bob");
//        assertThat(articles.size()).isEqualTo(2);
//
//        articles = this.blogService.findArticleByAuthor("Bobb");
//        assertThat(articles.isEmpty()).isTrue();
//    }

}
