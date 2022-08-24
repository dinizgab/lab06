package sapo.tests.tarefa.heranca;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import sapo.pessoa.Pessoa;
import sapo.tarefa.heranca.Tarefa;
import sapo.tests.BaseTest;

public class TarefaTest extends BaseTest {
  Tarefa t;

  @BeforeEach
  public void setEnvironmentUp() {
    Set<String> habilidades = new HashSet<String>();
    habilidades.add("legal");
    habilidades.add("LP2");
    this.t = new Tarefa("Testar Tarefa", "LBX-0-0", "LAB06", habilidades);
    this.t.adicionaHoras(8);
    Pessoa p1 = new Pessoa("222.2222.222-22", "Ingrid Xpto", new String[] {}, null);
    Pessoa p2 = new Pessoa("111.111.111-11", "Matheus Gaudencio do Rêgo", new String[] {}, null);
    this.t.adicionaResponsavel(p1);
    this.t.adicionaResponsavel(p2);
  }

  @Test
  void testSetHabilidades() {
    Set<String> novasHabilidades = new HashSet<String>();
    novasHabilidades.add("complicado");
    novasHabilidades.add("cansadito");
    t.setHabilidades(novasHabilidades);
    assertArrayEquals(novasHabilidades.toArray(new String[] {}), t.getHabilidades().toArray(new String[] {}));
  }

  @Test
  void testToString() {
    String esperado = "Testar Tarefa - LBX-0-0\n" +
        "- LAB06\n" +
        "LP2, legal\n" +
        "(8 hora(s) executada(s))\n" +
        "===\n" +
        "Equipe:\n" +
        "Matheus Gaudencio do Rêgo - 111.111.111-11\n" +
        "Ingrid Xpto - 222.2222.222-22\n";
    assertEquals(esperado, t.toString());
  }
}
