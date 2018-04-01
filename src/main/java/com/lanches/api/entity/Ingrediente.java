package com.lanches.api.entity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Ingrediente implements Cloneable {

	private Integer id;

	private String nome;

	private BigDecimal preco;

	private int quantidade;
	
	public Ingrediente(Ingrediente i) {
		this.id = i.id;
		this.nome = i.nome;
		this.preco = i.preco;
		this.quantidade = 0;
	}

	public Ingrediente(Integer id, String nome, BigDecimal preco) {
		super();
		this.id = id;
		this.nome = nome;
		this.preco = preco.setScale(2);
		this.quantidade = 1;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + ((preco == null) ? 0 : preco.hashCode());
		result = prime * result + quantidade;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Ingrediente other = (Ingrediente) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (preco == null) {
			if (other.preco != null)
				return false;
		} else if (!preco.equals(other.preco))
			return false;
		if (quantidade != other.quantidade)
			return false;
		return true;
	}

	/**
	 * Construtor padrão jackson
	 */
	public Ingrediente() {
		
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
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

	public BigDecimal getPreco() {
		return preco;
	}

	public void setPreco(BigDecimal preco) {
		this.preco = preco;
	}

	public static List<Ingrediente> buildIngredientes() {
		List<Ingrediente> ingredientes = new ArrayList<>();

		Ingrediente alface = new Ingrediente(1, "Alface", BigDecimal.valueOf(0.40));
		Ingrediente bacon = new Ingrediente(2, "Bacon", BigDecimal.valueOf(2));
		Ingrediente hamburguer = new Ingrediente(3, "Hambúrguer de Carne", BigDecimal.valueOf(3));
		Ingrediente ovo = new Ingrediente(4, "Ovo", BigDecimal.valueOf(0.80));
		Ingrediente queijo = new Ingrediente(5, "Queijo", BigDecimal.valueOf(1.50));

		ingredientes.addAll(Arrays.asList(alface, bacon, hamburguer, ovo, queijo));

		return ingredientes;

	}
}
