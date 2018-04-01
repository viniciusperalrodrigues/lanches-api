package com.lanches.api;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.lanches.api.resource.IngredienteResource;

public class IngredienteTest extends LanchesApiApplicationTests{
	
	private MockMvc mockMvc;

	@Autowired
	private IngredienteResource ir;

	@Before
	public void setUp() {
		this.mockMvc = MockMvcBuilders.standaloneSetup(ir).build();
	}
	
	@Test
	public void listIngredientes() throws Exception {
		this.mockMvc.perform(MockMvcRequestBuilders.get("/ingrediente/")).andExpect(MockMvcResultMatchers.status().isOk());
	}

}
