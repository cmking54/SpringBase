package com.example.demo;

import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.hamcrest.CoreMatchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

@RunWith(SpringRunner.class)
@WebMvcTest(HomeController.class)
public class HelloControllerTest {

	@Autowired
	private MockMvc mockMVC;
	
	@Test
	public void testHomePage() throws Exception{
		mockMVC.perform(get("/")) // performs get
		.andExpect(status().isOk()) // expects HTTP 200
		.andExpect(view().name("home")) // expects home view
		.andExpect(content().string(containsString("Welcome"))); // Expects Welcome presented
	}

}
