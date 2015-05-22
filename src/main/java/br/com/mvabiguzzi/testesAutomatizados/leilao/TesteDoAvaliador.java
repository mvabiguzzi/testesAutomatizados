package br.com.mvabiguzzi.testesAutomatizados.leilao;

public class TesteDoAvaliador {
	
	public static void main(String[] args) {
		//Cenario 1: 3 lances nao ordenados
		Usuario joao = new Usuario("Joao");
		Usuario jose = new Usuario("Jose");
		Usuario maria = new Usuario("Maria");
		
		Leilao leilao = new Leilao("Playstation 3 novo");
		
		leilao.propoe(new Lance(joao, 300.0));
		leilao.propoe(new Lance(jose, 400.0));
		leilao.propoe(new Lance(maria, 250.0));
		
		Avaliador leiloeiro = new Avaliador();
		leiloeiro.avalia(leilao);
		
		System.out.println(leiloeiro.getMaiorDeTodos());
		System.out.println(leiloeiro.getMenorDeTodos());
		
		//Cenario 2: 3 lances em ordem crescente
		Leilao leilao1 = new Leilao("Playstation 3 novo");
		
		leilao1.propoe(new Lance(maria, 250.0));
		leilao1.propoe(new Lance(joao, 300.0));
		leilao1.propoe(new Lance(jose, 400.0));
		
		Avaliador leiloeiro1 = new Avaliador();
		leiloeiro1.avalia(leilao1);
		
		double maiorEsperado = 400.0;
		double menorEsperado = 250.0;
		
		System.out.println("Cenario 2: 3 lances em ordem crescente");
		System.out.println(maiorEsperado == leiloeiro1.getMaiorDeTodos());
		System.out.println(menorEsperado == leiloeiro1.getMenorDeTodos());
	}
	
}
