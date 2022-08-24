package sapo.tests.tarefa.heranca;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import sapo.pessoa.Pessoa;
import sapo.tarefa.heranca.Tarefa;
import sapo.tarefa.heranca.TarefaAbstract;

public class TarefaAbstractTest {
  TarefaAbstract t;

  @BeforeEach
  public void setUp() {
    Set<String> habilidades = new HashSet<>();
    habilidades.add("Meu deus");
    habilidades.add("Me ajuda");
    this.t = new Tarefa("Acaba por favor", "SCR-0-0", "SOCORRO", habilidades);
  }

  @Test
  void testAdicionaHoras() {
    t.adicionaHoras(3);
    assertEquals(3, t.getHoras());
  }

  @Test
  void testAdicionaResponsavel() {
    Pessoa p = new Pessoa("111.111.111-11", "Matheus Gaudencio do Rêgonome", new String[] { "eita", "ui" }, null);
    t.adicionaResponsavel(p);
    assertEquals(p, t.getResponsaveis().get("111.111.111-11"));
  }

  @Test
  void testConcluiTarefa() {
    t.concluiTarefa();
    assertTrue(t.getStatus());
  }

  @Test
  void testEquals() {
    TarefaAbstract otherT = new Tarefa("a", "SCR-0-1", "SOCORRO", new HashSet<>());
    assertTrue(t.equals(t));
    assertFalse(t.equals(null));
    assertFalse(t.equals(otherT));
  }

  @Test
  void testRemoveHoras() {
    t.adicionaHoras(8);
    t.removeHoras(8);
    assertEquals(0, t.getHoras());
  }

  @Test
  void testRemoveResponsavel() {
    Pessoa p = new Pessoa("111.111.111-11", "Matheus Gaudencio do Rêgonome", new String[] { "eita", "ui" }, null);
    t.adicionaResponsavel(p);
    t.removeResponsavel("111.111.111-11");
    assertEquals(0, t.getResponsaveis().size());
  }

  @Test
  void testSetNome() {
    t.setNome("opa");
    assertTrue(t.getNome().equals("opa"));
    t.concluiTarefa();
    t.setNome("eita");
    assertTrue(t.getNome().equals("opa"));
  }
}
