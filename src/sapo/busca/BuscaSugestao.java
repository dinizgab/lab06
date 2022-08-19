package sapo.busca;

import java.util.List;
import java.util.Map;

import sapo.pessoa.Pessoa;
import sapo.tarefa.heranca.Tarefa;
import sapo.tarefa.heranca.TarefaAbstract;

public class BuscaSugestao extends BuscaAbstract{
	private Pessoa pessoa;
	private Map<String, TarefaAbstract> tarefas;
	
	public BuscaSugestao(Pessoa pessoa, Map<String, TarefaAbstract> map){
		super("SUGESTAO");
		this.pessoa = pessoa;
		this.tarefas = map;
	}

	@Override
	public List<String> busca() {
		// TODO Auto-generated method stub
		return null;
	}


	
	
}
