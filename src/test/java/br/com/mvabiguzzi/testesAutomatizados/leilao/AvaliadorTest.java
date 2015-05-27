package br.com.mvabiguzzi.testesAutomatizados.leilao;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import br.com.mvabiguzzi.testesAutomatizados.leilao.dataBuilder.CriadorDeLeilao;

public class AvaliadorTest {
	
	private Avaliador leiloeiro;
	private Usuario joao;
	private Usuario jose;
	private Usuario maria;
	
	@Before
	public void setup() {
		this.leiloeiro = new Avaliador();
		this.joao = new Usuario("Joao");
		this.jose = new Usuario("Jose");
		this.maria = new Usuario("Maria");
	}
	
	@Test
	public void deveEntenderLancesEmOrdemCrescente() {
		Leilao leilao = new CriadorDeLeilao()
				.para("Playstation 3 Novo")
				.lance(maria, 250.0)
				.lance(joao, 300)
				.lance(jose, 400.0)
				.constroi();
		
		leiloeiro.avalia(leilao);
		
		double maiorEsperado = 400.0;
		double menorEsperado = 250.0;
		
		assertThat(leiloeiro.getMaiorDeTodos(), equalTo(maiorEsperado));
		assertThat(leiloeiro.getMenorDeTodos(), equalTo(menorEsperado));
	}
	
	@Test
	public void deveEntenderLeilaoComApenasUmLance() {
		Leilao leilao = new CriadorDeLeilao()
				.para("Playstation 3 Novo")
				.lance(joao, 1000.0)
				.constroi();
		
		leiloeiro.avalia(leilao);
		
		assertThat(leiloeiro.getMaiorDeTodos(), equalTo(1000.0));
		assertThat(leiloeiro.getMenorDeTodos(), equalTo(1000.0));
	}
	
	@Test
	public void deveEncontrarOsTresMaiores() {
		Leilao leilao = new CriadorDeLeilao()
				.para("Playstation 3 Novo")
				.lance(joao, 100.0)
				.lance(maria, 200.0)
				.lance(joao, 300.0)
				.lance(maria, 400.0)
				.constroi();
		
		leiloeiro.avalia(leilao);
		
		List<Lance> maiores = leiloeiro.getTresMaiores();
		
		assertThat(maiores, hasItems(
					new Lance(maria, 200.0),
					new Lance(joao, 300.0),
					new Lance(maria, 400.0)
				));
	}
	
	@Test(expected=RuntimeException.class)
	public void naoDeveAvaliarLeilaoSemLances() {
		Leilao leilao = new CriadorDeLeilao().para("Playstation 3 novo").constroi();
		
		leiloeiro.avalia(leilao);
	}
	
}
