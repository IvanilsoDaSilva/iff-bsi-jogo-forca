package br.edu.iff.jogoforca.dominio.rodada;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import br.edu.iff.bancodepalavras.dominio.letra.Letra;
import br.edu.iff.bancodepalavras.dominio.palavra.Palavra;
import br.edu.iff.bancodepalavras.dominio.tema.Tema;
import br.edu.iff.dominio.ObjetoDominioImpl;

public class Item extends ObjetoDominioImpl {
	private boolean[] posicoesDescobertas;
	private String palavraArriscada = null;
	private Palavra palavra;
	
	private Item(long id, Palavra palavra) {
		
		super(id);
		//System.out.println("Construtor Basico Item Chamado");
		this.setPalavra(palavra);
		this.posicoesDescobertas = new boolean[palavra.getTamanho()];
		for (int g = 0; g <palavra.getTamanho(); g++) {
			this.posicoesDescobertas[g] = false;
		}
		
	}
	
	private Item(long id, Palavra palavra, int[] posicoesDescobertas, String palavraArriscada) {
		super(id);
		//System.out.println("Construtor Avançado Item Chamado");
		this.setPalavra(palavra);
		this.setPosicoesDescobertas(posicoesDescobertas); 
		this.setPalavraArriscada(palavraArriscada);
	}
	
	private void setPalavra(Palavra palavra) {
		if(palavra == null) {
			throw new NullPointerException("A palavra não pode ser nula");
		}
		this.palavra = palavra;
	}
	
	private void setPosicoesDescobertas(int[] posicoesDescobertasInt) {
		
		System.out.println("setPosicoesDescobertas");
		if(posicoesDescobertasInt == null) {
			throw new NullPointerException("O vetor com as posições descobertas é nulo");
		}
		for(int i = 0; i <= posicoesDescobertasInt.length-1 ; i++) {
			this.posicoesDescobertas[posicoesDescobertasInt[i]] = true;
		}
	}
		
	private void setPalavraArriscada(String palavraArriscada) {
		if(palavraArriscada == null) {
			throw new NullPointerException("A palavra arriscada não pode ser nula");
		}
		this.palavraArriscada = palavraArriscada;
	}
	
	public boolean[] getPosicoesDescobertas() {
		return posicoesDescobertas;
	}
	
	public String getPalavraArriscada() {
		return palavraArriscada;
	}
	
	public Letra[] getLetrasEncobertas() {
		List<Letra> letrasEncobertas = new ArrayList<Letra>();
		for (int i = 0; i < palavra.getTamanho(); i++) {
			if (posicoesDescobertas[i] == false) {
				letrasEncobertas.add(this.palavra.getLetra(i));
			}
		}
		return letrasEncobertas.toArray(new Letra[letrasEncobertas.size()]);
	}

	public Letra[] getLetrasDescobertas() {
		List<Letra> letrasDescobertas = new ArrayList<Letra>();
		for (int i = 0; i < palavra.getTamanho(); i++) {
			if (posicoesDescobertas[i] == true) {
				letrasDescobertas.add(this.palavra.getLetra(i));
			}
		}
		return letrasDescobertas.toArray(new Letra[letrasDescobertas.size()]);
	}

	public int qtdeLetrasEncobertas() {
		int aux = 0;
		for (int i = 0; i < this.palavra.getTamanho(); i++) {
			if (posicoesDescobertas[i] == false) {
				aux++;
			}
		}
		return aux;
	}

	public int calcularPontosLetrasEncobertas(int valorPorLetraEncoberta) {
		int valor = 0;
		for (int i = 0; i < this.palavra.getTamanho(); i++) {
			if (posicoesDescobertas[i] == false) {
				valor += valorPorLetraEncoberta;
			}
		}
		return valor;
	}

	public boolean descobriu() {
		if (this.acertou() == true || (this.qtdeLetrasEncobertas() == 0)) {
			return true;
		}
		return false;
	}

	public void exibir(Object context) {
		this.palavra.exibir(posicoesDescobertas, context);;
	}

	boolean tentar(char codigo) {
		int[] posicoes = palavra.tentar(codigo);
        for (int i = 0; i < posicoes.length; i++ ) {
            this.posicoesDescobertas[posicoes[i]] = true;
        }
        if(posicoes.length > 0) {
            return true;
        }
        return false;
	}
	
	public Palavra getPalavra() {
		return palavra;
	}
	
	void arriscar(String palavra) {
		this.setPalavraArriscada(palavra);
	}
	
	public boolean arriscou() {
		return palavraArriscada != null;
	}
	
	public boolean acertou() {
		//System.out.println(this.palavra.toString() +" == "+ palavraArriscada );
		return this.palavra.comparar(palavraArriscada);
	}

	public static Item reconstituir(long id, Palavra palavra, int[] posicoesDescobertas, String palavraArriscada) {
		return new Item(id, palavra, posicoesDescobertas, palavraArriscada);
	}

	static Item criar(long id, Palavra palavra) {
		return new Item(id, palavra);
	}
	
}
