package sapo.tarefa;

import sapo.atividade.Atividade;
import sapo.atividade.AtividadeService;
import sapo.pessoa.PessoaService;

public class TarefaService {
	private AtividadeService as;
	private PessoaService ps;
	private TarefaRepository tr;
	
	
	/**
	 * Cadastra uma tarefa e retorna seu codigo, o codigo é formado pela 
	 * junção do Id da Atividade com a ordem de cadastro de tarefas na atividade em questão.
	 * A tarefa é armazenada na atividade em especifico e no repositório de tarefas.
     * @param id Id da atividade
     * @param nome nome da Tarefa
     * @param habilidades habilidades relacionadas a tarefa
     * @return codigo da tarefa cadastrada
	 */
	public String cadastraTarefa(String id, String nome, String[] habilidades) {
		Atividade atividade = as.getAtividade(id);
		String codigo = id + "-" + atividade.getTarefas().size();
		Tarefa tarefa = new Tarefa(codigo, nome, habilidades, atividade);
		atividade.adicionaTarefa(tarefa);
		tr.adicionaTarefa(tarefa);
		return codigo;
	}

	
    /**
     * altera o nome de uma tarefa a partir do seu codigo.
     * @param codigo codigo da tarefa.
     * @param novoNome novo nome da tarefa.
     */
	public void alterarNomeTarefa(String codigo, String novoNome) {
		tr.alterarNomeTarefa(codigo, novoNome);	
	}

    /**
     * altera as habilidades referentes a uma tarefa a partir do seu código.
     * @param codigo codigo da tarefa.
     * @param habilidades habilidades referentes a tarefa.
     */
	public void alterarHabilidadesTarefa(String codigo, String[] habilidades) {
		tr.alterarHabilidadesTarefa(codigo, habilidades);
		
	}

    /**
     * adiciona horas gastas na atividade.
     * @param codigo codigo da atividade
     * @param horas horas gastas.
     */
	public void adicionarHorasTarefa(String codigo, int horas) {
		tr.adicionarHorasTarefa(codigo, horas);		
	}
	
    /**
     * remove horas gastas na atividade.
     * @param codigo codigo da atividade.
     * @param horas horas a serem removidas.
     */
	public void removerHorasTarefa(String codigo, int horas) {
		tr.removerHorasTarefa(codigo, horas);
	}
	
    /**
     * conclui uma tarefa.
     * @param codigo codigo da tarefa.
     */
	public void concluirTarefa(String codigo) {
		tr.concluirTarefa(codigo);
	}

    /**
     * remove uma tarefa do sistema. A tarefa é removida no repositório e na Atividade.
     * @param codigo codigo da tarefa.
     */
	public void removerTarefa(String codigo) {
		as.getAtividade(recuperaIdAtividade(codigo)).removerTarefa(codigo);;
		tr.removerTarefa(codigo);		
	}

    /**
     * exibe uma tarefa.
     * @param codigo codigo da tarefa.
     * @return a representação textual de uma tarefa.
     */
	public String exibirTarefa(String codigo) {
		return tr.exibirTarefa(codigo);
	}

    /**
     * associa uma pessoa a uma tarefa.
     * @param cpf cpf da pessoa.
     * @param codigo codigo da tarefa.
     */
	public void associarPessoaTarefa(String codigo, String cpf) {
		tr.associarPessoaTarefa(codigo, ps.getPessoa(cpf));
		
	}

    /**
     * remove uma pessoa de uma tarefa.
     * @param codigo codigo da tarefa.
     * @param cpf cpf da pessoa.
     */
	public void removerPessoaTarefa(String codigo ,String cpf) {
		tr.removerPessoaTarefa(codigo, cpf);
	}
	
	/**
	 * recupera o Id de uma atividade a partir do código de uma tarefa.
	 * @param codigo codigo da tarefa
	 * @return Id da Atividade
	 */
	private String recuperaIdAtividade(String codigo) {
		int count = 0;
		String idAtividade = "";
		String[] caracteres = codigo.split("");
		for (int i = 0; i < caracteres.length; i++) {
			if (caracteres[i].equals("-")) { count++; }
			if (count < 2) { idAtividade += caracteres[i]; }
		}

		return idAtividade;
	}

}
