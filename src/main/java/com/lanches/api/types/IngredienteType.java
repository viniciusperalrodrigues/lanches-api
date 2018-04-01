package com.lanches.api.types;

public enum IngredienteType {

	ALFACE(1), BACON(2), HAMBURGUER_CARNE(3), OVO(4), QUEIJO(5);

	IngredienteType(int codigo) {
		this.codigo = codigo;
	}

	public int getCodigo() {
		return codigo;
	}

	private int codigo;

}
