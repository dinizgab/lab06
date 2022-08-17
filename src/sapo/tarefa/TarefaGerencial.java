package sapo.tarefa;

import sapo.atividade.Atividade;
import sapo.pessoa.Pessoa;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class TarefaGerencial {
    private String nome;
    private String codigo;
    private Set<String> habilidades;
    private Map<String, Pessoa> responsaveis;
    private Set<Tarefa> tarefasGerenciadas;
    private int horas;
    private Atividade atividade;
    private boolean concluida;

    public TarefaGerencial(String nome, String codigo, Atividade atividade, Set<String> habilidades, Set<Tarefa> tarefas) {
        this.nome = nome;
        this.codigo = codigo;
        this.tarefasGerenciadas = tarefas;
        this.atividade = atividade;
        this.habilidades = habilidades;
        this.concluida = false;
        this.responsaveis = new HashMap<>();
        this.horas = calculaHorasTotais();
    }

    public String getCodigo() {
        return this.codigo;
    }

    public void adicionaHoras(int horas) {
        this.horas += horas;
    }

    public void removeHoras(int horas) {
        this.horas -= horas;
    }

    public void adicionaResponsavel(Pessoa pessoa) {
        if(this.concluida) return;
        this.responsaveis.put(pessoa.getCpf(), pessoa);
    }

    public void removeResponsavel(String cpf) {
        if(this.concluida) return;
        this.responsaveis.remove(cpf);
    }

    @Override
    public String toString() {
        return this.nome + " - " + codigo + "\n- " + atividade.getNome() + "\n" + this.exibeHabilidades() + "\n(" + this.horas
                + " hora(s) executada(s))" + "\n===\n" + "Equipe: \n" + this.exibeEquipe() + "\n===\nTarefas:\n" + this.exibeTarefas();
    }

    private int calculaHorasTotais() {
        int horas = 0;
        for (Tarefa tarefa : this.tarefasGerenciadas) {
            horas += tarefa.getHoras();
        }

        return horas;
    }
    private String exibeHabilidades() {
        String saida = "";
        for (String habilidade : habilidades) {
            // TODO - Arrumar essa formatacao aqui
            saida += habilidade + ", ";
        }

        return saida;
    }

    private String exibeTarefas() {
        String saida = "";
        for (Tarefa tarefa : this.tarefasGerenciadas) {
            saida += "- " + tarefa.getNome() + " - " + tarefa.getCodigo() + "\n";
        }

        return saida;
    }

    private String exibeEquipe() {
        String saida = "";
        for (Map.Entry<String, Pessoa> pair : equipe.entrySet()) {
            saida += pair.getValue().getNome() + " - " + pair.getKey() + "\n";
        }

        return saida;
    }
}
