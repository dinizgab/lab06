package sapo.funcao;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import sapo.tarefa.heranca.TarefaAbstract;
import sapo.tarefa.heranca.TarefaGerencial;

public class FuncaoAluno implements Funcao {

  private String matricula;
  private int periodo;

  public FuncaoAluno(String matricula, int periodo) {
    this.matricula = matricula;
    this.periodo = periodo;
  }

  @Override
  public int calcNivel(Map<String, TarefaAbstract> tarefas, String[] habilidades) {
    int concluidas = 0;
    int concluidasComHabilidade = 0;
    int pendente = 0;
    for (TarefaAbstract tarefa : tarefas.values()) {
      boolean ehGerencial = tarefa instanceof TarefaGerencial;
      int valorEmQuantTrf = 1;
      if (ehGerencial)
        valorEmQuantTrf = 2;

      if (tarefa.getStatus()) {
        Set<String> clone = new HashSet<>(tarefa.getHabilidades());
        clone.retainAll(Arrays.asList(habilidades));

        if (clone.size() != 0)
          concluidasComHabilidade += valorEmQuantTrf;
        else
          concluidas += valorEmQuantTrf;
      }

      pendente += valorEmQuantTrf;

    }
    return pendente / 2 + (int) Math.ceil(1.5 * concluidasComHabilidade) + concluidas;
  }

  @Override
  public String toString() {
    return "Aluno - " + matricula + " - " + periodo;
  }

}
