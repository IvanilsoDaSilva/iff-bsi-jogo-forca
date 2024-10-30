package br.edu.iff.jogoforca.dominio.jogador;

public class JogadorNaoEncontradoException extends Exception {

    private String jogador;

    public JogadorNaoEncontradoException(String jogador) {
        this.jogador = jogador;
    }

    public String getJogador() {
        return jogador;
    }
    
}
