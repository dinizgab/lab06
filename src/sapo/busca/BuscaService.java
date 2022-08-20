package sapo.busca;

import java.util.ArrayList;
import java.util.List;

import sapo.atividade.Atividade;
import sapo.tarefa.heranca.TarefaAbstract;

/**
 * service da funcionalidade de buscas do sistema
 * @author Sabrina Barbosa
 *
 */
public class BuscaService {
	private BuscaRepository br;
	
	/**
	 * cosntrói o service de busca
	 * @param br repositorio de busca
	 */
	public BuscaService(BuscaRepository br) {
		this.br = br;
	}

	/**
	 * realiza uma busca no sistema
	 * @param busca tipo de busca
	 * @return resultado da busca
	 */
	public List<String> busca(BuscaInterface busca) {
		List<String> pesquisa = busca.busca();
		br.adicionaBusca(busca.getTipo(), pesquisa);
		return pesquisa;
	}
	
	/**
	 * busca tarefas um uma atividade específica, se o nome da tarefa for igual a chave de busca o toString da tarefa
	 * é adicionado ao resultado da busca. 
	 * @param atividade atividade
	 * @param nome nome da tarefa
	 * @return representação textual das tarefa encontradas na busca.
	 */
	public List<String> buscaTarefasEmAtividade(Atividade atividade, String nome) {
		List<String> resultado = new ArrayList<>();
		
		for (TarefaAbstract tarefa : atividade.getTarefas()) {
			if(tarefa.getNome().equalsIgnoreCase(nome)) {
				resultado.add(tarefa.toString());
			}
		}
		return resultado;
	}

	/**
	 * retorna uma busca específica a partir do seu index
	 * @param indexBusca index da busca
	 * @return busca realizada
	 */
	public List<String> getBusca(int indexBusca) {
		return br.getBusca(indexBusca);
	}

	/**
	 * retorna as n buscas mais recentes feitas.
	 * @param nBuscas numero de buscas
	 * @return buscas realizadas.
	 */
	public List<String> buscasMaisRecentes(int nBuscas) {
		return br.getBuscasMaisRecentes(nBuscas);
	}

	
	
}
