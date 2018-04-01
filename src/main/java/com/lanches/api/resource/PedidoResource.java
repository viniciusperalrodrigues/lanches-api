package com.lanches.api.resource;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.lanches.api.entity.Pedido;
import com.lanches.api.service.PedidoService;

@RestController
@RequestMapping("/pedido")
public class PedidoResource {

	@Autowired
	private PedidoService ps;

	@PostMapping(value = "save", consumes="application/json")
	@ResponseStatus(HttpStatus.CREATED)
	public Pedido save(@Valid @RequestBody Pedido pedido) {
		return ps.addPedido(pedido);
	}
}
