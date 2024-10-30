package br.edu.iff.bancodepalavras.dominio.palavra;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import br.edu.iff.bancodepalavras.dominio.letra.Letra;
import br.edu.iff.bancodepalavras.dominio.letra.LetraFactory;
import br.edu.iff.bancodepalavras.dominio.tema.Tema;
import br.edu.iff.dominio.ObjetoDominioImpl;

public class Palavra extends ObjetoDominioImpl {
	private static LetraFactory letraFactory;
	private Letra LetraEncoberta = Palavra.letraFactory.getLetraEncoberta();
	private Tema tema;
	private Letra[] letras;

	private Palavra(long id, String palavra, Tema tema) {
		super(id);
		
		if (letraFactory == null) {
			throw new IllegalStateException("Atributo letraFactory indefinido");
		}
		
		this.setLetras(palavra);
		this.setTema(tema);
	}
	
	private void setTema(Tema tema) {
		if (tema == null) {
			throw new NullPointerException("O Tema não pode ser nulo.");
		}
		this.tema = tema;
	}

	public static void setLetraFactory(LetraFactory FactoryLetra) {
		letraFactory = FactoryLetra;
	}
	
	private void setLetras(String palavra) {
		letras = new Letra[palavra.length()];
		for (int i = 0; i<palavra.length();i++) {		
			letras[i] = letraFactory.getLetra(Character.toUpperCase(palavra.charAt(i)));
		}
	}

	public static LetraFactory getLetraFactory() {
		return letraFactory;
	}
	
	public Tema getTema() {
		return this.tema; 
	}
	
	public int getTamanho() {
		return this.letras.length;
	}
	
	public Letra[] getLetras() {
		return this.letras;
	}

	public Letra getLetra(int posicao) {
		return this.letras[posicao];
	}
	
	public static Palavra reconstituir(long id, String palavra, Tema tema) {
		return new Palavra(id, palavra, tema);
	}
	
	public static Palavra criar(long id, String palavra, Tema tema) {
		return new Palavra(id, palavra, tema);
	}
	
	public void exibir(Object context) {
		for (int i = 0; i < this.letras.length; i++) {
				this.letras[i].exibir(context);			
		}
		System.out.println();
	}
	
	public void exibir(boolean[] posicoes, Object context) {
		if (this.letras == null) {
			throw new RuntimeException("A palavra a ser exibida não pode ser nula.");
		}
		for (int i = 0; i < posicoes.length; i++) {
			if (posicoes[i] == true) {
				this.letras[i].exibir(context);	
			}
			else {
				LetraEncoberta.exibir(context);
			}
		}
		System.out.println();
	}
	
	public boolean comparar(String palavra) {
		if (this.letras == null) {
			throw new RuntimeException("Para comparar, a palavra deve ser inicializada.");
		}
		if (palavra == null || this.getTamanho() != palavra.length()) {
			return false;
		}
		
		//System.out.println(this.toString() + "==" + palavra);
		
		
		return this.toString().equals(palavra);
	}
	
	public int[] tentar(char codigo) {
		List<Integer> posicoes = new ArrayList<>();
		
		for (int i=0;i<letras.length;i++) {
			if (letras[i].getCodigo() == codigo){
				//System.out.println(letras[i].getCodigo() + " = " + codigo);
				posicoes.add(i);
			}
		}
		return posicoes.stream().mapToInt(Integer::intValue).toArray();
	}
	
    @Override
    public boolean equals(Object obj) {
        if (this == obj) 
        	return true;
        if (!(obj instanceof Palavra)) 
        	return false;
        
        Palavra outro = (Palavra) obj;
        return Objects.equals(this.hashCode(), outro.hashCode());
    }
	
    @Override
    public int hashCode() {
        return Objects.hash(this.toString()+":"+this.getTema().getNome());
    }
	
	@Override
	public String toString() {
		String palavra = "";
		for (Letra letra : letras) {
			palavra = palavra + letra;
		}
		return palavra;
	}
}
