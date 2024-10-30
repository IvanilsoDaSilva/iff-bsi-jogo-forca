package br.edu.iff.bancodepalavras.dominio.letra;

import java.util.Objects;

public abstract class Letra {
	private char codigo;
	
	/**
	 * Construtor da classe Letra
	 * 
	 * @author IvanilsoDaSilva
	 * @param codigo Codigo ASCII da letra 
	 */
	protected Letra(char codigo) {
		this.setCodigo(codigo); 
	}
	
	private void setCodigo(char codigo) {
		this.codigo = codigo; 
	}
	
	/**
	 * Obtem o codigo ASCII da letra
	 * 
	 * @author IvanilsoDaSilva
	 * @return Codigo da letra
	 */
	public char getCodigo() {
		return this.codigo;
	}
	
	/**
	 * Exibe o caracter na tela
	 * 
	 * @author IvanilsoDaSilva
	 * @param contexto Contexto da exibicao
	 */
	public void exibir(Object contexto) {
		System.out.println(this.getCodigo()); 		
		
	}
	
	@Override
	/**
	 * Obtem o hashcode do objeto
	 * 
	 * @author IvanilsoDaSilva
	 * @return Hashcode do objeto
	 */
	public int hashCode() {
		return Objects.hash(this.toString());
	}
	
	@Override
	/**
	 * Retorna o objeto como String
	 * 
	 * @author IvanilsoDaSilva
	 * @return Objeto como String
	 */
	public final String toString() {
		return Character.toString(codigo);
	}
	
    @Override
    public boolean equals(Object obj) {
        if (this == obj) 
        	return true;
        if (!(obj instanceof Letra)) 
        	return false;
        
        Letra outro = (Letra) obj;
        return Objects.equals(this.hashCode(), outro.hashCode());
    }
}