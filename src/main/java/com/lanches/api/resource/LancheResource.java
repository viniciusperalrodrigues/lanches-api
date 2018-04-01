package com.lanches.api.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lanches.api.entity.Lanche;
import com.lanches.api.service.LancheService;

/**
 * Classe de serviços do Lanche
 * @author vinicius
 *
 */

@RestController
@RequestMapping("/lanche")
public class LancheResource {

	@Autowired
	private LancheService ls;
	
	@GetMapping
	public List<Lanche> getLanches(){
		return ls.getLanches();
	}
}
