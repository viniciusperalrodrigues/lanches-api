package com.lanches.api.helper;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.lanches.api.entity.Ingrediente;
import com.lanches.api.entity.Lanche;

/**
 * Classe para carregar as informacoes
 * @author vinicius
 *
 */
public class CargaHelper {
	private static Ingrediente alface = new Ingrediente(1, "Alface", BigDecimal.valueOf(0.40));
	private static Ingrediente bacon = new Ingrediente(2, "Bacon", BigDecimal.valueOf(2));
	private static Ingrediente hamburguer = new Ingrediente(3, "Hambúrguer de Carne", BigDecimal.valueOf(3));
	private static Ingrediente ovo = new Ingrediente(4, "Ovo", BigDecimal.valueOf(0.80));
	private static Ingrediente queijo = new Ingrediente(5, "Queijo", BigDecimal.valueOf(1.50));
	
	private static	Lanche xBacon = new Lanche(1, "X-Bacon", Arrays.asList(bacon,hamburguer,queijo));
	private static	Lanche xBurger = new Lanche(2, "X-Burger", Arrays.asList(hamburguer,queijo));
	private static Lanche xEgg = new Lanche(3, "X-Egg", Arrays.asList(ovo,hamburguer,queijo));
	private static Lanche xEggBacon = new Lanche(4, "X-Egg Bacon", Arrays.asList(ovo,bacon,hamburguer,queijo));

	
	private static List<Lanche> lanches = Arrays.asList(xBacon, xBurger, xEgg, xEggBacon);
	private static List<Ingrediente> ingredientes = Arrays.asList(alface, bacon, hamburguer, ovo, queijo);
	
	public static List<Lanche> getLanches() {
		return lanches;
	}
	public static List<Ingrediente> getIngredientes() {
		return ingredientes;
	}
	public static List<Ingrediente> getIngredientesLancheCustom() {
		
		List<Ingrediente> lc = new ArrayList<Ingrediente>(ingredientes.size());
		
		for (Ingrediente item : ingredientes) {
			lc.add(new Ingrediente(item));
		}
	    return lc;
		
		
	}
}
