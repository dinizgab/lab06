package sapo.tarefa.heranca;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Set;

public class Tarefa extends TarefaAbstract {

  /**
   * cria uma tarefa definindo seu codigo, nome, habilidade e a atividade a qual
   * esta relacionada.
   *
   * @param codigo      codigo da tarefa
   * @param nome        nome da tarefa
   * @param habilidades habilidades recomendadas da tarefa
   * @param atividade   atividade relacionada
   */
  public Tarefa(String nome, String codigo, String atividadeNome, Set<String> habilidades) {
    super(nome, codigo, atividadeNome);
    this.habilidades = habilidades;
  }

  @Override
  public String toString() {
    return this.nome + " - " + codigo + "\n- " + atividadeNome + "\n" + this.exibeHabilidades() + "\n("
        + this.horas
        + " hora(s) executada(s))" + "\n===\n" + "Equipe:\n" + this.exibeEquipe();
  }

  /**
   * define as habilidades recomendadas da tarefa.
   *
   * @param habilidades habilidades da tarefa.
   */
  public void setHabilidades(Set<String> habilidades) {
    if (this.concluida)
      return;
    this.habilidades = habilidades;
  }

  @Override
  protected String exibeHabilidades() {
    ArrayList<String> habilidadesList = new ArrayList<>(this.habilidades);
    Collections.sort(habilidadesList);
    String listString = habilidadesList.toString();

    return listString.substring(1, listString.length() - 1);
  }

  public Set<String> getHabilidades() {
    return this.habilidades;
  }
}
