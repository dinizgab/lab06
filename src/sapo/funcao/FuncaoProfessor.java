package sapo.funcao;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import sapo.tarefa.heranca.TarefaAbstract;
import sapo.tarefa.heranca.TarefaGerencial;

public class FuncaoProfessor implements Funcao {

  private String siape;
  private String[] disciplinas;

  public FuncaoProfessor(String siape, String[] disciplinas) {
    this.siape = siape;
    this.disciplinas = disciplinas;
  }

  @Override
  public int calcNivel(Map<String, TarefaAbstract> tarefas, String[] habilidades) {
    int concluidasComHabilidadeOuDisciplina = 0;
    int pendente = 0;
    for (TarefaAbstract tarefa : tarefas.values()) {
      boolean ehGerencial = tarefa instanceof TarefaGerencial;
      int valorEmQuantTrf = 1;
      if (ehGerencial)
        valorEmQuantTrf = 2;

      if (tarefa.getStatus()) {
        Set<String> clone = new HashSet<>(tarefa.getHabilidades());
        List<String> habilidadesEdisciplinas = Arrays.asList(habilidades);
        habilidadesEdisciplinas.addAll(Arrays.asList(disciplinas));
        clone.retainAll(habilidadesEdisciplinas);

        if (clone.size() != 0)
          concluidasComHabilidadeOuDisciplina += valorEmQuantTrf;
      }

      pendente += valorEmQuantTrf;
    }
    return pendente / 4 + concluidasComHabilidadeOuDisciplina;
  }

  @Override
  public String toString() {
    return "Professor - " + siape + " - " + disciplinasFormatadas();
  }

  private String disciplinasFormatadas() {
    String formatada = "";
    for (int i = 0; i < disciplinas.length; i++) {
      String disciplina = disciplinas[i];
      formatada += disciplina + (i == disciplinas.length - 1 ? "" : ", ");
    }
    return formatada;
  }

}
