package br.edu.iff.bancodepalavras.dominio.letra;

public interface LetraFactory {
	
	 public abstract Letra getLetra(char codigo);
	 
	 public abstract Letra getLetraEncoberta();
}
