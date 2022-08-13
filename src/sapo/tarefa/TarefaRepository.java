package sapo.tarefa;
import java.util.Map;
import sapo.pessoa.Pessoa;


public class TarefaRepository {
	private Map<String, Tarefa> tarefas;
	
	
	/**
	 * adiciona uma tarefa ao mapa de tarefas
	 * @param tarefa tarefa
	 */
	public void adicionaTarefa(Tarefa tarefa) {
		tarefas.put(tarefa.getCodigo(), tarefa);
	}

    /**
     * altera o nome de uma tarefa a partir do seu codigo.
     *  o nome só pode ser alterado se a atividade não estiver concluída.
     * @param codigo codigo da tarefa.
     * @param novoNome novo nome da tarefa.
     */
	public void alterarNomeTarefa(String codigo, String novoNome) {
		Tarefa tarefa = tarefas.get(codigo);
		if(!tarefa.getStatus()) {
			tarefa.setNome(novoNome);
		}
	}
	
    /**
     * altera as habilidades referentes a uma tarefa. 
     * as habilidades só podem ser alteradas se a atividade não estiver concluída.
     * @param codigo codigo da tarefa.
     * @param habilidades habilidades referentes a tarefa.
     */
	public void alterarHabilidadesTarefa(String codigo, String[] habilidades) {
		Tarefa tarefa = tarefas.get(codigo);
		if(!tarefa.getStatus()) {
			tarefa.setHabilidades(habilidades);
		}
	}

    /**
     * adiciona horas gastas na atividade.
     * @param codigo codigo da atividade
     * @param horas horas gastas.
     */
	public void adicionarHorasTarefa(String codigo, int horas) {
		tarefas.get(codigo).adicionaHoras(horas);
	}

    /**
     * remove horas gastas na atividade.
     * @param codigo codigo da atividade.
     * @param horas horas a serem removidas.
     */
	public void removerHorasTarefa(String codigo, int horas) {
		tarefas.get(codigo).removeHoras(horas);

	}

    /**
     * conclui uma tarefa.
     * @param codigo codigo da tarefa.
     */
	public void concluirTarefa(String codigo) {
		tarefas.get(codigo).concluirTarefa();

	}
	
    /**
     * remove uma tarefa do mapa de tarefas.
     * @param codigo codigo da tarefa.
     */
	public void removerTarefa(String codigo) {
		tarefas.remove(codigo);

	}

    /**
     * exibe uma tarefa.
     * @param codigo codigo da tarefa.
     * @return a representação textual de uma tarefa.
     */
	public String exibirTarefa(String codigo) {
		return tarefas.get(codigo).toString();
	}
	
	/**
	 * associa uma pessoa a uma terefa.
	 * @param codigo codigo da tarefa.
	 * @param pessoa pessoa a ser associada.
	 */
	public void associarPessoaTarefa(String codigo, Pessoa pessoa) {
		tarefas.get(codigo).adicionaResponsavel(pessoa);		
	}

    /**
     * remove uma pessoa de uma tarefa.
     * @param codigo codigo da tarefa.
     * @param cpf cpf da pessoa.
     */
	public void removerPessoaTarefa(String codigo, String cpf) {
		tarefas.get(codigo).removerResponsavel(cpf);
		
	}

}
	