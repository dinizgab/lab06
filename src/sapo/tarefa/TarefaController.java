package sapo.tarefa;

public class TarefaController {
	private TarefaService ts;

	public TarefaController(TarefaService ts) {
		this.ts = ts;
	}

	/**
	 * cadastra uma tarefa a partir do Id de uma atividade
	 * 
	 * @param id          Id da atividade
	 * @param nome        nome da Tarefa
	 * @param habilidades habilidades relacionadas a tarefa
	 * @return codigo da tarefa cadastrada
	 */
	public String cadastrarTarefa(String id, String nome, String[] habilidades) {
		return ts.cadastraTarefa(id, nome, habilidades);
	}

	public String cadastrarTarefaGerencial(String id, String nome, String[] habilidades, String[] idTarefas) {
		return ts.cadastraTarefaGerencial(id, nome, habilidades, idTarefas);
	}

	/**
	 * altera o nome de uma tarefa.
	 * 
	 * @param codigo   codigo da tarefa.
	 * @param novoNome novo nome da tarefa.
	 */
	public void alterarNomeTarefa(String codigo, String novoNome) {
		ts.alterarNomeTarefa(codigo, novoNome);
	}

	/**
	 * altera as habilidades referentes a uma tarefa.
	 * 
	 * @param codigo      codigo da tarefa.
	 * @param habilidades habilidades referentes a tarefa.
	 */
	public void alterarHabilidadesTarefa(String codigo, String[] habilidades) {
		ts.alterarHabilidadesTarefa(codigo, habilidades);
	}

	/**
	 * adiciona horas gastas na atividade.
	 * 
	 * @param codigo codigo da atividade
	 * @param horas  horas gastas.
	 */
	public void adicionarHorasTarefa(String codigo, int horas) {
		ts.adicionarHorasTarefa(codigo, horas);
	}

	/**
	 * remove horas gastas na atividade.
	 * 
	 * @param codigo codigo da atividade.
	 * @param horas  horas a serem removidas.
	 */
	public void removerHorasTarefa(String codigo, int horas) {
		ts.removerHorasTarefa(codigo, horas);
	}

	/**
	 * conclui uma tarefa.
	 * 
	 * @param codigo codigo da tarefa.
	 */
	public void concluirTarefa(String codigo) {
		ts.concluirTarefa(codigo);
	}

	/**
	 * remove uma tarefa do sistema.
	 * 
	 * @param codigo codigo da tarefa.
	 */
	public void removerTarefa(String codigo) {
		ts.removerTarefa(codigo);
	}

	/**
	 * exibe uma tarefa.
	 * 
	 * @param codigo codigo da tarefa.
	 * @return a representação textual de uma tarefa.
	 */
	public String exibirTarefa(String codigo) {
		return ts.exibirTarefa(codigo);
	}

	/**
	 * associa uma pessoa a uma tarefa.
	 * 
	 * @param cpf    cpf da pessoa.
	 * @param codigo codigo da tarefa.
	 */
	public void associarPessoaTarefa(String cpf, String codigo) {
		ts.associarPessoaTarefa(cpf, codigo);
	}

	/**
	 * remove uma pessoa de uma tarefa.
	 * 
	 * @param cpf    cpf da pessoa.
	 * @param codigo codigo da tarefa.
	 */
	public void removerPessoaTarefa(String cpf, String codigo) {
		ts.removerPessoaTarefa(cpf, codigo);
	}
}
