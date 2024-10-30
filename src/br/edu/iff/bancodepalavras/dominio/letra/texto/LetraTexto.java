package br.edu.iff.bancodepalavras.dominio.letra.texto;

import br.edu.iff.bancodepalavras.dominio.letra.Letra;

public class LetraTexto extends Letra {
	/**
	 * Construtor da classe LetraTexto
	 * 
	 * @param codigo Codigo ASCII da letra 
	 */
	public LetraTexto(char codigo) {
		super(codigo);
	}

	@Override
	public void exibir(Object contexto) {
		System.out.print(this.getCodigo());
	}
}
