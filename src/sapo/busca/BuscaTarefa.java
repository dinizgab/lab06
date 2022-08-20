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
