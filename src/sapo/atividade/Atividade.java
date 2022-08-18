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

public class Atividade {
  private String codigo;
  private String nome;
  private String descricao;
  private Pessoa responsavel;
  private String status;
  private Map<String, TarefaAbstract> tarefas;

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

  private boolean argumentoEhValido(String arg) {
    return !(arg.isBlank() || arg == null);
  }

  public void encerrar() throws IllegalStateException {
    if (quantTarefasPendentes() != 0)
      throw new IllegalStateException("Não é possível encerrar uma atividade com tarefas pendentes.");

    if (!this.status.equals("aberta"))
      throw new IllegalStateException("Não é possível encerrar uma atividade que não esteja aberta.");

    this.status = "encerrada";
  }

  public void desativar() throws IllegalStateException {
    if (quantTarefasPendentes() != 0)
      throw new IllegalStateException("Não é possível desativar uma atividade com tarefas pendentes.");

    if (!this.status.equals("aberta"))
      throw new IllegalStateException("Não é possível desativar uma atividade que não esteja aberta.");

    this.status = "desativada";
  }

  public void reabrir() throws IllegalStateException {
    if (this.status.equals("aberta"))
      throw new IllegalStateException("Não é possível reabrir uma atividade já aberta.");

    this.status = "aberta";
  }

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

  public void setDescricao(String descricao) throws IllegalArgumentException {
    if (!argumentoEhValido(descricao))
      throw new IllegalArgumentException("Descrição da atividade não pode ser vazia ou nula.");

    this.descricao = descricao;
  }

  public void setResponsavel(Pessoa novoResponsavel) throws IllegalArgumentException {
    if (novoResponsavel == null)
      throw new IllegalArgumentException("Responsável não pode ser nulo.");

    this.responsavel = novoResponsavel;
  }

  public void adicionarTarefa(TarefaAbstract tarefa) throws IllegalStateException, IllegalArgumentException {
    if (this.status.equals("desativada") || this.status.equals("encerrada"))
      throw new IllegalStateException("Não é possível adicionar tarefas em uma atividade " + this.status + ".");
    if (tarefa == null)
      throw new IllegalArgumentException("Tarefa não pode ser nula.");

    this.tarefas.put(this.codigo + "-" + (this.tarefas.size() - 1), tarefa);
  }
}
