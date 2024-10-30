package br.edu.iff.jogoforca.dominio.rodada;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import br.edu.iff.bancodepalavras.dominio.letra.Letra;
import br.edu.iff.bancodepalavras.dominio.palavra.Palavra;
import br.edu.iff.bancodepalavras.dominio.tema.Tema;
import br.edu.iff.dominio.ObjetoDominioImpl;
import br.edu.iff.jogoforca.dominio.boneco.BonecoFactory;
import br.edu.iff.jogoforca.dominio.jogador.Jogador;

public class Rodada extends ObjetoDominioImpl {
    private static int maxPalavras = 3;
    private static int maxErros = 10;
    private static int pontosQuandoDescobreTodasAsPalavras = 100;
    private static int pontosPorLetraEncoberta = 15;
    private static BonecoFactory bonecoFactory;
    private List<Letra> erradas;
    private Jogador jogador;
    private Item[] itens;
    
    public Rodada(long id, Letra[] erradas, Jogador jogador, Item[] itens) {
        super(id);
        this.erradas = Arrays.asList(erradas);
        this.jogador = jogador;
        this.itens = itens;
        
        Tema testeMesmoTema = this.itens[0].getPalavra().getTema();
        for(int i = 0; i < this.itens.length; i++) {
            if(itens[i].getPalavra().getTema().getNome() != testeMesmoTema.getNome()) {
                throw new RuntimeException("Todas as palavras devem ter o mesmo tema");
            }
        }
    }
    
    public Rodada(long id, Palavra[] palavras, Jogador jogador) {
        super(id);
        this.itens = new Item[palavras.length];
        for(int i = 0; i < palavras.length; i++) {
            this.itens[i] = Item.criar(i,palavras[i]);
        }
        this.jogador = jogador;
        this.erradas = new ArrayList<Letra>();
        Tema testeMesmoTema = this.itens[0].getPalavra().getTema();
        for(int i = 0; i<= this.itens.length-1; i++) {
            if(itens[i].getPalavra().getTema().getNome() != testeMesmoTema.getNome()) {
                throw new RuntimeException("Todas as palavras devem ter o mesmo tema");
            }
        }
    }
    
    public static Rodada criar(long id, Palavra[] palavras, Jogador jogador) {
        if (bonecoFactory == null) {
            throw new RuntimeException("Inicie o boneco factory!");
        }
        return new Rodada(id, palavras, jogador);
    }
    
    public static Rodada reconstituir(long id, Letra[] erradas, Jogador jogador, Item[] itens) {
        if (bonecoFactory == null) {
            throw new RuntimeException("Inicie o boneco factory!");
        }
        return new Rodada(id, erradas, jogador, itens);
    }
    
