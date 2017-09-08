package com.example.demo;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import controllers.AlunoController;
import controllers.MainController;

@ContextConfiguration()
@RunWith(SpringRunner.class)
@SpringBootTest(classes = {MainController.class, AlunoController.class})
@AutoConfigureMockMvc
public class EscolaApplicationTests {
	
    @Autowired
    private MockMvc mockMvc;

	@Test
	public void contextLoads() {
	}
	
    @Test
    public void greetingWithUser() throws Exception {
        mockMvc.perform(get("/").param("username", "eduardopreuss@gmail.com").param("password", "123"))
                .andExpect(content().string(containsString("")));
    }

}
