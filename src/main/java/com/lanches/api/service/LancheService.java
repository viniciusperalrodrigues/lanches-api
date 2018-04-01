package com.lanches.api.service;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.stereotype.Service;

import com.lanches.api.dto.PrecoDto;
import com.lanches.api.entity.Ingrediente;
import com.lanches.api.entity.Lanche;
import com.lanches.api.helper.CargaHelper;
import com.lanches.api.types.IngredienteType;

/**
 * Regras de Negocio Lanche
 * 
 * @author vinicius
 *
 */
@Service
public class LancheService {

	/**
	 * Retorna os Lanches já com o valor "default"
	 * @return
	 */
	public List<Lanche> getLanches() {
		List<Lanche> lanches = CargaHelper.getLanches();
		
		for(Lanche l : lanches) {
			l.setValor(getTotalIngredientes(l.getIngredientes()).getValor().setScale(2));
			
		}
		
		return lanches;
	}
	
	public PrecoDto getTotalIngredientes(List<Ingrediente> ingredientes) {

		PrecoDto dto = new PrecoDto();
		
		boolean alface = false;
		boolean bacon = false;
		BigDecimal valIngrediente = BigDecimal.ZERO;

		BigDecimal total = BigDecimal.ZERO;

		for (Ingrediente ingrediente : ingredientes) {

			if (ingrediente.getId() == IngredienteType.ALFACE.getCodigo()) {
				alface = true;
			}

			if (ingrediente.getId() == IngredienteType.BACON.getCodigo()) {
				bacon = true;
			}

			if ((ingrediente.getId() == IngredienteType.HAMBURGUER_CARNE.getCodigo()
					|| ingrediente.getId() == IngredienteType.QUEIJO.getCodigo())
					&& (ingrediente.getQuantidade() > 3)) {
				
				int totIngredientes = ingrediente.getQuantidade();
				int qtd_desconto = 0;
				
				while(totIngredientes > 3) {
					qtd_desconto ++;
					totIngredientes -= 3;
				}
				
				valIngrediente = (ingrediente.getPreco()
						.multiply(new BigDecimal((ingrediente.getQuantidade() - qtd_desconto))));
				
				if (ingrediente.getId() == IngredienteType.HAMBURGUER_CARNE.getCodigo()) {
					dto.getDescricaoPromocoes().add("Muita carne");
				}else {
					dto.getDescricaoPromocoes().add("Muito queijo");
				}
				
				
			} else {
				valIngrediente = (ingrediente.getPreco().multiply(new BigDecimal(ingrediente.getQuantidade())));
			}

			total = total.add(valIngrediente);
		}

		if (alface && !bacon) {
			total = total.subtract(total.multiply(new BigDecimal(10)).divide(new BigDecimal(100)));
			dto.getDescricaoPromocoes().add("Promoção Light");
		}
		
		dto.setValor(total);

		return dto;
	}
}
