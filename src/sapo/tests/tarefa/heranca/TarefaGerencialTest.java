package sapo.tests.tarefa.heranca;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import sapo.pessoa.Pessoa;
import sapo.tarefa.heranca.Tarefa;
import sapo.tarefa.heranca.TarefaAbstract;
import sapo.tarefa.heranca.TarefaGerencial;

public class TarefaGerencialTest {
  TarefaGerencial tg;
  Tarefa trf;

  @BeforeEach
  public void setEnvironmentUp() {
    this.tg = new TarefaGerencial("Testar Tarefa", "LBX-4-0", "LAB06", new HashMap<>());
    this.trf = new Tarefa("Opa, Jão", "FST-0-1", "Festa hoje",
        Arrays.stream(new String[] { "hábil", "rápido" }).collect(Collectors.toSet()));
    Pessoa p = new Pessoa("111.111.111-11", "Matheus Gaudencio do Rêgo", new String[] {}, null);
    tg.adicionaHoras(3);
    tg.adicionaResponsavel(p);
  }

  @Test
  void testAdicionaTarefaGerenciada() {
    tg.adicionaTarefaGerenciada(trf);
    assertEquals(1, tg.totalDeTarefas());
  }

  @Test
  void testEvitaCiclo() {
    assertThrows(IllegalArgumentException.class, () -> tg.adicionaTarefaGerenciada(tg));
    TarefaGerencial tg2 = new TarefaGerencial("Sei lá", "TRY-0-0", "Testeando", new HashMap<>());
    TarefaGerencial tg3 = new TarefaGerencial("Sei lá", "TRP-0-0", "Testeando", new HashMap<>());
    tg.adicionaTarefaGerenciada(tg2);
    tg2.adicionaTarefaGerenciada(tg3);
    assertThrows(IllegalArgumentException.class, () -> tg3.adicionaTarefaGerenciada(tg));
  }

  @Test
  void testConcluiTarefa() {
    Tarefa t3 = new Tarefa("Teste3", "TVD-1-1", "Atividade fictícia",
        new HashSet<>(Arrays.asList(new String[] { "alto" })));
    Map<String, TarefaAbstract> tarefas = new HashMap<>();
    tarefas.put(t3.getCodigo(), t3);
    TarefaGerencial t4 = new TarefaGerencial("Teste4", "PPX-3-0", "Au Au Papai", tarefas);
    tg.adicionaTarefaGerenciada(trf);
    tg.adicionaTarefaGerenciada(t4);
    tg.concluiTarefa();
    assertTrue(trf.getStatus());
    assertTrue(t3.getStatus());
    assertTrue(t4.getStatus());
  }

  @Test
  void testRemoveTarefaGerenciada() {
    assertEquals(0, tg.totalDeTarefas());

    tg.adicionaTarefaGerenciada(trf);
    assertEquals(1, tg.totalDeTarefas());

    tg.removeTarefaGerenciada(trf.getCodigo());
    assertEquals(0, tg.totalDeTarefas());
  }

  @Test
  void testToString() {
    tg.adicionaTarefaGerenciada(trf);
    String esperado = "Testar Tarefa - LBX-4-0\n" +
        "- LAB06\n" +
        "gestão, rápido, hábil\n" +
        "(3 hora(s) executada(s))\n" +
        "===\n" +
        "Equipe:\n" +
        "Matheus Gaudencio do Rêgo - 111.111.111-11\n" +
        "===\n" +
        "Tarefas:\n" +
        "- Opa, Jão - FST-0-1\n";
    assertEquals(esperado, tg.toString());
  }

  @Test
  void testTotalDeTarefas() {
    Map<String, TarefaAbstract> tarefas1 = new HashMap<>();
    Map<String, TarefaAbstract> tarefas2 = new HashMap<>();
    Set<String> habilidades = new HashSet<>();
    habilidades.addAll(Arrays.asList(new String[] { "cheiroso", "gente boa", "forte", "javascript" }));

    Tarefa t1 = new Tarefa("Teste1", "FST-0-0", "Festa hoje", habilidades);
    Tarefa t2 = new Tarefa("Teste2", "TVD-1-0", "Atividade fictícia", habilidades);
    Tarefa t3 = new Tarefa("Teste3", "TVD-1-1", "Atividade fictícia",
        new HashSet<>(Arrays.asList(new String[] { "alto" })));
    tarefas1.put(t3.getCodigo(), t3);
    TarefaGerencial t4 = new TarefaGerencial("Teste4", "PPX-3-0", "Au Au Papai", tarefas1);
    tarefas2.put(t4.getCodigo(), t4);
    tarefas2.put(t2.getCodigo(), t2);
    TarefaGerencial t5 = new TarefaGerencial("Teste5", "MMP-2-0", "Miau Miau Papai", tarefas2);
    tg.adicionaTarefaGerenciada(t1);
    tg.adicionaTarefaGerenciada(t5);
    assertEquals(3, tg.totalDeTarefas());
  }
}
