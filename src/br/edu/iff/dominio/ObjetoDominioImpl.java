package br.edu.iff.dominio;

public abstract class ObjetoDominioImpl implements ObjetoDominio {
	private long id;
	
	public ObjetoDominioImpl(long id) {
		super();
		this.id = id;
	}
	
	@Override
	public long getId() {
		// TODO Auto-generated method stub
		return id;
	}
}
