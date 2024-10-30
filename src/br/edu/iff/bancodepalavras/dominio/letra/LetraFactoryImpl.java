package br.edu.iff.bancodepalavras.dominio.letra;

public abstract class LetraFactoryImpl implements LetraFactory {
	protected Letra[] pool = new Letra[26];
	protected Letra encoberta;
	
	protected LetraFactoryImpl() {}
	
	protected abstract Letra criarLetra(char codigo);
	
	@Override

	public final Letra getLetra(char codigo) {
		return this.criarLetra(codigo);
//		return pool[Character.toUpperCase(codigo)-'A'];
	}
	
	@Override

	public final Letra getLetraEncoberta() {
		return this.encoberta;
	}
}
