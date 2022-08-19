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
	
	
	//funcao para pegar os com mais habilidades em comum
	//funcao para, em caso de empate de duas tarefas, decidir qual tem menos pessoas
	//funcao para, ainda em caso de empate, decidir por oredem alfabetica de id


	
	
}
