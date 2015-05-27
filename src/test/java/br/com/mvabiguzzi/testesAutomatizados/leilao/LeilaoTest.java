package br.com.mvabiguzzi.testesAutomatizados.leilao;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

import org.junit.Test;

import br.com.mvabiguzzi.testesAutomatizados.leilao.dataBuilder.CriadorDeLeilao;

public class LeilaoTest {
	
	@Test
	public void deveReceberUmLance() {
		Leilao leilao = new Leilao("Macbook PRO 15");
		assertThat(leilao.getLances().size(), equalTo(0));
		
		leilao.propoe(new Lance(new Usuario("Steve Jobs"), 2000));
		
		assertThat(leilao.getLances(), hasItem(new Lance(new Usuario("Steve Jobs"), 2000)));
	}
	
	@Test
	public void deveReceberVariosLances() {
		Leilao leilao = new CriadorDeLeilao().
				para("Macbook PRO 15").
				lance(new Usuario("Steve Jobs"), 2000).
				lance(new Usuario("Steve Wozniak"), 3000).
				constroi();
		
		assertThat(leilao.getLances(), hasItems(
					new Lance(new Usuario("Steve Jobs"), 2000),
					new Lance(new Usuario("Steve Wozniak"), 3000)
				));
		
	}
	
}
