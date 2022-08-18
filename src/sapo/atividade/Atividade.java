package sapo.atividade;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import sapo.pessoa.Pessoa;
import sapo.tarefa.heranca.TarefaAbstract;

/**
 * Entidade utilizada para representação de uma atividade.
 * 
 * @author João Victor de Souza Lucena
 */
public class Atividade {
  private String codigo;
  private String nome;
  private String descricao;
  private Pessoa responsavel;
  private String status;
  private Map<String, TarefaAbstract> tarefas;

  /**
   * 
   * @param codigo      Código da atividade.
   * @param nome        Nome da atividade.
   * @param descricao   Descrição da atividade.
   * @param responsavel Pessoa responsável por essa atividade.
   * @throws IllegalArgumentException Levanta erro caso o nome, a descrição ou o
   *                                  responsável sejam inválidos (nulo ou vazio).
   */
  public Atividade(String codigo, String nome, String descricao, Pessoa responsavel) throws IllegalArgumentException {
    if (!argumentoEhValido(nome) || !argumentoEhValido(descricao))
      throw new IllegalArgumentException("Nome e descrição da atividade não podem ser vazios ou nulos.");
    if (responsavel == null)
      throw new IllegalArgumentException("Responsável não pode ser nulo.");

    this.codigo = codigo;
    this.nome = nome;
    this.descricao = descricao;
    this.responsavel = responsavel;
    this.status = "aberta";
    this.tarefas = new HashMap<>();
  }

  /**
   * Valida o argumento para garantir que ele não é nulo nem vazio.
   * 
   * @param arg Argumento a ser validado.
   * @return true se for válido, falso se não.
   */
  private boolean argumentoEhValido(String arg) {
    return !(arg.isBlank() || arg == null);
  }

  /**
   * Altera o estado da atividade para "encerrada".
   * 
   * @throws IllegalStateException Levanta erro caso a atividade não esteja aberta
   *                               ao tentar encerrá-la ou caso haja tarefas
   *                               pendentes.
   */
  public void encerrar() throws IllegalStateException {
    if (quantTarefasPendentes() != 0)
      throw new IllegalStateException("Não é possível encerrar uma atividade com tarefas pendentes.");

    if (!this.status.equals("aberta"))
      throw new IllegalStateException("Não é possível encerrar uma atividade que não esteja aberta.");

    this.status = "encerrada";
  }

  /**
   * Altera o estado da atividade para "desativada".
   * 
   * @throws IllegalStateException Levanta erro caso a atividade não esteja aberta
   *                               ao tentar encerrá-la ou caso haja tarefas
   *                               pendentes.
   */
  public void desativar() throws IllegalStateException {
    if (quantTarefasPendentes() != 0)
      throw new IllegalStateException("Não é possível desativar uma atividade com tarefas pendentes.");

    if (!this.status.equals("aberta"))
      throw new IllegalStateException("Não é possível desativar uma atividade que não esteja aberta.");

    this.status = "desativada";
  }

  /**
   * Altera o estado da atividade para "aberta".
   * 
   * @throws IllegalStateException Levanta erro caso a atividade não esteja
   *                               "encerrada" ou "desativada".
   */
  public void reabrir() throws IllegalStateException {
    if (this.status.equals("aberta"))
      throw new IllegalStateException("Não é possível reabrir uma atividade já aberta.");

    this.status = "aberta";
  }

  /**
   * @return Quantidade de tarefas pendentes na atividade.
   */
  private int quantTarefasPendentes() {
    int quant = 0;
    for (String chave : this.tarefas.keySet()) {
      TarefaAbstract tarefa = this.tarefas.get(chave);
      boolean naoConcluida = !tarefa.getStatus();
      if (naoConcluida)
        quant += 1;
    }
    return quant;
  }

  /**
   * @return Set com as tarefas da atividade.
   */
  public Set<TarefaAbstract> getTarefas() {
    return this.tarefas.values().stream().collect(Collectors.toSet());
  }

  @Override
  public String toString() {
    String result = codigo + ": " + this.nome + "\n";
    result += "Responsável: " + this.responsavel.toString().split("\n")[0] + "\n";
    result += "===\n";
    result += this.descricao + "\n";
    result += "===\n";

    int tarefasConcluidas = this.tarefas.size() - quantTarefasPendentes();
    result += "Tarefas: " + tarefasConcluidas + "/" + this.tarefas.size() + "\n";

    List<TarefaAbstract> ultimasTarefasPendentes = getUltimasTarefasPendentes(3);
    for (int i = 0; i < ultimasTarefasPendentes.size(); i++) {
      TarefaAbstract tarefa = ultimasTarefasPendentes.get(i);
      result += "- " + tarefa.toString().split("\n")[0] + (i == ultimasTarefasPendentes.size() - 1 ? "" : "\n");
    }

    return result;
  }

  /**
   * @param maxQuant Quantidade máxima de últimas tarefas pendentes a ser
   *                 retornada.
   * @return Tarefas mais recentes que ainda não foram concluídas.
   */
  private List<TarefaAbstract> getUltimasTarefasPendentes(int maxQuant) {
    List<TarefaAbstract> retorno = new ArrayList<TarefaAbstract>();
    List<String> listaChaves = new ArrayList<>(this.tarefas.keySet());
    Collections.sort(listaChaves, Collections.reverseOrder());

    for (String chave : listaChaves) {
      if (retorno.size() == maxQuant)
        break;

      TarefaAbstract tarefa = this.tarefas.get(chave);
      boolean naoConcluida = !tarefa.getStatus();
      if (naoConcluida)
        retorno.add(tarefa);
    }
    return retorno;
  }

  /**
   * Uma validação do parâmetro descrição será efetuada ao tentar definir uma nova
   * descrição.
   * 
   * @param descricao Novo valor para a descrição.
   * @throws IllegalArgumentException Levanta erro caso a nova descrição seja
   *                                  vazia ou nula.
   */
  public void setDescricao(String descricao) throws IllegalArgumentException {
    if (!argumentoEhValido(descricao))
      throw new IllegalArgumentException("Descrição da atividade não pode ser vazia ou nula.");

    this.descricao = descricao;
  }

  /**
   * @param novoResponsavel Novo responsável.
   * @throws IllegalArgumentException Levanta erro caso o novo responsável seja
   *                                  nulo.
   */
  public void setResponsavel(Pessoa novoResponsavel) throws IllegalArgumentException {
    if (novoResponsavel == null)
      throw new IllegalArgumentException("Responsável não pode ser nulo.");

    this.responsavel = novoResponsavel;
  }

  /**
   * @param tarefa Tarefa para ser adicionada.
   * @throws IllegalStateException    Levanta erro caso a atividade não esteja com
   *                                  status de "aberta".
   * @throws IllegalArgumentException Levanta erro caso a tarefa seja nula.
   */
  public void adicionarTarefa(TarefaAbstract tarefa) throws IllegalStateException, IllegalArgumentException {
    if (this.status.equals("desativada") || this.status.equals("encerrada"))
      throw new IllegalStateException("Não é possível adicionar tarefas em uma atividade " + this.status + ".");
    if (tarefa == null)
      throw new IllegalArgumentException("Tarefa não pode ser nula.");

    this.tarefas.put(this.codigo + "-" + (this.tarefas.size() - 1), tarefa);
  }
}
