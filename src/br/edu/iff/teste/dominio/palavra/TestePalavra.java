package br.edu.iff.teste.dominio.palavra;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import br.edu.iff.bancodepalavras.dominio.letra.texto.LetraTextoFactory;
import br.edu.iff.bancodepalavras.dominio.palavra.Palavra;
import br.edu.iff.bancodepalavras.dominio.palavra.PalavraFactoryImpl;
import br.edu.iff.bancodepalavras.dominio.palavra.emmemoria.MemoriaPalavraRepository;
import br.edu.iff.bancodepalavras.dominio.tema.Tema;

class TestePalavra {
    @BeforeAll
    public static void setUp() {
        PalavraFactoryImpl.createSoleInstance(MemoriaPalavraRepository.getSoleInstance());;
        Palavra.setLetraFactory(LetraTextoFactory.getSoleInstance()); // NECESSARIO SETAR o LetraFactory ANTES DE USAR;
    }
	
    @Test
    public void testeSePalavraFactoryInstanciadaRetornaMesmaInstancia() {
    	PalavraFactoryImpl palavraFactoryImpl1 = PalavraFactoryImpl.getSoleInstance();
    	PalavraFactoryImpl palavraFactoryImpl2 = PalavraFactoryImpl.getSoleInstance();

        assertSame(palavraFactoryImpl1, palavraFactoryImpl2, "As instâncias devem ser as mesmas");
    }
    
    @Test
    public void testeSeLetraTextoInstanciadaDoFactoryRetornaMesmaInstancia() {
    	PalavraFactoryImpl palavraFactoryImpl = PalavraFactoryImpl.getSoleInstance();
    	
    	Palavra palavra1 = palavraFactoryImpl.getPalavra("PalavraUm", Tema.criar(0, "TemaUm"));
    	Palavra palavra2 = palavraFactoryImpl.getPalavra("PalavraUm", Tema.criar(0, "TemaUm"));

        assertSame(palavra1, palavra2, "As instâncias devem ser as mesmas");
    }
}