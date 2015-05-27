package br.com.mvabiguzzi.testesAutomatizados.leilao;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Avaliador {
	
	private double maiorDeTodos = Double.NEGATIVE_INFINITY;
	private double menorDeTodos = Double.POSITIVE_INFINITY;
	private List<Lance> maiores;
	
	private void pegaOsMaioresNo(Leilao leilao) {
		maiores = new ArrayList<Lance>(leilao.getLances());
		
		Collections.sort(maiores, new Comparator<Lance>() {
			public int compare(Lance l1, Lance l2) {
				if(l1.getValor() < l2.getValor()) return 1;
				if(l1.getValor() > l2.getValor()) return -1;
				return 0;
			}
		});
		
		maiores = maiores.subList(0, maiores.size() > 3 ? 3 : maiores.size());
	}
	
	public void avalia(Leilao leilao) {
		if(leilao.getLances().size() == 0) {
			throw new RuntimeException("Não é possível avaliar um leilão sem lances");
		}
		
		for(Lance lance : leilao.getLances()) {
			if(lance.getValor() > maiorDeTodos) {
				maiorDeTodos = lance.getValor();
			} 
			
			if(lance.getValor() < menorDeTodos) {
				menorDeTodos = lance.getValor();
			}
		}
		
		pegaOsMaioresNo(leilao);
	}

	public double getMaiorDeTodos() {
		return maiorDeTodos;
	}

	public double getMenorDeTodos() {
		return menorDeTodos;
	}
	
	public List<Lance> getTresMaiores() {
		return this.maiores;
	}
	
}
