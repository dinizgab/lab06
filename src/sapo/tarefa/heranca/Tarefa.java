package sapo.tarefa.heranca;

import java.util.Set;

import sapo.atividade.Atividade;

public class Tarefa extends TarefaAbstract {
    private Set<String> habilidades;

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
        super(nome, codigo, atividade);
        this.habilidades = habilidades;
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

    @Override
    public String toString() {
        return this.nome + " - " + codigo + "\n- " + atividade.getNome() + "\n" + this.exibeHabilidades() + "\n(" + this.horas
                + " hora(s) executada(s))" + "\n===\n" + "Equipe:\n" + this.exibeEquipe();
    }
}
