package br.edu.iff.bancodepalavras.dominio.tema.emmemoria;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import br.edu.iff.bancodepalavras.dominio.tema.Tema;
import br.edu.iff.bancodepalavras.dominio.tema.TemaRepository;
import br.edu.iff.repository.RepositoryException;

public class MemoriaTemaRepository implements TemaRepository {
	private static MemoriaTemaRepository soleInstance;
	private HashSet<Tema> pool = new HashSet<Tema>();
	
	private MemoriaTemaRepository() {}
	
	/**
	 * Obtem uma instancia unica de MemoriaRepositoryFactory
	 * 
	 * @author IvanilsoDaSilva
	 * @return Instancia unica de MemoriaRepositoryFactory
	 */
	public static MemoriaTemaRepository getSoleInstance() {
        if (soleInstance == null) {
        	soleInstance = new MemoriaTemaRepository();
			return soleInstance;
        }
        return soleInstance;
	}
	
	private HashSet<Tema> getPool(){
		return this.pool;
	}

	@Override
	public long getProximoId() {
		return this.getPool().size()+1;
	}

	@Override
	public Tema getPorId(long id) {
		if (id < 0)
			throw new IllegalArgumentException("O argumento não pode ser menor que zerodwa");
		//Tema[] novoArray = pool.toArray(new Tema[0]);
	    
		for(Tema tema : this.pool) {
            if(tema.getId() == id) {
                return tema;
            }
        }
		System.out.println("Retornando null");
        return null;
    
	}

	@Override
	public Tema[] getPorNome(String nome) {
		if (nome == null)
			throw new IllegalArgumentException("O argumento não pode ser null");
	    List<Tema> temasEncontrados = new ArrayList<>();
	    
	    for (Tema tema : pool) {
	        if (tema.getNome().equalsIgnoreCase(nome)) {
	            temasEncontrados.add(tema);
	        }
	    }
	    
	    return temasEncontrados.toArray(new Tema[0]);
	}

	@Override
	public Tema[] getTodos() {
	    return pool.toArray(new Tema[pool.size()]);
	}

	@Override
	public void inserir(Tema tema) throws RepositoryException {
		if (tema == null)
			throw new IllegalArgumentException("O argumento não pode ser null");
		this.getPool().add(tema);
	}

	@Override
	public void atualizar(Tema tema) throws RepositoryException {
		if (tema == null)
			throw new IllegalArgumentException("O argumento não pode ser null");
		this.getPool().add(tema);
	}

	@Override
	public void remover(Tema tema) throws RepositoryException {
		if (tema == null)
			throw new IllegalArgumentException("O argumento não pode ser null");
		this.getPool().remove(tema);
	}
}
