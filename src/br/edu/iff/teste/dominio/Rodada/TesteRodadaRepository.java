package br.edu.iff.teste.dominio.Rodada;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import br.edu.iff.bancodepalavras.dominio.letra.texto.LetraTextoFactory;
import br.edu.iff.bancodepalavras.dominio.palavra.Palavra;
import br.edu.iff.bancodepalavras.dominio.tema.Tema;
import br.edu.iff.jogoforca.dominio.boneco.texto.BonecoTextoFactory;
import br.edu.iff.jogoforca.dominio.jogador.Jogador;
import br.edu.iff.jogoforca.dominio.rodada.Rodada;
import br.edu.iff.jogoforca.dominio.rodada.emmemoria.MemoriaRodadaRepository;
import br.edu.iff.repository.RepositoryException;

class TesteRodadaRepository {
    @BeforeAll
    public static void setUp() {
		Palavra.setLetraFactory(LetraTextoFactory.getSoleInstance()); // NECESSARIO SETAR o LetraFactory ANTES DE USAR;
		Rodada.setBonecoFactory(BonecoTextoFactory.getSoleInstance()); // NECESSARIO SETAR o BonecoFactory ANTES DE USAR;
    }
    
	@Test
    public void testeSeMemoriaRodadaRepositoryInsereERetornaNaMemoria() throws RepositoryException {
		MemoriaRodadaRepository memoriaRodadaRepository = MemoriaRodadaRepository.getSoleInstance();
		
		memoriaRodadaRepository.inserir(Rodada.criar(
				memoriaRodadaRepository.getProximoId(),
				new Palavra[] {Palavra.criar(1, "PalavraUm", Tema.criar(1, "TemaUm")),Palavra.criar(1, "PalavraDois", Tema.criar(1, "TemaUm"))},
				Jogador.criar(1, "Ivanilso")
		));
		memoriaRodadaRepository.inserir(Rodada.criar(
				memoriaRodadaRepository.getProximoId(),
				new Palavra[] {Palavra.criar(1, "PalavraUm", Tema.criar(1, "TemaUm")),Palavra.criar(1, "PalavraDois", Tema.criar(1, "TemaUm"))},
				Jogador.criar(1, "Ivanilso")
		));
		memoriaRodadaRepository.inserir(Rodada.criar(
				memoriaRodadaRepository.getProximoId(),
				new Palavra[] {Palavra.criar(1, "PalavraUm", Tema.criar(1, "TemaUm")),Palavra.criar(1, "PalavraDois", Tema.criar(1, "TemaUm"))},
				Jogador.criar(1, "Caike")
		));
    	
        assertSame(memoriaRodadaRepository.getPorJogador(Jogador.criar(1, "Ivanilso")).length, 2, "O tamanho do array deve ser dois");
        assertSame(memoriaRodadaRepository.getPorJogador(Jogador.criar(1, "Caike")).length, 1, "O tamanho do array deve ser dois");
	}
}
