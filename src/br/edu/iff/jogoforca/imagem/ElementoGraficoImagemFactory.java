package br.edu.iff.jogoforca.imagem;

import br.edu.iff.bancodepalavras.dominio.letra.Letra;
import br.edu.iff.bancodepalavras.dominio.letra.imagem.LetraImagemFactory;
import br.edu.iff.jogoforca.ElementoGraficoFactory;
import br.edu.iff.jogoforca.dominio.boneco.Boneco;
import br.edu.iff.jogoforca.dominio.boneco.imagem.BonecoImagemFactory;

public class ElementoGraficoImagemFactory implements ElementoGraficoFactory {
private static ElementoGraficoImagemFactory soleInstance = null;
	private BonecoImagemFactory bonecoTextoFactory = BonecoImagemFactory.getSoleInstance();
	private LetraImagemFactory letraTextoFactory = LetraImagemFactory.getSoleInstance();

	/**
	 * O construtor e privado para apenas a proprica classe criar uma instancia unica de si (Singleton)
	 * 
	 * @author IvanilsoDaSilva
	 */
	private ElementoGraficoImagemFactory() {
		
	}

	/**
	 * Obtem uma instancia unica de ElementoGraficoTextoFactory
	 * 
	 * @author IvanilsoDaSilva
	 * @return Instancia unica de ElementoGraficoTextoFactory
	 */
	public static ElementoGraficoImagemFactory getSoleInstance() {
        if (soleInstance == null) {
        	return soleInstance = new ElementoGraficoImagemFactory();
        }
        return soleInstance;
	}

	@Override
	public Boneco getBoneco() {
		return bonecoTextoFactory.getBoneco();
	}

	@Override
	public Letra getLetra(char codigo) {
		// TODO Auto-generated method stub
		return letraTextoFactory.criarLetra(codigo);
	}

	@Override
	public Letra getLetraEncoberta() {
		return letraTextoFactory.getLetraEncoberta();
	}

}
