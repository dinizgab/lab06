package sapo.tarefa;

import sapo.atividade.Atividade;
import sapo.pessoa.Pessoa;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class TarefaGerencial extends TarefaAbstract{
    private Set<String> habilidades;
    private Map<String, Pessoa> responsaveis;
    private Set<Tarefa> tarefasGerenciadas;
    private int horas;
    private boolean concluida;

    public TarefaGerencial(String nome, String codigo, Atividade atividade, Set<String> habilidades, Set<Tarefa> tarefas) {
        super(nome, codigo, atividade);

        this.responsaveis = new HashMap<>();
        this.tarefasGerenciadas = tarefas;
        this.habilidades = this.criaHabilidadesTotais(habilidades);
        this.horas = this.calculaHorasTotais();
        this.concluida = false;
    }

    public void concluiTarefa() {
        for (Tarefa t : this.tarefasGerenciadas) {
            t.concluirTarefa();
        }
        this.concluida = true;
    }

    @Override
    public String toString() {
        return this.nome + " - " + codigo + "\n- " + /*atividade.getNome() + */"\n" + this.exibeHabilidades() + "\n(" + this.horas
                + " hora(s) executada(s))" + "\n===\n" + "Equipe: \n" + this.exibeEquipe() + "\n===\nTarefas:\n" + this.exibeTarefas();
    }

    private Set<String> criaHabilidadesTotais(Set<String> habilidades) {
        for (Tarefa tarefa : this.tarefasGerenciadas) {
            habilidades.addAll(tarefa.getHabilidades());
        }
        return habilidades;
    }

    private int calculaHorasTotais() {
        int horas = 0;
        for (Tarefa tarefa : this.tarefasGerenciadas) {
            horas += tarefa.getHoras();
        }

        return horas;
    }

    private String exibeTarefas() {
        // TODO - Arrumar um jeito de formatar da tarefa mais nova para a mais antiga
        String saida = "";
        for (Tarefa tarefa : this.tarefasGerenciadas) {
            saida += "- " + tarefa.getNome() + " - " + tarefa.getCodigo() + "\n";
        }

        return saida;
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
