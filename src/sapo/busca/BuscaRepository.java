package sapo.busca;

import java.util.ArrayList;
import java.util.List;

/**
 * armazena as buscas realizadas no sistema.
 * @author Sabrina Barbosa
 *
 */
public class BuscaRepository {
	List<List<String>> buscas;
	
	/**
	 * constrói a lista de buscas
	 */
	public BuscaRepository() {
		this.buscas = new ArrayList<>();
	}
	
	/**
	 * Adiciona uma busca ao repositório, a busca é um array onde o primeiro item é o tipo da busca e os demais itens
	 * é o retorno da busca realizada.
	 * @param tipo tipo da busca
	 * @param pesquisa busca realizada
	 */
	public void adicionaBusca(String tipo, List<String> pesquisa){
		List<String> p = new ArrayList<>(pesquisa);
		p.add(0, tipo);
		buscas.add(p);
	}
	
	/**
	 * retorna uma busca específica a partir do seu index
	 * @param index index da busca
	 * @return busca realizada
	 */
	public List<String> getBusca(int index){
		return this.buscas.get(index);
	}
	
	/**
	 * retorna as n buscas mais recentes feitas.
	 * @param nBuscas numero de buscas
	 * @return buscas realizadas.
	 */
	public List<String> getBuscasMaisRecentes(int nBuscas) {
		List<String> saida = new ArrayList<>();
		for (int i = 0; i < nBuscas; i++) {
			if(buscas.get(i) != null) {
				saida.addAll(buscas.get(i));
			}
		}
		return saida;
	}
}
