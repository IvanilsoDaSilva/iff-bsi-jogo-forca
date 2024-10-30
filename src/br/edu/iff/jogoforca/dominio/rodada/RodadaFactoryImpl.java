package br.edu.iff.jogoforca.dominio.rodada;

import br.edu.iff.bancodepalavras.dominio.palavra.PalavraRepository;
import br.edu.iff.bancodepalavras.dominio.tema.TemaRepository;
import br.edu.iff.factory.EntityFactory;

public abstract class RodadaFactoryImpl extends EntityFactory implements RodadaFactory {
	private RodadaRepository rodadaRepository;
	private TemaRepository temaRepository;
	private PalavraRepository palavraRepository;
	
	protected RodadaFactoryImpl(RodadaRepository rodadaRepository, TemaRepository temaRepository, PalavraRepository palavraRepository) {
		super(rodadaRepository);
		this.setRodadaRepository(rodadaRepository);
		this.setTemaRepository(temaRepository);
		this.setPalavraRepository(palavraRepository);
	}

	private void setRodadaRepository(RodadaRepository rodadaRepository) {
		if (rodadaRepository == null) 
				throw new IllegalArgumentException("O argumento não pode ser nulo");
		this.rodadaRepository = rodadaRepository;
	}

	private void setTemaRepository(TemaRepository temaRepository) {
		if (temaRepository == null) 
			throw new IllegalArgumentException("O argumento não pode ser nulo");
		this.temaRepository = temaRepository;
	}

	private void setPalavraRepository(PalavraRepository palavraRepository) {
		if (palavraRepository == null) 
			throw new IllegalArgumentException("O argumento não pode ser nulo");
		this.palavraRepository = palavraRepository;
	}

	protected RodadaRepository getRodadaRepository() {
		return rodadaRepository;
	}

	protected TemaRepository getTemaRepository() {
		return temaRepository;
	}

	protected PalavraRepository getPalavraRepository() {
		return palavraRepository;
	}
}
