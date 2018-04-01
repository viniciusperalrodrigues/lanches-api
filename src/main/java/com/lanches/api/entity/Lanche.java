package com.lanches.api.entity;

import java.math.BigDecimal;
import java.util.List;

/**
 * Entidade Lanche
 * 
 * @author vinicius
 * 
 */

public class Lanche {

	private Integer id;

	private String nome;

	private List<Ingrediente> ingredientes;

	private BigDecimal valor;

	private List<String> promocoes;

	public List<String> getPromocoes() {
		return promocoes;
	}

	public void setPromocoes(List<String> promocoes) {
		this.promocoes = promocoes;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	/**
	 * Construtor padrão para o jackson
	 */
	public Lanche() {

	}

	public Lanche(Integer id, String nome, List<Ingrediente> ingredientes) {
		super();
		this.id = id;
		this.nome = nome;
		this.ingredientes = ingredientes;
	}

	public List<Ingrediente> getIngredientes() {
		return ingredientes;
	}

	public void setIngredientes(List<Ingrediente> ingredientes) {
		this.ingredientes = ingredientes;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
}
