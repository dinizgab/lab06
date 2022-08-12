package sapo.atividade;

import java.util.Map;

import sapo.pessoa.Pessoa;
import sapo.tarefa.Tarefa;

public class Atividade {
	private Map<String, Tarefa> tarefas;
	private int qntTarefas;
	

	
	
	
	
	
	
	
	
	
	// tarefa
	
	private String geraIdTarefa(){
		return this.id += "-" + qntTarefas;
	}
	
	public String cadastraTarefa(String nome, String[] habilidades) {
		String idTarefa = geraIdTarefa();
		tarefas.put(idTarefa, new Tarefa(idTarefa, nome, habilidades));
		qntTarefas ++;
		return  idTarefa;
	}

	public void alteraNomeTarefa(String idTarefa, String novoNome) {
		tarefas.get(idTarefa).setNome(novoNome);
	}

	public void alterarHabilidadesTarefa(String idTarefa, String[] habilidades) {
		tarefas.get(idTarefa).setHabilidades(habilidades);
		
	}

	public void adicionarHorasTarefa(String idTarefa, int horas) {
		tarefas.get(idTarefa).adicionaHoras(horas);		
	}

	public void removerHorasTarefa(String idTarefa, int horas) {
		tarefas.get(idTarefa).removeHoras(horas);
		
	}

	public void concluirTarefa(String idTarefa) {
		tarefas.get(idTarefa).concluirTarefa();
		
	}

	public void removerTarefa(String idTarefa) {
		tarefas.remove(idTarefa);
		
	}

	public String exibirTarefa(String idTarefa) {
		return tarefas.get(idTarefa).toString();
		
	}

	public void associarPessoaTarefa(String idTarefa, Pessoa pessoa) {
		tarefas.get(idTarefa).adicionaResponsavel(pessoa);
		
	}
	
	public void removerPessoaTarefa(String cpf, String idTarefa) {
		tarefas.get(idTarefa).removerResponsavel(cpf);		
	}
}
