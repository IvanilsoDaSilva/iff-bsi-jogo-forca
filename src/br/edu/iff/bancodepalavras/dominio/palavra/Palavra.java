package br.edu.iff.bancodepalavras.dominio.palavra;

import br.edu.iff.bancodepalavras.dominio.letra.Letra;
import br.edu.iff.bancodepalavras.dominio.letra.LetraFactory;
import br.edu.iff.bancodepalavras.dominio.tema.Tema;

public class Palavra {
	private long id;
	private Tema tema;
	private LetraFactory letraFactory;
	private Letra[] letras;
	private boolean[] posicoes;
	private Object context;
	
	private Palavra(long id, String palavra, Tema tema) {
		this.id = id;
		this.tema = tema; 
		
		letras =  new Letra[palavra.length()];
		for (char string : palavra.toCharArray()) {
			
		}
	}
	
	public Palavra criar(long id, String palavra, Tema tema) {
		return new Palavra(id, palavra, tema);
	}

	public LetraFactory getLetraFactory() {
		return letraFactory;
	}

	public void setLetraFactory(LetraFactory letraFactory) {
		this.letraFactory = letraFactory;
	}
	
	public Tema getTema() {
		return this.tema; 
	}
	
	public int getTamanho() {
		return palavra.length();
	}
	
	public Letra[] getLetras() {
		return null;
	}
	
	public boolean comparar(String palavra) {
		return this.palavra == palavra;
	}
}
