package br.edu.iff.bancodepalavras.dominio.tema;

import java.util.Objects;

import br.edu.iff.bancodepalavras.dominio.letra.Letra;
import br.edu.iff.dominio.ObjetoDominioImpl;

public class Tema extends ObjetoDominioImpl {
	private String nome;
	
	private Tema(long id, String nome) {
		super(id);
		this.nome = nome;
	}
	
	public static Tema reconstituir(long id, String nome) {
		return new Tema(id, nome);
	}
	
	public static Tema criar(long id, String nome) {
		return new Tema(id, nome);
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
    @Override
    public boolean equals(Object obj) {
        if (this == obj) 
        	return true;
        if (!(obj instanceof Tema)) 
        	return false;
        
        Tema outro = (Tema) obj;
        return Objects.equals(this.hashCode(), outro.hashCode());
    }
	
    @Override
    public int hashCode() {
        return Objects.hash(this.toString());
    }
    
	@Override
	public String toString() {
		return this.getNome();
	}
}
