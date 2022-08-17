package sapo.tarefa;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import sapo.atividade.Atividade;
import sapo.pessoa.Pessoa;

public class Tarefa extends TarefaAbstract{
	/**
	 * cria uma tarefa definindo seu codigo, nome, habilidade e a atividade a qual
	 * esta relacionada.
	 * 
	 * @param codigo      codigo da tarefa
	 * @param nome        nome da tarefa
	 * @param habilidades habilidades recomendadas da tarefa
	 * @param atividade   atividade relacionada
	 */
	public Tarefa (String nome, String codigo, Atividade atividade, Set<String> habilidades) {
		super(nome, codigo, atividade);
		this.habilidades = habilidades;
		this.responsaveis = new HashMap<>();
		this.concluida = false;
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
		if (this.concluida) return;
		this.nome = nome;
	}

	/**
	 * define as habilidades recomendadas da tarefa.
	 * 
	 * @param habilidades habilidades da tarefa.
	 */
	public void setHabilidades(Set<String> habilidades) {
		if (!this.concluida) return;
		this.habilidades = habilidades;
	}

	/**
	 * recupera o status da tarefa.
	 * 
	 * @return status da tarefa.
	 */
	public boolean getStatus() {
		return this.concluida;
	}

	public Set<String> getHabilidades() {
		return this.habilidades;
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

	@Override
	public String toString() {
		return this.nome + " - " + codigo + "\n" + /*atividade.getNome() + */ "\n" + /*atividade.getDescricao() + */ this.horas
				+ " hora(s) executada(s)" + this.exibeHabilidades() + "===\n" + "Equipe: " + this.exibeEquipe();
	}

	private String exibeEquipe() {
		String saida = "";
		for (Map.Entry<String, Pessoa> pair : responsaveis.entrySet()) {
			saida += pair.getValue().getNome() + " - " + pair.getKey() + "\n";
		}

		return saida;
	}

	private String exibeHabilidades() {
		String saida = "";
		for (String habilidade : habilidades) {
			saida += habilidade + "\n";
		}

		return saida;
	}
}
