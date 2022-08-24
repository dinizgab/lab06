package sapo.tarefa.heranca;

import sapo.tarefa.ValidadorTarefa;

import java.util.*;

public class TarefaGerencial extends TarefaAbstract {
  private Map<String, TarefaAbstract> tarefasGerenciadas;
  private int horas;
  private ValidadorTarefa validador;

  public TarefaGerencial(String nome, String codigo, String atividadeNome, Map<String, TarefaAbstract> tarefas) {
    super(nome, codigo, atividadeNome);

    this.validador = new ValidadorTarefa();
    this.tarefasGerenciadas = tarefas;
    this.habilidades = this.criaHabilidadesTotais();
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
    return this.nome + " - " + codigo + "\n- " + atividadeNome + "\n" + this.exibeHabilidades() + "\n(" + this.horas
        + " hora(s) executada(s))" + "\n===\n" + "Equipe:\n" + this.exibeEquipe() + "\n===\nTarefas:\n"
        + this.exibeTarefas();
  }

  private Set<String> criaHabilidadesTotais() {
    Set<String> habilidades = new HashSet<>();
    for (TarefaAbstract t : this.tarefasGerenciadas.values()) {
      habilidades.addAll(t.getHabilidades());
    }
    habilidades.add("gestão");
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
      saida += "- " + this.tarefasGerenciadas.get(cods).getNome() + this.tarefasGerenciadas.get(cods).getCodigo()
          + "\n";
    }

    return saida;
  }

  public void adicionaTarefaGerenciada(TarefaAbstract tarefa) {
    validador.validaCiclo(this.tarefasGerenciadas, tarefa);

    this.tarefasGerenciadas.put(tarefa.getCodigo(), tarefa);
    this.habilidades = this.criaHabilidadesTotais();
  }

  public void removeTarefaGerenciada(String codigo) {
    this.tarefasGerenciadas.remove(codigo);
    this.habilidades = this.criaHabilidadesTotais();
  }

  public int totalDeTarefas() {
    int quantTarefas = 0;
    for (TarefaAbstract tarefa : this.tarefasGerenciadas.values()) {
      if (tarefa instanceof Tarefa) {
        quantTarefas++;
      } else {
        TarefaGerencial tg = (TarefaGerencial) tarefa;
        quantTarefas += tg.totalDeTarefas();
      }
    }
    return quantTarefas;
  }
}
