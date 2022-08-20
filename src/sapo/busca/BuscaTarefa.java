package sapo.busca;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import sapo.tarefa.heranca.Tarefa;
import sapo.tarefa.heranca.TarefaAbstract;

public class BuscaTarefa extends BuscaAbstract{
	private String nome;
	private List<TarefaAbstract> tarefas;
	
	
	public BuscaTarefa(List<TarefaAbstract> tarefas, String nome){
		super("TAREFA");
		this.nome = nome;
		this.tarefas = tarefas;
	}
	
	/**
	 * Encontra as tarefas que tem relacao com a busca. A relação existe se o nome dado na buca for igual ao nome
	 * de uma tarefa
	 * @return versões textuais das tarefas encontradas na busca.
	 */
	@Override
	public List<String> busca() {
		List<String> resultado = new ArrayList<>();
		for (TarefaAbstract tarefa: tarefas) {
			if(tarefa.getNome().equalsIgnoreCase(this.nome)) {
				resultado.add(tarefa.toString());
			}
		}
		return resultado;
	}

	
	
}
