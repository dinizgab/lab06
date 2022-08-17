package sapo.tarefa.heranca;

import sapo.atividade.Atividade;
import sapo.pessoa.Pessoa;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

// TODO - Cadastro de tarefas normais e tarefas gerenciadas
// TODO - Maneira de checar se está ocorrendo loop de cadastro de tarefas gerenciais

public class TarefaGerencial extends TarefaAbstract{
    private Set<String> habilidades;
    private Map<String, Pessoa> responsaveis;
    private Set<TarefaInterface> tarefasGerenciadas;
    private int horas;
    private boolean concluida;

    public TarefaGerencial(String nome, String codigo, Atividade atividade, Set<String> habilidades, Set<TarefaInterface> tarefas) {
        super(nome, codigo, atividade);

        this.responsaveis = new HashMap<>();
        this.tarefasGerenciadas = tarefas;
        this.habilidades = this.criaHabilidadesTotais(habilidades);
        this.horas = this.calculaHorasTotais();
        this.concluida = false;
    }

    @Override
    public void setHabilidades(Set<String> habilidades) {
        if (this.concluida) return;
        this.habilidades.addAll(habilidades);
    }

    @Override
    public void concluiTarefa() {
        for (TarefaInterface t : this.tarefasGerenciadas) {
            t.concluiTarefa();
        }
        this.concluida = true;
    }

    @Override
    public String toString() {
        return this.nome + " - " + codigo + "\n- " + /*atividade.getNome() + */"\n" + this.exibeHabilidades() + "\n(" + this.horas
                + " hora(s) executada(s))" + "\n===\n" + "Equipe: \n" + this.exibeEquipe() + "\n===\nTarefas:\n" + this.exibeTarefas();
    }

    private Set<String> criaHabilidadesTotais(Set<String> habilidades) {
        for (TarefaInterface t : this.tarefasGerenciadas) {
            habilidades.addAll(t.getHabilidades());
        }
        return habilidades;
    }

    private int calculaHorasTotais() {
        int horas = 0;
        for (TarefaInterface t : this.tarefasGerenciadas) {
            horas += t.getHoras();
        }

        return horas;
    }

    private String exibeTarefas() {
        // TODO - Arrumar um jeito de formatar da tarefa mais nova para a mais antiga
        String saida = "";
        for (TarefaInterface t : this.tarefasGerenciadas) {
            saida += "- " + t.getNome() + " - " + t.getCodigo() + "\n";
        }

        return saida;
    }
}