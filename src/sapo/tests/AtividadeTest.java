package sapo.tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class AtividadeTest extends BaseTest {
    private String descricao;
    private String exibicao;

    @BeforeEach
    void baseNecessaria() {
        this.descricao = "Atividade de estudo de OO, considerando alunos com experiência de programação e uso da linguagem Java.";
        this.exibicao = "STD-0: Estudar POO\nResponsável: Ada Lovelace - 111.111.111-11\n===\n" + descricao + "\n===\nTarefas: 0/0\n";

        pc.cadastraPessoa("111.111.111-11", "Ada Lovelace", new String[]{"Programacao", "Matematica"});
    }

    @Test
    void testaCadastraAtividade() {
        pc.cadastraPessoa("111.111.111-11", "Ada Lovelace", new String[]{"Programacao", "Matematica"});
        String atividadeCadastrada = this.at.cadastrarAtividade("Estudar POO", descricao, "111.111.111-11");

        assertEquals(atividadeCadastrada, "STD-0");
    }

    @Test
    void testaExibeAtividade() {
        this.at.cadastrarAtividade("Estudar POO", descricao, "111.111.111-11");

        String atividade = this.at.exibirAtividade("STD-0");
        assertEquals(atividade, exibicao);
    }
}
