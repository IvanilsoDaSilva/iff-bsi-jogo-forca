package br.edu.iff.bancodepalavras.dominio.palavra;

import br.edu.iff.bancodepalavras.dominio.tema.Tema;
import br.edu.iff.factory.EntityFactory;
import br.edu.iff.repository.RepositoryException;

public class PalavraFactoryImpl extends EntityFactory implements PalavraFactory {
	private static PalavraFactoryImpl soleInstance = null;
	private PalavraRepository palavraRepository;
	
	private PalavraFactoryImpl(PalavraRepository palavraRepository) {
		super(palavraRepository);
		this.setPalavraRepository(palavraRepository);
	}
	
	private void setPalavraRepository(PalavraRepository palavraRepository) {
		this.palavraRepository = palavraRepository;
	}
	
	public PalavraRepository getPalavraRepository() {
		return this.palavraRepository;
	}

	public static void createSoleInstance(PalavraRepository palavraRepository) {
		if (soleInstance != null) {
			throw new IllegalStateException("A instância já foi criada");
        }
		soleInstance = new PalavraFactoryImpl(palavraRepository);
	}
	
	public static PalavraFactoryImpl getSoleInstance() {
		if (soleInstance == null) {
            throw new IllegalStateException("A instância não foi criada. Chame createSoloInstance primeiro.");
        }
        return soleInstance;
	}

	@Override
	public Palavra getPalavra(String palavra, Tema tema) {
		try {
			palavraRepository.inserir(Palavra.criar(this.getPalavraRepository().getProximoId(), palavra, tema));
		} catch (RepositoryException e) {
			e.printStackTrace();
		}
		return palavraRepository.getPalavra(palavra);
	}
}
