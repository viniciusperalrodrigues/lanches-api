package com.lanches.api.dto;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class PrecoDto {

	private BigDecimal valor;

	private List<String> descricaoPromocoes = new ArrayList<>();

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	public List<String> getDescricaoPromocoes() {
		return descricaoPromocoes;
	}

	public void setDescricaoPromocoes(List<String> descricaoPromocoes) {
		this.descricaoPromocoes = descricaoPromocoes;
	}

}
