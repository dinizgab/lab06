package sapo.tarefa.heranca;

import java.util.HashMap;
import java.util.Map;
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

	@Override
	public String toString() {
		return this.nome + " - " + codigo + "\n" + /*atividade.getNome() + */ "\n" + /*atividade.getDescricao() + */ this.horas
				+ " hora(s) executada(s)" + this.exibeHabilidades() + "===\n" + "Equipe: " + this.exibeEquipe();
	}
}