    public Jogador getJogador() {
        return jogador;
    }
    public Tema getTema() {
        return this.itens[0].getPalavra().getTema();
    }
    public Palavra[] getPalavras() {
        List<Palavra> palavrasRodada = new ArrayList<Palavra>();
        for (int a = 0; a < this.itens.length; a++) {
            palavrasRodada.add(this.itens[a].getPalavra());
        }
        return palavrasRodada.toArray(new Palavra[palavrasRodada.size()]);
    }
    public int getNumPalavras() {
        return this.itens.length;
    }
    public Letra[] getErradas() {
        return erradas.toArray(new Letra[this.erradas.size()]);
    }
    public Letra[] getCertas() {
        List<Letra> acertos = new ArrayList<Letra>();
        for (Item item : this.itens) {
            for (Letra letra : item.getLetrasDescobertas()) {
                if (!acertos.contains(letra)) {
                    acertos.add(letra);
                }
            }
        }
        return acertos.toArray(new Letra[acertos.size()]);
    }
    public static BonecoFactory getBonecoFactory() {
        return bonecoFactory;
    }
    public static void setBonecoFactory(BonecoFactory bonecoFactory) {
        Rodada.bonecoFactory = bonecoFactory;
    }
    public static int getMaxPalavras() {
        return maxPalavras;
    }
    public static void setMaxPalavras(int maxPalavras) {
        Rodada.maxPalavras = maxPalavras;
    }
    public static int getMaxErros() {
        return maxErros;
    }
    public static void setMaxErros(int maxErros) {
        Rodada.maxErros = maxErros;
    }
    public static int getPontosQuandoDescobreTodasAsPalavras() {
        return pontosQuandoDescobreTodasAsPalavras;
    }
    public static void setPontosQuandoDescobreTodasAsPalavras(int pontosQuandoDescobreTodasAsPalavras) {
        Rodada.pontosQuandoDescobreTodasAsPalavras = pontosQuandoDescobreTodasAsPalavras;
    }
    public static int getPontosPorLetraEncoberta() {
        return pontosPorLetraEncoberta;
    }
    public static void setPontosPorLetraEncoberta(int pontosPorLetraEncoberta) {
        Rodada.pontosPorLetraEncoberta = pontosPorLetraEncoberta;
    }
    public int getQtdeTentativasRestantes() {
        return maxErros - this.getQtdeErros();
    }
    public int getQtdeErros() {
        return this.erradas.size();
    }
    public int getQtdeAcertos() {
        return this.getCertas().length;
    }
    public int getQtdeTentativas() {
        return this.getQtdeAcertos() + this.getQtdeErros();
    }
    public Letra[] getTentativas() {
        List<Letra> tentativas = new ArrayList<Letra>();
        for (Letra letra : this.getCertas()) {
            tentativas.add(letra);
        }
        for (Letra letra : this.getErradas()) {
            tentativas.add(letra);
        }
        return tentativas.toArray(new Letra[tentativas.size()]);
    }
    public void exibirItens(Object context) {
        for (Item item : this.itens) {
            item.exibir(context);
        }
    }

    public void exibirBoneco(Object context) {
        bonecoFactory.getBoneco().exibir(context, this.getQtdeErros());
    }

    public void exibirPalavras(Object context) {
       for (Item item : this.itens) {
        item.getPalavra().exibir(context);
        }   
    }

    public void exibirLetrasErradas(Object context) {
        for (Letra letra : this.getErradas()) {
            letra.exibir(context);
            System.out.print(" ");
        }   
     }

    public int calcularPontos() {
        if (this.descobriu()) {
            int totalPontosEncobertas = 0;
            for (Item item: this.itens) {
                totalPontosEncobertas += item.calcularPontosLetrasEncobertas(pontosPorLetraEncoberta);
            }
            return pontosQuandoDescobreTodasAsPalavras + totalPontosEncobertas;
        }
        return 0;
    }

    public void tentar(char codigo) {
        if (this.encerrou()) {
            throw new RuntimeException("A rodada terminou!");
        }
        if (this.getNumPalavras() == 0) {
            throw new RuntimeException("Não há itens!");
        }
        boolean encontrado = false;
        
        for (Item item : this.itens) {
            if (item.tentar((codigo)))
            encontrado = true;
        }
        if (!encontrado) {
            this.erradas.add(Palavra.getLetraFactory().getLetra(codigo));
        }
        if (this.encerrou()) {
            this.jogador.setPontuacao(this.jogador.getPontuacao()+this.calcularPontos());
        }
    }

    public void arriscar(String[] palavras) {
        if (this.encerrou()) {
            throw new RuntimeException("A rodada terminou!");
        }

        for (int i = 0; i < this.getNumPalavras(); i++) {
            this.itens[i].arriscar(palavras[i]);
        }
    }

    public boolean descobriu() {
        for (Item item : this.itens) {
            if (item.descobriu() == false){
                return false;
            }
        }
        return true;
    }

    public boolean arriscou() {
        for (Item item : this.itens) {
            if (!item.arriscou()){
                return false;
            }
        }
        return true;
    }

    public boolean encerrou() {
        if (this.arriscou() || this.descobriu() || this.getQtdeTentativasRestantes() == 0) {
            return true;
        }
        return false;
    }
    
    
}
