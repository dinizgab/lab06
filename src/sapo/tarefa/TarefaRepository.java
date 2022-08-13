package sapo.atividade;
import java.util.Map;

import sapo.pessoa.Pessoa;
import sapo.tarefa.Tarefa;

public class TarefaRepository {
	private Map<String, Tarefa> tarefas;
	
	
	public void cadastraTarefa(Tarefa tarefa) {
		tarefas.put(tarefa.getCodigo(), tarefa);
	}

	public void alterarNomeTarefa(String codigo, String novoNome) {
		tarefas.get(codigo).setNome(novoNome);
	}

	public void alterarHabilidadesTarefa(String codigo, String[] habilidades) {
		tarefas.get(codigo).setHabilidades(habilidades);
	}

	public void adicionarHorasTarefa(String codigo, int horas) {
		tarefas.get(codigo).adicionaHoras(horas);
	}

	public void removerHorasTarefa(String codigo, int horas) {
		tarefas.get(codigo).removeHoras(horas);

	}

	public void concluirTarefa(String codigo) {
		tarefas.get(codigo).concluirTarefa();

	}

	public void removerTarefa(String codigo) {
		tarefas.remove(codigo);

	}

	public String exibirTarefa(String codigo) {
		return tarefas.get(codigo).toString();
	}

	public void associarPessoaTarefa(String codigo, Pessoa pessoa) {
		tarefas.get(codigo).adicionaResponsavel(pessoa);		
	}

	public void removerPessoaTarefa(String codigo, String cpf) {
		tarefas.get(codigo).removerResponsavel(cpf);
		
	}
	
	

}
	