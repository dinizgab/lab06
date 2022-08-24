package sapo.busca;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * armazena as buscas realizadas no sistema.
 * @author Sabrina Barbosa
 *
 */
public class BuscaRepository {
	int contador;
	Map<Integer, String> buscas;
	
	/**
	 * constrói a lista de buscas
	 */
	public BuscaRepository() {
		this.buscas = new HashMap<>();
		this.contador = 0;
	}
	
	/**
	 * Adiciona uma busca ao repositório, a busca é um array onde o primeiro item é o tipo da busca e os demais itens
	 * é o retorno da busca realizada.
	 * @param tipo tipo da busca
	 * @param pesquisa busca realizada
	 */
	public void adicionaBusca(String tipoPesquisa){
		buscas.put(contador, tipoPesquisa);
		contador++;
	}
	
	/**
	 * retorna uma busca específica a partir do seu index
	 * @param index index da busca
	 * @return busca realizada
	 */
	public String getBusca(int index){
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
				saida.add(buscas.get(i));
			}
		}
		return saida;
	}
}
