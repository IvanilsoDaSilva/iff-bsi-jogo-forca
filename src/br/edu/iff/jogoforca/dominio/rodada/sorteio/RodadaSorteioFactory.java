package br.edu.iff.jogoforca.dominio.rodada.sorteio;

import br.edu.iff.bancodepalavras.dominio.palavra.PalavraRepository;
import br.edu.iff.bancodepalavras.dominio.tema.TemaRepository;
import br.edu.iff.jogoforca.dominio.jogador.Jogador;
import br.edu.iff.jogoforca.dominio.rodada.Rodada;
import br.edu.iff.jogoforca.dominio.rodada.RodadaFactoryImpl;
import br.edu.iff.jogoforca.dominio.rodada.RodadaRepository;
import java.util.Random;

public class RodadaSorteioFactory extends RodadaFactoryImpl {
	private static RodadaSorteioFactory soleInstance = null;
	Random random = new Random();
	
	private RodadaSorteioFactory(RodadaRepository rodadaRepository, TemaRepository temaRepository, PalavraRepository palavraRepository) {
		super(rodadaRepository, temaRepository, palavraRepository);
	}

	public static void createSoleInstance(RodadaRepository rodadaRepository, TemaRepository temaRepository, PalavraRepository palavraRepository) {
		if (soleInstance == null) {
			//System.out.println("RodadaSorteioFactory Criada");
            soleInstance = new RodadaSorteioFactory(rodadaRepository, temaRepository, palavraRepository);
            //System.out.println("RodadaSorteioFactory Criada Com Sucesso");
        }
	}
	
	public static RodadaSorteioFactory getSoleInstance() {
		if (soleInstance == null) {
            throw new IllegalStateException("A instância não foi criada. Chame createSoloInstance primeiro 34.");
        }
        return soleInstance;
	}

	@Override
	public Rodada getRodada(Jogador jogador) {//VER DEPOIS NAO ESTÁ PRONTO
		return Rodada.criar(
				this.getRodadaRepository().getProximoId(),
				this.getPalavraRepository().getPorTema(this.getTemaRepository().getPorId(random.nextInt(this.getTemaRepository().getTodos().length)+1)), //adicionar para pegar o array de palavras e o tema aleatorio
				jogador
		);
	}
	
}
