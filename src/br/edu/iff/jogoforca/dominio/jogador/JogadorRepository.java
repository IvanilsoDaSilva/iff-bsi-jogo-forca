package br.edu.iff.jogoforca.dominio.jogador;

import br.edu.iff.repository.Repository;
import br.edu.iff.repository.RepositoryException;

public interface JogadorRepository extends Repository {
	
    public Jogador getPorId(long id);
	
	public Jogador getPorNome(String nome);
	
	public void inserir(Jogador Jogador) throws RepositoryException;
	
	public void atualizar(Jogador Jogador) throws RepositoryException;
	
	public void remover(Jogador Jogador) throws RepositoryException;
	
}
