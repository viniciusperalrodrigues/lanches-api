package com.lanches.api.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lanches.api.entity.Ingrediente;
import com.lanches.api.service.IngredienteService;

@RestController
@RequestMapping("/ingrediente")
public class IngredienteResource {

	@Autowired
	private IngredienteService ingrediente;
	
	@GetMapping	
	public List<Ingrediente> findAll(){
		return ingrediente.findAll();
	}
	
	
}
