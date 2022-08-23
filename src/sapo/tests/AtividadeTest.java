package sapo.tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class AtividadeTest extends BaseTest {
    private String descricao;

    @BeforeEach
    void baseNecessaria() {
        this.descricao = "Atividade de estudo de OO, considerando alunos com experiência de programação e uso da linguagem Java.";

        pc.cadastraPessoa("111.111.111-11", "Ada Lovelace", new String[]{"Programacao", "Matematica"});
        at.cadastrarAtividade("Estudar POO", descricao, "111.111.111-11");
    }

    @Test
    void testaCadastraAtividade() {
        assertEquals(at.cadastrarAtividade("Trabalho de P2", descricao, "111.111.111-11"), "TRB-1");
    }

    @Test
    void testaCadastraAtividadeNomeVazio() {
        assertThrows(IllegalArgumentException.class, () -> this.at.cadastrarAtividade("", descricao, "111.111.111-11"));
    }

    @Test
    void testaCadastraAtividadeResponsavelNulo() {
        assertThrows(IllegalArgumentException.class, () -> this.at.cadastrarAtividade("Estudar POO", descricao, null));
    }

    @Test
    void testaExibeAtividade() {
        String exibicao = "STD-0: Estudar POO\nResponsável: Ada Lovelace - 111.111.111-11\n===\n" + descricao + "\n===\nTarefas: 0/0\n";

        String atividade = this.at.exibirAtividade("STD-0");
        assertEquals(atividade, exibicao);
    }

    @Test
    void testaEncerraAtividade() {
        this.at.encerrarAtividade("STD-0");

        assertEquals("encerrada", this.at.getStatus("STD-0"));
        assertThrows(IllegalStateException.class, () -> this.at.encerrarAtividade("STD-0"));
    }

    @Test
    void testaDesativaAtividade() {
        this.at.desativarAtividade("STD-0");
        assertEquals("desativada", this.at.getStatus("STD-0"));
        assertThrows(IllegalStateException.class, () -> this.at.desativarAtividade("STD-0"));
    }

    @Test
    void testaAbreAtividade() {
        this.at.desativarAtividade("STD-0");
        this.at.reabrirAtividade("STD-0");
        assertEquals("aberta", this.at.getStatus("STD-0"));
        assertThrows(IllegalStateException.class, () -> this.at.reabrirAtividade("STD-0"));
    }

    @Test
    void testaSetDescricao() {
        String exibicao = "STD-0: Estudar POO\nResponsável: Ada Lovelace - 111.111.111-11\n===\nAlguma Descricao Aqui\n===\nTarefas: 0/0\n";
        this.at.alterarDescricaoAtividade("STD-0", "Alguma Descricao Aqui");

        assertEquals(exibicao, this.at.exibirAtividade("STD-0"));
        assertThrows(IllegalArgumentException.class, () -> this.at.alterarDescricaoAtividade("STD-0", ""));
    }

    @Test
    void testaSetResponsavel() {
        String exibicao = "STD-0: Estudar POO\nResponsável: Gabriel Diniz - 555.555.555-55\n===\n" + this.descricao + "\n===\nTarefas: 0/0\n";

        this.pc.cadastraPessoa("555.555.555-55", "Gabriel Diniz", new String[]{"Logica", "Calculo"});
        this.at.alterarResponsavelAtividade("STD-0", "555.555.555-55");

        assertEquals(exibicao, this.at.exibirAtividade("STD-0"));
        assertThrows(IllegalArgumentException.class, () -> this.at.alterarResponsavelAtividade("STD-0", ""));
    }
}
