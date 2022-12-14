package sapo.tarefa.heranca;

import sapo.pessoa.Pessoa;

import java.util.*;

public abstract class TarefaAbstract {
  protected String nome;
  protected String codigo;
  protected Set<String> habilidades;
  protected Map<String, Pessoa> responsaveis;
  protected int horas;
  protected boolean concluida;
  protected String atividadeNome;

  public TarefaAbstract(String nome, String codigo, String atividadeNome) {
    this.nome = nome;
    this.codigo = codigo;
    this.atividadeNome = atividadeNome;
    this.responsaveis = new HashMap<>();
    this.concluida = false;
  }

  /**
   * recupera o código da tarefa.
   *
   * @return String que representa o código da tarefa
   */
  public String getCodigo() {
    return this.codigo;
  }

  public String getNome() {
    return this.nome;
  }

  /**
   * define o nome da tarefa.
   *
   * @param nome nome da tarefa.
   */
  public void setNome(String nome) {
    if (this.concluida)
      return;
    this.nome = nome;
  }

  /**
   * adiciona horas a uma tarefa.
   *
   * @param horas horas a serem adicionadas.
   */
  public void adicionaHoras(int horas) {
    this.horas += horas;
  }

  /**
   * remove horas de uma terefa.
   *
   * @param horas horas a serem removidas.
   */
  public void removeHoras(int horas) {
    this.horas -= horas;
  }

  /**
   * recupera o status da tarefa.
   *
   * @return status da tarefa.
   */
  public boolean getStatus() {
    return this.concluida;
  }

  public int getHoras() {
    return this.horas;
  }

  public Set<String> getHabilidades() {
    return this.habilidades;
  }

  /**
   * adiciona uma pessoa responsável a tarefa.
   *
   * @param pessoa pessoa a ser adicionada
   */
  public void adicionaResponsavel(Pessoa pessoa) {
    this.responsaveis.put(pessoa.getCpf(), pessoa);
  }

  /**
   * remove uma pessoa responsável a partir do seu cpf.
   *
   * @param cpf cpf da pessoa a ser removida.
   */
  public void removeResponsavel(String cpf) {
    this.responsaveis.remove(cpf);
  }

  /**
   * conclui uma tarefa.
   */
  public void concluiTarefa() {
    this.concluida = true;
  }

  @Override
  public boolean equals(Object o) {
    if (!(o instanceof TarefaAbstract))
      return false;
    return ((TarefaAbstract) o).getCodigo().equals(this.codigo);
  }

  protected String exibeEquipe() {
    String saida = "";
    for (Map.Entry<String, Pessoa> pair : this.responsaveis.entrySet()) {
      saida += pair.getValue().getNome() + " - " + pair.getKey() + "\n";
    }

    return saida;
  }

  protected String exibeHabilidades() {
    String setString = this.habilidades.toString();

    return setString.substring(1, setString.length() - 1);
  }

  public List<Pessoa> getResponsaveisComparacao() {
    return new ArrayList<>(this.responsaveis.values());
  }

  public Map<String, Pessoa> getResponsaveis() {
    return this.responsaveis;
  }

}
