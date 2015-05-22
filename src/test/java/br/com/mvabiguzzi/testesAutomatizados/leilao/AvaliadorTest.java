package br.com.mvabiguzzi.testesAutomatizados.leilao;

import static org.junit.Assert.assertEquals;

import java.util.List;

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
		
		assertEquals(maiorEsperado, leiloeiro.getMaiorDeTodos(), 0.0001);
		assertEquals(menorEsperado, leiloeiro.getMenorDeTodos(), 0.0001);
	}
	
	@Test
	public void deveEntenderLeilaoComApenasUmLance() {
		Usuario joao = new Usuario("Joao");
		
		Leilao leilao = new Leilao("Playstation 3 Novo");
		
		leilao.propoe(new Lance(joao,1000.0));
		
		Avaliador leiloeiro = new Avaliador();
		leiloeiro.avalia(leilao);
		
		assertEquals(1000, leiloeiro.getMaiorDeTodos(), 0.0001);
		assertEquals(1000, leiloeiro.getMenorDeTodos(), 0.0001);
	}
	
	@Test
	public void deveEncontrarOsTresMaiores() {
		Usuario joao = new Usuario("joao");
		Usuario maria = new Usuario("maria");
		
		Leilao leilao = new Leilao("Playstation 3 Novo");
		
		leilao.propoe(new Lance(joao, 100.0));
		leilao.propoe(new Lance(maria, 200.0));
		leilao.propoe(new Lance(joao, 300.0));
		leilao.propoe(new Lance(maria, 400.0));
		
		Avaliador leiloeiro = new Avaliador();
		leiloeiro.avalia(leilao);
		
		List<Lance> maiores = leiloeiro.getTresMaiores();
		
		assertEquals(3, maiores.size());
		
		assertEquals(400.0, maiores.get(0).getValor(), 0.0001);
		assertEquals(300.0, maiores.get(1).getValor(), 0.0001);
		assertEquals(200.0, maiores.get(2).getValor(), 0.0001);
	}
	
}
