package br.edu.iff.jogoforca.texto;

import br.edu.iff.bancodepalavras.dominio.letra.Letra;
import br.edu.iff.bancodepalavras.dominio.letra.texto.LetraTextoFactory;
import br.edu.iff.jogoforca.ElementoGraficoFactory;
import br.edu.iff.jogoforca.dominio.boneco.Boneco;
import br.edu.iff.jogoforca.dominio.boneco.texto.BonecoTextoFactory;

public class ElementoGraficoTextoFactory implements ElementoGraficoFactory {
private static ElementoGraficoTextoFactory soleInstance = null;
	private BonecoTextoFactory bonecoTextoFactory = BonecoTextoFactory.getSoleInstance();
	private LetraTextoFactory letraTextoFactory = LetraTextoFactory.getSoleInstance();

	/**
	 * O construtor e privado para apenas a proprica classe criar uma instancia unica de si (Singleton)
	 * 
	 * @author IvanilsoDaSilva
	 */
	private ElementoGraficoTextoFactory() {}

	/**
	 * Obtem uma instancia unica de ElementoGraficoTextoFactory
	 * 
	 * @author IvanilsoDaSilva
	 * @return Instancia unica de ElementoGraficoTextoFactory
	 */
	public static ElementoGraficoTextoFactory getSoleInstance() {
        if (soleInstance == null) {
        	return soleInstance = new ElementoGraficoTextoFactory();
        }
        return soleInstance;
	}

	@Override
	public Boneco getBoneco() {
		return bonecoTextoFactory.getBoneco();
	}

	@Override
	public Letra getLetra(char codigo) {
		return letraTextoFactory.criarLetra(codigo);
	}

	@Override
	public Letra getLetraEncoberta() {
		return letraTextoFactory.getLetraEncoberta();
	}

}
