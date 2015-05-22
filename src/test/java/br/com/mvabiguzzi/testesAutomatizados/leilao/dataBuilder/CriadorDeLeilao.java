package br.com.mvabiguzzi.testesAutomatizados.leilao.dataBuilder;

import br.com.mvabiguzzi.testesAutomatizados.leilao.Lance;
import br.com.mvabiguzzi.testesAutomatizados.leilao.Leilao;
import br.com.mvabiguzzi.testesAutomatizados.leilao.Usuario;

public class CriadorDeLeilao {
	
	private Leilao leilao;
	
	public CriadorDeLeilao() { }
	
	public CriadorDeLeilao para(String descricaco) {
		this.leilao = new Leilao(descricaco);
		
		return this;
	}
	
	public CriadorDeLeilao lance(Usuario usuario, double valor) {
		this.leilao.propoe(new Lance(usuario, valor));
		
		return this;
	}
	
	public Leilao constroi() {
		return this.leilao;
	}
	
}
