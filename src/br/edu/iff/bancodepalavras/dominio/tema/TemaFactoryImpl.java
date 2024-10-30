package br.edu.iff.bancodepalavras.dominio.tema;

import br.edu.iff.factory.EntityFactory;
import br.edu.iff.repository.Repository;

public class TemaFactoryImpl extends EntityFactory implements TemaFactory {
	private static TemaFactoryImpl soleInstance = null;
	private TemaRepository temaRepository;

	protected TemaFactoryImpl(TemaRepository temaRepository) {
		super(temaRepository);
		this.temaRepository = temaRepository;
	}
	
	public static void createSoleInstance(TemaRepository temaRepository) {
		if (soleInstance == null) {
			soleInstance = new TemaFactoryImpl(temaRepository);
        }
	}

	public static TemaFactoryImpl getSoleInstance() {
		if (soleInstance == null) {
            throw new IllegalStateException("A instância não foi criada. Chame createSoloInstance primeiro.");
        }
        return soleInstance;
	}
	
	public TemaRepository getTemaRepository() {
		return this.temaRepository;
	}
	
	@Override
	public Tema getTema(String nome) {
		return Tema.criar(this.getTemaRepository().getProximoId(), nome);
	}
}
