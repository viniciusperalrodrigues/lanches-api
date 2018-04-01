package com.lanches.api.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.lanches.api.entity.Ingrediente;
import com.lanches.api.helper.CargaHelper;

/**
 * Regras de Negocio Ingrediente
 * @author vinicius
 *
 */
@Service
public class IngredienteService {
	
	public List<Ingrediente> findAll(){
		return CargaHelper.getIngredientesLancheCustom();
	}
}
