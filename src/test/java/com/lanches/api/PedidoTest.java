package com.lanches.api;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.lanches.api.entity.Lanche;
import com.lanches.api.entity.Pedido;
import com.lanches.api.resource.PedidoResource;
import com.lanches.api.service.LancheService;

public class PedidoTest extends LanchesApiApplicationTests{

	private MockMvc mockMvc;

	@Autowired
	private PedidoResource pr;
	
	@Autowired
	private LancheService ls;
	
	@Before
	public void setUp() {
		this.mockMvc = MockMvcBuilders.standaloneSetup(pr).build();
	}
	
	@Test
	public void testPedido() throws Exception {
		List<Lanche> lanches = ls.getLanches();
		
		Pedido pedido = new Pedido();
		
		pedido.setLanches(lanches);
		
		ObjectMapper mapper = new ObjectMapper();
		
		String json = mapper.writeValueAsString(pedido);

		this.mockMvc.perform(post("/pedido/save").contentType(MediaType.APPLICATION_JSON).content(json))
				.andExpect(status().isCreated());
	}
}
