package br.edu.iff.jogoforca.dominio.rodada;

import br.edu.iff.bancodepalavras.dominio.tema.Tema;
import br.edu.iff.bancodepalavras.dominio.tema.TemaRepository;
import br.edu.iff.jogoforca.dominio.jogador.Jogador;
import br.edu.iff.jogoforca.dominio.jogador.JogadorNaoEncontradoException;
import br.edu.iff.jogoforca.dominio.jogador.JogadorRepository;
import br.edu.iff.repository.RepositoryException;

public class RodadaAppService {

    private static RodadaAppService soleInstance;

    private RodadaRepository rodadaRepository;
    private JogadorRepository jogadorRepository;
    private RodadaFactory rodadaFactory;

    public static void createSoleInstance(RodadaRepository rodadaRepository, JogadorRepository jogadorRepository,
            RodadaFactory rodadaFactory) {
        if (soleInstance == null) {
            soleInstance = new RodadaAppService(rodadaRepository, jogadorRepository, rodadaFactory);
        }
    }

    private RodadaAppService(RodadaRepository rodadaRepository, JogadorRepository jogadorRepository,
            RodadaFactory rodadaFactory) {
        this.rodadaRepository = rodadaRepository;
        this.jogadorRepository = jogadorRepository;
        this.rodadaFactory = rodadaFactory;
    }

    public static RodadaAppService getSoleInstance() {
        if (soleInstance == null) {
            throw new IllegalStateException("É preciso criar o soleInstance primeiro!");
        }
        return soleInstance;
    }

    public Rodada novaRodada(long idJogador) {
        Jogador jogador = this.jogadorRepository.getPorId(idJogador);
        if (jogador == null) {
            new RuntimeException("O ID não é correspondente a um jogador no repositório jogador!");
        }
        return this.rodadaFactory.getRodada(jogador);
    }

    public Rodada novaRodada(String nomeJogador) throws JogadorNaoEncontradoException {
        Jogador jogador = this.jogadorRepository.getPorNome(nomeJogador);
        if (jogador == null) {
            new JogadorNaoEncontradoException("Nome jogador:"+nomeJogador);
        }
        return this.rodadaFactory.getRodada(jogador);
    }

    public Rodada novaRodada(Jogador jogador) {
        return this.rodadaFactory.getRodada(jogador);
    }

    public boolean salvarRodada(Rodada rodada) {
        try {
            this.rodadaRepository.inserir(rodada);
            return true;
        }
        catch (RepositoryException e) {
            System.out.println("Erro ao inserir rodada no repositório!");
            return false;
        }
    }

    
}
