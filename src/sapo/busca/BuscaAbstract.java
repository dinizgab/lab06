package sapo.busca;

import java.util.List;

public abstract class BuscaAbstract implements BuscaInterface{
	/**
	 * tipo de busca realizada
	 */
	private String tipo;
	
	public BuscaAbstract(String tipo){
		this.tipo = tipo;
	}
	
	@Override
	public abstract List<String> busca();

	@Override
	public String getTipo() {
		return this.tipo;
	}

}
