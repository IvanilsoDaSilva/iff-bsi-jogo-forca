package br.edu.iff.jogoforca.dominio.rodada.emmemoria;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import br.edu.iff.bancodepalavras.dominio.palavra.Palavra;
import br.edu.iff.jogoforca.dominio.jogador.Jogador;
import br.edu.iff.jogoforca.dominio.rodada.Rodada;
import br.edu.iff.jogoforca.dominio.rodada.RodadaRepository;
import br.edu.iff.repository.RepositoryException;

public class MemoriaRodadaRepository implements RodadaRepository {
	private static MemoriaRodadaRepository soleInstance = null;
	private HashSet<Rodada> pool = new HashSet<Rodada>();
	
	/**
	 * Obtem uma instancia unica de MemoriaRepositoryFactory
	 * 
	 * @author IvanilsoDaSilva
	 * @return Instancia unica de MemoriaRepositoryFactory
	 */
	public static MemoriaRodadaRepository getSoleInstance() {
        if (soleInstance == null) {
        	soleInstance = new MemoriaRodadaRepository();
			return soleInstance;
        }
        return soleInstance;
	}

	private HashSet<Rodada> getPool(){
		return this.pool;
	}

	@Override
    public long getProximoId() {
        return this.getPool().size() + 1;
    }

    @Override
    public Rodada getPorId(long id) {
		if (id < 1)
			throw new IllegalArgumentException("O argumento não pode ser menor que zero");
        for (Rodada rodada : pool) {
            if (rodada.getId() == id) {
                return rodada;
            }
        }
        return null;
    }

    @Override
    public Rodada[] getPorJogador(Jogador jogador) {
		if (jogador == null)
			throw new IllegalArgumentException("O argumento não pode ser null");
		List<Rodada> rodadasEncontradas = new ArrayList<>();
        for (Rodada rodada : pool) {
            if (rodada.getJogador().getNome().equals(jogador.getNome())) {
                rodadasEncontradas.add(rodada);
            }
        }
        return rodadasEncontradas.toArray(new Rodada[0]);
    }

    @Override
    public void inserir(Rodada rodada) throws RepositoryException {
		if (rodada == null)
			throw new IllegalArgumentException("O argumento não pode ser null");
        this.getPool().add(rodada);
    }

    @Override
    public void atualizar(Rodada rodada) throws RepositoryException {
		if (rodada == null)
			throw new IllegalArgumentException("O argumento não pode ser null");
		this.getPool().remove(rodada);
		this.getPool().add(rodada);
    }

    @Override
    public void remover(Rodada rodada) throws RepositoryException {
		if (rodada == null)
			throw new IllegalArgumentException("O argumento não pode ser null");
        this.getPool().remove(rodada);
    }
}
