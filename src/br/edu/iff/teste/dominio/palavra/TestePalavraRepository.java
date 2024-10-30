package br.edu.iff.teste.dominio.palavra;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import br.edu.iff.bancodepalavras.dominio.letra.texto.LetraTextoFactory;
import br.edu.iff.bancodepalavras.dominio.palavra.Palavra;
import br.edu.iff.bancodepalavras.dominio.palavra.emmemoria.MemoriaPalavraRepository;
import br.edu.iff.bancodepalavras.dominio.tema.Tema;
import br.edu.iff.repository.RepositoryException;

class TestePalavraRepository {
    @BeforeAll
    public static void setUp() {
		Palavra.setLetraFactory(LetraTextoFactory.getSoleInstance()); // NECESSARIO SETAR o LetraFactory ANTES DE USAR;
    }
	
	@Test
    public void testeSeMemoriaPalavraRepositoryInsereNaMemoria() throws RepositoryException {
		MemoriaPalavraRepository memoriaPalavraRepository = MemoriaPalavraRepository.getSoleInstance();
		
		memoriaPalavraRepository.inserir(Palavra.criar(memoriaPalavraRepository.getProximoId(), "PalavraUm", Tema.criar(1, "TemaUm")));
		memoriaPalavraRepository.inserir(Palavra.criar(memoriaPalavraRepository.getProximoId(), "PalavraUm", Tema.criar(1, "TemaUm")));
		memoriaPalavraRepository.inserir(Palavra.criar(memoriaPalavraRepository.getProximoId(), "PalavraDois", Tema.criar(1, "TemaDois")));
		
        assertSame(memoriaPalavraRepository.getTodas().length, 2, "O tamanho do array deve ser dois");
    }
	
	@Test
    public void testeSeMemoriaPalavraRepositoryRetornaDaMemoria() throws RepositoryException {
		MemoriaPalavraRepository memoriaPalavraRepository = MemoriaPalavraRepository.getSoleInstance();

		memoriaPalavraRepository.inserir(Palavra.criar(memoriaPalavraRepository.getProximoId(), "PalavraUm", Tema.criar(1, "TemaUm")));
		memoriaPalavraRepository.inserir(Palavra.criar(memoriaPalavraRepository.getProximoId(), "PalavraUm", Tema.criar(1, "TemaUm")));
		memoriaPalavraRepository.inserir(Palavra.criar(memoriaPalavraRepository.getProximoId(), "PalavraDois", Tema.criar(1, "TemaDois")));
		
		Palavra palavra1 = memoriaPalavraRepository.getPorId(1);
		Palavra[] palavras2 = memoriaPalavraRepository.getPorTema(Tema.criar(1, "TemaUm"));
    	
        assertSame(palavra1.getTema().getNome(), "TemaUm", "O nome do tema de palavra1 deve ser igual a 'TemaUm'");
        assertSame(palavras2.length, 1, "O tamanho do array deve ser 1");
    }
}
