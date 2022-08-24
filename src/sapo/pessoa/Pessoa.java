package sapo.pessoa;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import sapo.funcao.Funcao;
import sapo.tarefa.heranca.TarefaAbstract;

public class Pessoa {

  private String formataHabilidades() {
    Arrays.sort(this.habilidades);
    String habilidadesFormatadas = "";

    for (String habilidade : this.habilidades) {
      habilidadesFormatadas += "- " + habilidade + "\n";
    }
    return habilidadesFormatadas;
  }

  private final String cpf;
  private String nome;
  private String[] habilidades;
  private final List<Comentario> comentarios;
  private Map<String, TarefaAbstract> trfsQueAfetamNivel;
  private Funcao func;
  private int nivel;

  public Pessoa(String cpf, String nome, String[] habilidades, Funcao func) {
    this.cpf = cpf;
    this.nome = nome;
    this.habilidades = habilidades;
    this.comentarios = new ArrayList<>();
    this.trfsQueAfetamNivel = new HashMap<>();
    this.func = func;
    this.nivel = 0;
  }

  public int getNivel() {
    if (func == null) {
      int concluidas = 0;
      for (TarefaAbstract tarefa : trfsQueAfetamNivel.values()) {
        if (tarefa.getStatus())
          concluidas++;
      }
      return trfsQueAfetamNivel.size() / 2 + concluidas + this.nivel;
    }

    return func.calcNivel(trfsQueAfetamNivel, habilidades) + this.nivel;
  }

  public void setFuncao(Funcao func) throws IllegalStateException {
    if (func == null && this.func == null) {
      throw new IllegalStateException("Não é possível remover a função da pessoa de cpf "
          + this.cpf + ", pois ela não possui função.");
    }

    if (this.func == null) {
      this.nivel += func.calcNivel(trfsQueAfetamNivel, habilidades);
      this.trfsQueAfetamNivel = new HashMap<>();
      this.func = func;
    } else if (this.func.getClass() == func.getClass()) {
      throw new IllegalStateException("Não é possível definir a função de " + func.getClass() + " para a pessoa de cpf "
          + this.cpf + ", pois ela já assume essa função.");
    }
  }

  public String[] getHabilidades() {
    return this.habilidades;
  }

  public void addTarefa(TarefaAbstract novaTarefa) {
    trfsQueAfetamNivel.put(novaTarefa.getCodigo(), novaTarefa);
  }

  public void removeTarefa(String codigo) {
    trfsQueAfetamNivel.remove(codigo);
  }

  public Map<String, TarefaAbstract> getTarefas() {
    return trfsQueAfetamNivel;
  }

  public String getNome() {
    return this.nome;
  }

  @Override
  public String toString() {
    String habilidades = formataHabilidades();
    String funcDescription = this.func != null ? this.func.toString() + "\n" : "";
    return this.nome + " - " + this.cpf + "\n" + funcDescription + habilidades;
  }
}
