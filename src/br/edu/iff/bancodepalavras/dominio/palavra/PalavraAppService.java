package br.edu.iff.bancodepalavras.dominio.palavra;

import br.edu.iff.bancodepalavras.dominio.tema.Tema;
import br.edu.iff.bancodepalavras.dominio.tema.TemaRepository;
import br.edu.iff.repository.RepositoryException;

public class PalavraAppService {

    private static PalavraAppService soleInstance;

    private PalavraRepository palavraRepository;
    private TemaRepository temaRepository;
    private PalavraFactory palavraFactory;

    public static void createSoleInstance(TemaRepository temaRepository, PalavraRepository palavraRepository, PalavraFactory palavraFactory) {
        if (soleInstance == null) {
            soleInstance = new PalavraAppService(palavraRepository, temaRepository, palavraFactory);
        }
    }

    private PalavraAppService(PalavraRepository palavraRepository, TemaRepository temaRepository,
            PalavraFactory palavraFactory) {
        this.palavraRepository = palavraRepository;
        this.temaRepository = temaRepository;
        this.palavraFactory = palavraFactory;
    }

    public static PalavraAppService getSoleInstance() {
        if (soleInstance == null) {
            throw new IllegalStateException("É preciso criar o soleInstance primeiro!");
        }
        return soleInstance;
    }

    public boolean novaPalavra(String palavra, long idTema) {
        Tema tema = this.temaRepository.getPorId(idTema);
        if (tema == null) {
            throw new RuntimeException("Tema não pode ser nulo!");
        }
        if (this.palavraRepository.getPalavra(palavra) != null) {
            return true;
        }
        try {
            this.palavraRepository.inserir(this.palavraFactory.getPalavra(palavra, tema));
            return true;
        }
        catch (RepositoryException e) {
            System.out.println("Falha ao inserir nova palavra");
            return false;
        }
    }
    
}
