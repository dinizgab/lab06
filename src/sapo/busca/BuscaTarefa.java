package sapo.busca;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import sapo.tarefa.heranca.Tarefa;

public class BuscaTarefa extends BuscaAbstract{
	private String nome;
	private Map<String, Tarefa> tarefas;
	
	
	public BuscaTarefa(Map<String, Tarefa> tarefas, String nome){
		super("TAREFA");
		this.nome = nome;
		this.tarefas = tarefas;
	}
	
	@Override
	public List<String> busca() {
		List<String> resultado = new ArrayList<>();
		for (Map.Entry<String, Tarefa> pair: tarefas.entrySet()) {
			if(pair.getValue().getNome().equalsIgnoreCase(this.nome)) {
				resultado.add(pair.getValue().toString());
			}
		}
		return resultado;
	}

	
	
}
