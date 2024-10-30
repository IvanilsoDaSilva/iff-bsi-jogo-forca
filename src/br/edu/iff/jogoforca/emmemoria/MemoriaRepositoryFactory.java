package br.edu.iff.jogoforca.emmemoria;

import br.edu.iff.bancodepalavras.dominio.palavra.PalavraRepository;
import br.edu.iff.bancodepalavras.dominio.palavra.emmemoria.MemoriaPalavraRepository;
import br.edu.iff.bancodepalavras.dominio.tema.TemaRepository;
import br.edu.iff.bancodepalavras.dominio.tema.emmemoria.MemoriaTemaRepository;
import br.edu.iff.jogoforca.RepositoryFactory;
import br.edu.iff.jogoforca.dominio.jogador.JogadorRepository;
import br.edu.iff.jogoforca.dominio.jogador.emmemoria.MemoriaJogadorRepository;
import br.edu.iff.jogoforca.dominio.rodada.RodadaRepository;
import br.edu.iff.jogoforca.dominio.rodada.emmemoria.MemoriaRodadaRepository;

public class MemoriaRepositoryFactory implements RepositoryFactory {
	private static MemoriaRepositoryFactory soleInstance = null;
	
	MemoriaTemaRepository memoriaTemaRepository = MemoriaTemaRepository.getSoleInstance();
	
	private MemoriaRepositoryFactory() {}
	
	/**
	 * Obtem uma instancia unica de MemoriaRepositoryFactory
	 * 
	 * @author IvanilsoDaSilva
	 * @return Instancia unica de MemoriaRepositoryFactory
	 */
	public static MemoriaRepositoryFactory getSoleInstance() {
        if (soleInstance == null) {
        	soleInstance = new MemoriaRepositoryFactory();
			return soleInstance;
        }
        return soleInstance;
	}

	@Override
	public PalavraRepository getPalavraRepository() {
		// TODO Auto-generated method stub
		return MemoriaPalavraRepository.getSoleInstance();
	}

	@Override
	public TemaRepository getTemaRepository() {
		// TODO Auto-generated method stub
		return MemoriaTemaRepository.getSoleInstance();
	}

	@Override
	public RodadaRepository getRodadaRepository() {
		// TODO Auto-generated method stub
		return MemoriaRodadaRepository.getSoleInstance();
	}

	@Override
	public JogadorRepository getJogadorRepository() {
		// TODO Auto-generated method stub
		return MemoriaJogadorRepository.getSoleInstance();
	}
	
}
