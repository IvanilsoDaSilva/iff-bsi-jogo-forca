package br.edu.iff.jogoforca.dominio.rodada.embdr;

import br.edu.iff.jogoforca.dominio.jogador.Jogador;
import br.edu.iff.jogoforca.dominio.rodada.Rodada;
import br.edu.iff.jogoforca.dominio.rodada.RodadaRepository;
import br.edu.iff.repository.RepositoryException;

public class BDRRodadaRepository implements RodadaRepository {

	private static BDRRodadaRepository soleInstance;
	
	public static BDRRodadaRepository getSoleInstance() {
		if(soleInstance==null) {
			soleInstance = new BDRRodadaRepository();
		}
		return soleInstance;
	}
	
	private BDRRodadaRepository() {
		
	}

	@Override
	public long getProximoId() {
		return 0;
	}

	@Override
	public Rodada getPorId(long id) {
		return null;
	}

	@Override
	public Rodada[] getPorJogador(Jogador jogador) {
		return null;
	}

	@Override
	public void inserir(Rodada rodada) throws RepositoryException {
		
	}

	@Override
	public void atualizar(Rodada rodada) throws RepositoryException {
		
	}

	@Override
	public void remover(Rodada rodada) throws RepositoryException {
		
	}
	
}