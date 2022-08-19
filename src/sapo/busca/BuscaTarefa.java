package sapo.busca;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import sapo.tarefa.heranca.Tarefa;
import sapo.tarefa.heranca.TarefaAbstract;

public class BuscaTarefa extends BuscaAbstract{
	private String nome;
	private Map<String, TarefaAbstract> tarefas;
	
	
	public BuscaTarefa(Map<String, TarefaAbstract> map, String nome){
		super("TAREFA");
		this.nome = nome;
		this.tarefas = map;
	}
	
	@Override
	public List<String> busca() {
		List<String> resultado = new ArrayList<>();
		for (Entry<String, TarefaAbstract> pair: tarefas.entrySet()) {
			if(pair.getValue().getNome().equalsIgnoreCase(this.nome)) {
				resultado.add(pair.getValue().toString());
			}
		}
		return resultado;
	}

	
	
}
