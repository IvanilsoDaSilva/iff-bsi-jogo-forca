package br.edu.iff.bancodepalavras.dominio.letra;

public abstract class LetraFactoryImpl implements LetraFactory {
	protected Letra[] pool = new Letra[26];
	protected Letra encoberta;
	
	protected LetraFactoryImpl() {}
	
	@Override
	/**
	 * Obtem uma letra
	 * 
	 * @author IvanilsoDaSilva
	 * @param codigo Codigo da letra a ser buscado
	 * @return Letra buscada
	 */
	public final Letra getLetra(char codigo) {
		return pool[Character.toUpperCase(codigo)-'A'];
	}
	
	@Override
	/**
	 * Obtem a letra encoberta
	 * 
	 * @author IvanilsoDaSilva
	 * @return Letra encoberta
	 */
	public final Letra getLetraEncoberta() {
		return encoberta;
	}
	
	/**
	 * Cria uma letra
	 * 
	 * É um metodo abstrado para ser implementado pelas classes que herdam (Factory)
	 * 
	 * @author IvanilsoDaSilva
	 * @param codigo Codigo da letra a ser criado
	 * @return Letra criada
	 */
	protected abstract Letra criarLetra(char codigo);
}
