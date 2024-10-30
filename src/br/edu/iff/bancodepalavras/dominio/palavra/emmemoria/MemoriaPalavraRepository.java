package br.edu.iff.bancodepalavras.dominio.palavra.emmemoria;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import br.edu.iff.bancodepalavras.dominio.palavra.Palavra;
import br.edu.iff.bancodepalavras.dominio.palavra.PalavraRepository;
import br.edu.iff.bancodepalavras.dominio.tema.Tema;
import br.edu.iff.repository.RepositoryException;

public class MemoriaPalavraRepository implements PalavraRepository {
	private static MemoriaPalavraRepository soleInstance = null;
	private HashSet<Palavra> pool = new HashSet<Palavra>();
	
	/**
	 * Obtem uma instancia unica de MemoriaRepositoryFactory
	 * 
	 * @author IvanilsoDaSilva
	 * @return Instancia unica de MemoriaRepositoryFactory
	 */
	public static MemoriaPalavraRepository getSoleInstance() {
        if (soleInstance == null) {
        	soleInstance = new MemoriaPalavraRepository();
			return soleInstance;
        }
        return soleInstance;
	}

	private HashSet<Palavra> getPool(){
		return this.pool;
	}

	@Override
	public long getProximoId() {
		return this.getPool().size()+1;
	}

	@Override
	public Palavra getPorId(long id) {
		if (id < 1)
			throw new IllegalArgumentException("O argumento não pode ser menor que zero");
		Palavra[] novoArray = pool.toArray(new Palavra[0]);
	    
	    for (Palavra palavra : novoArray) {
	        if (palavra.getId() == id) {
	            return palavra;
	        }
	    }
	    
	    return null;
	}

	@Override
	public Palavra[] getPorTema(Tema tema) {
		if (tema == null)
			throw new IllegalArgumentException("O argumento não pode ser null");
		List<Palavra> palavrasEncontradas = new ArrayList<>();
		
	    for (Palavra palavra : pool) {
	        if (palavra.getTema().equals(tema)) {
	        	palavrasEncontradas.add(palavra);
	        }
	    }
	    
	    return palavrasEncontradas.toArray(new Palavra[0]);
	}

	@Override
	public Palavra[] getTodas() {
		return pool.toArray(new Palavra[pool.size()]);
	}

	@Override
	public Palavra getPalavra(String nome) {
		if (nome == null)
			throw new IllegalArgumentException("O argumento não pode ser null");
	    for (Palavra palavra : pool) {
	        if (palavra.toString().equalsIgnoreCase(nome)) {
	            return palavra;
	        }
	    }
	    return null;
	}

	@Override
	public void inserir(Palavra palavra) throws RepositoryException {
		if (palavra == null)
			throw new IllegalArgumentException("O argumento não pode ser null");
		this.getPool().add(palavra);
	}

	@Override
    public void atualizar(Palavra palavra) throws RepositoryException {
		if (palavra == null)
			throw new IllegalArgumentException("O argumento não pode ser null");
		this.getPool().remove(palavra);
		this.getPool().add(palavra);
	}
	
	@Override
	public void remover(Palavra palavra) throws RepositoryException {
		if (palavra == null)
			throw new IllegalArgumentException("O argumento não pode ser null");
		this.getPool().remove(palavra);
	}
}
