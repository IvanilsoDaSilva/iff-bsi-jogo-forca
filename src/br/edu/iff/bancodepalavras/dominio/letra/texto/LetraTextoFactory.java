package br.edu.iff.bancodepalavras.dominio.letra.texto;

import br.edu.iff.bancodepalavras.dominio.letra.Letra;
import br.edu.iff.bancodepalavras.dominio.letra.LetraFactoryImpl;

public class LetraTextoFactory extends LetraFactoryImpl {
	private static LetraTextoFactory soleInstance;
	
	/**
	 * O construtor e privado para apenas a proprica classe criar uma instancia unica de si (Singleton)
	 * 
	 * @author IvanilsoDaSilva
	 */
	private LetraTextoFactory() {
		super();
		this.encoberta = new LetraTexto('*');
	}
	

	/**
	 * Obtem uma instancia unica de LetraTextoFactory
	 * 
	 * @author IvanilsoDaSilva
	 * @return Instancia unica de LetraTextoFactory
	 */
	public static LetraTextoFactory getSoleInstance() {
        if (soleInstance == null) {
        	soleInstance = new LetraTextoFactory();
			return soleInstance;
        }
        return soleInstance;
	}
	
	@Override
	public Letra criarLetra(char codigo) { //Rezo para que esteja certo, Verifique
        int index = Character.toUpperCase(codigo) - 'A'; // Índice correspondente no array

        // Verifica se o código está dentro do intervalo A-Z
        if (index < 0 || index >= pool.length) {
            throw new IllegalArgumentException("Código inválido. Apenas letras de A a Z são suportadas.");
        }

        // Se a letra já estiver no pool, retorna a instância existente
        if (pool[index] != null) {
            return pool[index];
        }

        // Cria uma nova letra, armazena no pool e retorna a instância
        Letra novaLetra = new LetraTexto(codigo);
        pool[index] = novaLetra;
        return novaLetra;
	}
}
