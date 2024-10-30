package br.edu.iff;

import java.util.Scanner;

import br.edu.iff.bancodepalavras.dominio.letra.LetraFactory;
import br.edu.iff.bancodepalavras.dominio.palavra.PalavraAppService;
import br.edu.iff.bancodepalavras.dominio.tema.TemaFactory;
import br.edu.iff.bancodepalavras.dominio.tema.TemaRepository;
import br.edu.iff.jogoforca.Aplicacao;
import br.edu.iff.jogoforca.dominio.jogador.JogadorFactory;
import br.edu.iff.jogoforca.dominio.jogador.JogadorNaoEncontradoException;
import br.edu.iff.jogoforca.dominio.jogador.JogadorRepository;
import br.edu.iff.jogoforca.dominio.rodada.Rodada;
import br.edu.iff.jogoforca.dominio.rodada.RodadaAppService;
import br.edu.iff.repository.RepositoryException;

public class Main {

	public static void main(String[] args) throws RepositoryException, JogadorNaoEncontradoException {
		Aplicacao app = Aplicacao.getSoleInstance();
		//System.out.println("1");
		app.configurar();
		//System.out.println("2");
		TemaRepository temas = app.getRepositoryFactory().getTemaRepository();
		JogadorRepository jogadores = app.getRepositoryFactory().getJogadorRepository();
		JogadorFactory jogadorFactory = app.getJogadorFactory();
		TemaFactory temaFactory = app.getTemaFactory();
		definirTemas(temas, temaFactory);
		jogar(jogadores, jogadorFactory);
	}

	public static void definirTemas(TemaRepository temas, TemaFactory temaFactory) {
		String[] listaDeTemas = { "Veiculos", "Instrumentos Mus.", "Ferramenta", "Pais" };
		for (String tema : listaDeTemas) {
			try {
				temas.inserir(temaFactory.getTema(tema));
			} catch (RepositoryException error) {
				error.printStackTrace();
			}
		}

		String[] palavrasVeiculos = { "carro", "moto", "caminhao", "foguete", "barco", "navio"};
		for (String palavra : palavrasVeiculos) {
			PalavraAppService.getSoleInstance().novaPalavra(palavra,
					temas.getPorNome(listaDeTemas[0])[0].getId());
		}
		String[] palavrasInstrumentos = { "bateria", "baixo", "piano", "guitarra", "pandero" };
		for (String palavra : palavrasInstrumentos) {
			PalavraAppService.getSoleInstance().novaPalavra(palavra,
					temas.getPorNome(listaDeTemas[1])[0].getId());
		}
		String[] palavrasFerramentas = { "martelo", "serra", "alicate", "parafusadeira", "trena" };
		for (String palavra : palavrasFerramentas) {
			PalavraAppService.getSoleInstance().novaPalavra(palavra,
					temas.getPorNome(listaDeTemas[2])[0].getId());
		}
		String[] palavrasPais = { "brasil", "chile", "espanha", "portugal", "japao" };
		for (String palavra : palavrasPais) {
			PalavraAppService.getSoleInstance().novaPalavra(palavra,
					temas.getPorNome(listaDeTemas[3])[0].getId());
		}
	}

	public static void jogar(JogadorRepository jogadores, JogadorFactory jogadorFactory)
			throws RepositoryException, JogadorNaoEncontradoException {
		//System.out.println("3");
		Rodada partida = RodadaAppService.getSoleInstance().novaRodada(obterJogadorDaRodada(jogadores, jogadorFactory));
		//System.out.println("3");
		Scanner entrada = new Scanner(System.in);
		Object contexto = null;
		String escolha;
		String[] palavrasArriscadas = new String[partida.getPalavras().length];
		do {
			exibirInformacoes(partida, contexto);
			System.out.print("\nDigite 1 para tentar e 2 para arriscar:");
			escolha = entrada.nextLine();
			switch (escolha) {
				case "1":
					tentar(partida);
					break;
				case "2":
					arriscar(partida, palavrasArriscadas);
					break;
				default:
					System.out.println("Escolha inválida");
					break;
			}
			System.out.println("+++++++++++++++++++++++++++++");
		} while (!partida.encerrou());
		encerrar(partida, contexto);
		RodadaAppService.getSoleInstance().salvarRodada(partida);
		entrada.close();
	}

	public static String obterJogadorDaRodada(JogadorRepository jogadores, JogadorFactory jogadorFactory)
			throws RepositoryException {
		@SuppressWarnings("resource")
		Scanner entrada = new Scanner(System.in);

		System.out.println("Informe seu nome: ");
		String nomeJogador = entrada.nextLine();
		System.out.println();
		//System.out.println("Inserindo");
		jogadores.inserir(jogadorFactory.getJogador(nomeJogador));
		//System.out.println("Inseriu");
		return nomeJogador;
	}

	public static void exibirInformacoes(Rodada partida, Object contexto) {
		System.out.println("Tema: " + partida.getTema().getNome());
		System.out.println("Palavras: ");
		partida.exibirItens(contexto);
		System.out.print("Letras erradas: ");
		partida.exibirLetrasErradas(contexto);
		System.out.println("\nBoneco: ");
		partida.exibirBoneco(contexto);
	}

	public static void arriscar(Rodada partida, String[] palavrasArriscadas) {
		@SuppressWarnings("resource")
		Scanner entrada = new Scanner(System.in);
		System.out.println("Arriscando!");
		System.out.println("Digite as palavras:");
		for (int posicaoAtual = 0; posicaoAtual < palavrasArriscadas.length; posicaoAtual++) {
			System.out.print((posicaoAtual + 1) + "ª palavra: ");
			palavrasArriscadas[posicaoAtual] = entrada.nextLine();
		}
		partida.arriscar(palavrasArriscadas);
	}

	public static void tentar(Rodada partida) {
		@SuppressWarnings("resource")
		Scanner entrada = new Scanner(System.in);
		System.out.println(" Tentando!");
		System.out.println("Número de tentativas restantes: " + partida.getQtdeTentativasRestantes());
		System.out.print("Digite a letra:");
		char letraTentada = entrada.nextLine().charAt(0);
		if (!(letraTentada >= 'A' && letraTentada <= 'Z')) {
			System.out.println("Letra inválida");
		} else {
			partida.tentar(letraTentada);
		}
	}

	public static void encerrar(Rodada partida, Object contexto) {
		System.out.println("---------------------------------");
		//System.out.println("1");
		if (partida.descobriu() == true) {
			//System.out.println("2");
			mostrarResultadoVitoria(partida);
		} else {
			//System.out.println("3");
			mostrarResultadoDerrota(partida, contexto);
		}
		System.out.println();
	}

	public static void mostrarResultadoVitoria(Rodada partida) {
		System.out.println("O Jogador " + partida.getJogador().getNome() + " venceu!");
		System.out.println("Número de tentativas: " + partida.getQtdeTentativas());
		System.out.println("Número de acertos: " + partida.getQtdeAcertos());
		System.out.println("Número de erros: " + partida.getQtdeErros());
		System.out.println("Pontos obtidos: " + partida.calcularPontos());
	}

	public static void mostrarResultadoDerrota(Rodada partida, Object contexto) {
		
		System.out.println("O Jogador " + partida.getJogador().getNome() + " perdeu!");
		System.out.println("Número de tentativas: " + partida.getQtdeTentativas());
		System.out.println("Número de acertos: " + partida.getQtdeAcertos());
		System.out.println("Palavras:");
		partida.exibirPalavras(contexto);
		Rodada.getBonecoFactory().getBoneco().exibir(contexto, 10);;
	}

}