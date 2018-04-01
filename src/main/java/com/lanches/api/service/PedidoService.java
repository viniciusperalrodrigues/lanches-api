package com.lanches.api.service;

import java.math.BigDecimal;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lanches.api.dto.PrecoDto;
import com.lanches.api.entity.Lanche;
import com.lanches.api.entity.Pedido;

/**
 * Regras de Negócio Pedido
 * @author vinicius
 *
 */
@Service
public class PedidoService {

	@Autowired
	private LancheService ls;

	public Pedido addPedido(@Valid Pedido pedido) {
		
		BigDecimal totPedido = BigDecimal.ZERO;
		
		for(Lanche lanche : pedido.getLanches()) {
			PrecoDto prec = ls.getTotalIngredientes(lanche.getIngredientes());
			totPedido = totPedido.add(prec.getValor());
			lanche.setPromocoes(prec.getDescricaoPromocoes());
		}
		
		pedido.setTotal(totPedido);
		
		
		return pedido;
	}
	
	
}
