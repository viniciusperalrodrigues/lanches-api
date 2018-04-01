package com.lanches.api;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.lanches.api.resource.LancheResource;

public class LancheTest extends LanchesApiApplicationTests{

	private MockMvc mockMvc;

	@Autowired
	private LancheResource lr;

	@Before
	public void setUp() {
		this.mockMvc = MockMvcBuilders.standaloneSetup(lr).build();
	}
	
	@Test
	public void listLanches() throws Exception {
		this.mockMvc.perform(MockMvcRequestBuilders.get("/lanche/")).andExpect(MockMvcResultMatchers.status().isOk());
	}

}
