package sapo.busca;

import java.util.List;
import java.util.Map;

import sapo.pessoa.Pessoa;
import sapo.tarefa.heranca.Tarefa;

public class BuscaSugestao extends BuscaAbstract{
	private Pessoa pessoa;
	private Map<String, Tarefa> tarefas;
	
	public BuscaSugestao(Pessoa pessoa, Map<String, Tarefa> tarefas){
		super("SUGESTAO");
		this.pessoa = pessoa;
		this.tarefas = tarefas;
	}

	@Override
	public List<String> busca() {
		// TODO Auto-generated method stub
		return null;
	}


	
	
}
