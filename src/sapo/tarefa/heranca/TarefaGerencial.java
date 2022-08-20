package sapo.tarefa.heranca;

import sapo.atividade.Atividade;
import sapo.tarefa.ValidadorTarefa;

import java.util.*;

public class TarefaGerencial extends TarefaAbstract{
    private Set<String> habilidades;
    private Map<String, TarefaAbstract> tarefasGerenciadas;
    private int horas;
    private ValidadorTarefa validador;

    public TarefaGerencial(String nome, String codigo, Atividade atividade, Set<String> habilidades, Map<String, TarefaAbstract> tarefas) {
        super(nome, codigo, atividade);

        this.validador = new ValidadorTarefa();
        this.tarefasGerenciadas = tarefas;
        this.habilidades = this.criaHabilidadesTotais(habilidades);
        this.horas = this.calculaHorasTotais();
    }

    @Override
    public void concluiTarefa() {
        for (TarefaAbstract t : this.tarefasGerenciadas.values()) {
            t.concluiTarefa();
        }
        this.concluida = true;
    }

    @Override
    public String toString() {
        return this.nome + " - " + codigo + "\n- " + atividade.getNome() + "\n" + this.exibeHabilidades() + "\n(" + this.horas
                + " hora(s) executada(s))" + "\n===\n" + "Equipe:\n" + this.exibeEquipe() + "\n===\nTarefas:\n" + this.exibeTarefas();
    }

    private Set<String> criaHabilidadesTotais(Set<String> habilidades) {
        for (TarefaAbstract t : this.tarefasGerenciadas.values()) {
            habilidades.addAll(t.getHabilidades());
        }
        return habilidades;
    }

    private int calculaHorasTotais() {
        int horas = 0;
        for (TarefaAbstract t : this.tarefasGerenciadas.values()) {
            horas += t.getHoras();
        }

        return horas;
    }

    private String exibeTarefas() {
        List<String> listaCodigos = new ArrayList<>(this.tarefasGerenciadas.keySet());
        listaCodigos.sort(Collections.reverseOrder());

        String saida = "";
        for (String cods : listaCodigos) {
            saida += "- " + this.tarefasGerenciadas.get(cods).getNome() + this.tarefasGerenciadas.get(cods).getCodigo() + "\n";
        }

        return saida;
    }

    public void adicionaTarefaGerenciada(TarefaAbstract tarefa) {
        validador.validaCiclo(this.tarefasGerenciadas, tarefa);

        this.tarefasGerenciadas.put(tarefa.getCodigo(), tarefa);
        this.criaHabilidadesTotais(this.habilidades);
    }

    public void removeTarefaGerenciada(String codigo) {
        this.tarefasGerenciadas.remove(codigo);
        this.criaHabilidadesTotais(this.habilidades);
    }

    public int totalDeTarefas() {
        return this.tarefasGerenciadas.size();
    }
}
