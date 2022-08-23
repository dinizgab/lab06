package sapo.busca;

import java.util.ArrayList;
import java.util.List;

import sapo.tarefa.heranca.TarefaAbstract;

/**
 * encontra tarefas no sistema que tenham nome igual ao passado na busca.
 * @author Sabrina Barbosa
 *
 */
public class BuscaTarefa extends BuscaAbstract{
	private String nome;
	private List<TarefaAbstract> tarefas;
	
	/**
	 * constrói a busca a partir da lista de tarefas do sistema e do nome de tarefa a ser buscado
	 * @param tarefas tarefas so sistema
	 * @param nome nome da tarefa
	 */
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
