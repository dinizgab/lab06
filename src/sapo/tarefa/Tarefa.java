package sapo.tarefa;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import sapo.atividade.Atividade;
import sapo.pessoa.Pessoa;

public class Tarefa {

	private String nome;
	private Set<String> habilidades;
	private Map<String, Pessoa> responsaveis;
	/**
	 * status da atividade. quando o status é true, a atividade foi concluida.
	 * status false indica que a atividade esta aberta.
	 */
	private boolean concluida;
	private int horas;
	private String codigo;
	private Atividade atividade;

	/**
	 * cria uma tarefa definindo seu codigo, nome, habilidade e a atividade a qual
	 * esta relacionada.
	 * 
	 * @param codigo      codigo da tarefa
	 * @param nome        nome da tarefa
	 * @param habilidades habilidades recomendadas da tarefa
	 * @param atividade   atividade relacionada
	 */
	public Tarefa(String nome, String codigo, Atividade atividade, Set<String> habilidades) {
		this.nome = nome;
		this.codigo = codigo;
		this.atividade = atividade;
		this.habilidades = habilidades;
		this.concluida = false;
		this.responsaveis = new HashMap<>();
	}

	public String getNome() {
		return this.nome;
	}

	/**
	 * define o nome da tarefa.
	 * 
	 * @param nome nome da tarefa.
	 */
	public void setNome(String nome) {
		if (!concluida) {
			this.nome = nome;
		}
	}

	/**
	 * define as habilidades recomendadas da tarefa.
	 * 
	 * @param habilidades habilidades da tarefa.
	 */
	public void setHabilidades(String[] habilidades) {
		if (!concluida) {
			this.habilidades = habilidades;
		}
	}

	/**
	 * recupera o código da tarefa.
	 * 
	 * @return
	 */
	public String getCodigo() {
		return this.codigo;
	}

	/**
	 * recupera o status da tarefa.
	 * 
	 * @return status da tarefa.
	 */
	public boolean getStatus() {
		return this.concluida;
	}

	public int getHoras() {
		return this.horas;
	}

	/**
	 * conclui uma tarefa.
	 */
	public void concluirTarefa() {
		this.concluida = true;
	}

	/**
	 * adiciona horas a uma tarefa.
	 * 
	 * @param horas horas a serem adicionadas.
	 */
	public void adicionaHoras(int horas) {
		this.horas += horas;
	}

	/**
	 * remove horas de uma terefa.
	 * 
	 * @param horas horas a serem removidas.
	 */
	public void removeHoras(int horas) {
		this.horas -= horas;
	}

	/**
	 * adiciona uma pessoa responsável a tarefa.
	 * 
	 * @param pessoa pessoa a ser adicionada
	 */
	public void adicionaResponsavel(Pessoa pessoa) {
		this.responsaveis.put(pessoa.getCpf(), pessoa);
	}

	/**
	 * remove uma pessoa responsável a partir do seu cpf.
	 * 
	 * @param cpf cpf da pessoa a ser removida.
	 */
	public void removerResponsavel(String cpf) {
		this.responsaveis.remove(cpf);
	}

	@Override
	public String toString() {
		return this.nome + " - " + codigo + "\n" + atividade.getNome() + "\n" + atividade.getDescricao() + this.horas
				+ " hora(s) executada(s)" + exibeHabilidades() + "===\n" + "Equipe: " + exibeEquipe();
	}

	private String exibeHabilidades() {
		String saida = "";
		for (String habilidade : habilidades) {
			saida += habilidade + "\n";
		}

		return saida;
	}

	private String exibeEquipe() {
		String saida = "";
		for (Entry<String, Pessoa> pair : responsaveis.entrySet()) {
			saida += pair.getValue().getNome() + " - " + pair.getKey() + "\n";
		}

		return saida;
	}

}
