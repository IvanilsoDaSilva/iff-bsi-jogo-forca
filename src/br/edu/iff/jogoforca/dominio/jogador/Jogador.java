package br.edu.iff.jogoforca.dominio.jogador;

import java.util.Objects;

import br.edu.iff.bancodepalavras.dominio.letra.Letra;
import br.edu.iff.dominio.ObjetoDominioImpl;

public class Jogador extends ObjetoDominioImpl {
	private String nome;
	private int pontuacao = 0;

    private Jogador(long id, String nome) {
        super(id);
        this.setNome(nome);
    }

    private Jogador(long id, String nome, int pontuacao) {
        super(id);
        this.setNome(nome);
        this.setPontuacao(pontuacao);
    }

	public static Jogador reconstituir(long id, String nome, int pontuacao) {
		return new Jogador(id, nome, pontuacao);
	}

    public static Jogador criar(long id, String nome) {
		return new Jogador(id, nome);
	}

	public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getPontuacao() {
        return pontuacao;
    }

    public void setPontuacao(int pontuacao) {
        this.pontuacao = pontuacao;
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
		return this.nome;
	}
	
	@Override
	/**
	 * Verifica se os objetos são iguais
	 * 
	 * @author IvanilsoDaSilva
	 * @param o Objeto a ser comparado
	 * @return Se são iguais
	 */
	public boolean equals(Object obj) {
		if (this == obj) 
        	return true;
        if (!(obj instanceof Jogador)) 
        	return false;
        
        Jogador outro = (Jogador) obj;
        return Objects.equals(this.hashCode(), outro.hashCode());
	}
}
