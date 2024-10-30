package br.edu.iff.jogoforca.dominio.jogador;

public abstract interface JogadorFactory {
	public Jogador getJogador(String nome);
}
