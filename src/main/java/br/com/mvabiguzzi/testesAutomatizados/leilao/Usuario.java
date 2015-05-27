package br.com.mvabiguzzi.testesAutomatizados.leilao;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

public class Usuario {
	
	private String nome;
	
	@Override
	public int hashCode() {
		return new HashCodeBuilder(17, 31). // dois numeros primos aleatórios
				//appendSuper(super.hashCode()). // Para manter o comportamento de hashCode() da classe pai
				append(nome).
				toHashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) return true;
		if (obj == null) return false;
		if (getClass() != obj.getClass()) return false;
		
		Usuario other = (Usuario) obj;
		return new EqualsBuilder().
				//appendSuper(super.equals(obj)). // Para manter o comportamento de equals() da classe pai
				append(nome, other.getNome()).
				isEquals();
	}
	
	public Usuario(String nome) {
		this.nome = nome;
	}

	public String getNome() {
		return nome;
	}
	
}
