package br.com.mvabiguzzi.testesAutomatizados.leilao;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

public class Lance {
	
	private Usuario usuario;
	private double valor;
	
	public Lance(Usuario usuario, double valor) {
		this.usuario = usuario;
		this.valor = valor;
	}
	
	@Override
	public int hashCode() {
		return new HashCodeBuilder(17, 31). // dois numeros primos aleatórios
	            //appendSuper(super.hashCode()). // Para manter o comportamento de hashCode() da classe pai
				append(usuario).
				append(valor).
				toHashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) return true;
		if (obj == null) return false;
		if (getClass() != obj.getClass()) return false;
		
		Lance other = (Lance) obj;
		return new EqualsBuilder().
				//appendSuper(super.equals(obj)). // Para manter o comportamento de equals() da classe pai
				append(usuario, other.getUsuario()).
				append(valor, other.getValor()).
				isEquals();
	}
	
	public Usuario getUsuario() {
		return usuario;
	}
	
	public double getValor() {
		return valor;
	}
	
}
