package br.edu.iff.jogoforca.dominio.jogador.emmemoria;

import java.util.HashSet;

import br.edu.iff.jogoforca.dominio.jogador.Jogador;
import br.edu.iff.jogoforca.dominio.jogador.JogadorRepository;
import br.edu.iff.repository.RepositoryException;

public class MemoriaJogadorRepository implements JogadorRepository {
	private static MemoriaJogadorRepository soleInstance;
	private HashSet<Jogador> pool = new HashSet<Jogador>();
	
	public static MemoriaJogadorRepository getSoleInstance() {
		if(soleInstance==null) {
			soleInstance = new MemoriaJogadorRepository();
		}
		return soleInstance;
	}
	
	private MemoriaJogadorRepository() {
		pool = new HashSet<Jogador>();
	}

	@Override
	public long getProximoId() {
		//System.out.println("GetProximoID");
		return this.pool.size() + 1;
	}

	@Override
	public Jogador getPorId(long id) {
		for(Jogador jogador : this.pool) {
			if(jogador.getId() == id) {
				return jogador;
			}
		}
		return null;
	}

	@Override
	public Jogador getPorNome(String nome) {  
		for(Jogador jogador : this.pool) {
			if(jogador.getNome().compareTo(nome)== 0) {
				return jogador;
			}
		}
		return null;
	}

	@Override
	public void inserir(Jogador jogador) throws RepositoryException {
		if(this.pool.contains(jogador)) {
			throw new RepositoryException();
		}
		this.pool.add(jogador);
	}

	@Override
	public void atualizar(Jogador jogador) throws RepositoryException {
		
	}

	@Override
	public void remover(Jogador jogador) throws RepositoryException {
		if(!this.pool.contains(jogador)) {
			throw new RepositoryException();
		}
		this.pool.remove(jogador);
	}
	
}