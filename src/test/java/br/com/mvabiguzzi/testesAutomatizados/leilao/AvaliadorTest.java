package br.com.mvabiguzzi.testesAutomatizados.leilao;

import org.junit.Assert;

import org.junit.Test;

public class AvaliadorTest {
	
	@Test
	public void deveEntenderLancesEmOrdemCrescente() {
		Usuario joao = new Usuario("Joao");
		Usuario jose = new Usuario("Jose");
		Usuario maria = new Usuario("Maria");
		
		//Cenario: 3 lances em ordem crescente
		Leilao leilao = new Leilao("Playstation 3 novo");
		
		leilao.propoe(new Lance(maria, 250.0));
		leilao.propoe(new Lance(joao, 300.0));
		leilao.propoe(new Lance(jose, 400.0));
		
		Avaliador leiloeiro = new Avaliador();
		leiloeiro.avalia(leilao);
		
		double maiorEsperado = 400.0;
		double menorEsperado = 250.0;
		
		Assert.assertEquals(maiorEsperado, leiloeiro.getMaiorDeTodos(), 0.0001);
		Assert.assertEquals(menorEsperado, leiloeiro.getMenorDeTodos(), 0.0001);
	}
	
}
