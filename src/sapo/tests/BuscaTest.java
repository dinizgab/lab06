package sapo.tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

public class BuscaTest extends BaseTest {

    @BeforeEach
    void baseNecessaria() {
        this.pc.cadastraPessoa("111.111.111-11", "Gabriel Diniz", new String[]{"Java", "Matematica"});
        this.pc.cadastraPessoa("222.222.222-22", "Sabrina", new String[] {"Java", "Ensino"});
        this.pc.cadastraPessoa("333.333.333-33", "Joao Victor", new String[] {"Logica", "Matematica"});
    }

    @Test
    void testaBuscaPessoa() {
        List<String> resultado = this.bc.exibirPessoas("Java");
        assertEquals("Gabriel Diniz", resultado.get(0));
        assertEquals("Sabrina", resultado.get(1));
        assertEquals(2, resultado.size());
    }

    @Test
    void testaBuscaPessoaErro() {
        assertThrows(IllegalArgumentException.class, () -> this.bc.exibirPessoas(""));
    }

    @Test
    void testaBuscaAtividade() {
        this.at.cadastrarAtividade("Estudar Calculo 1", "Estudo sobre derivadas e integrais", "111.111.111-11");
        this.at.cadastrarAtividade("Fazer o laboratorio de LP2", "Terminar a parte 2 do lab6", "222.222.222-22");
        this.at.cadastrarAtividade("Testes LP2", "Fazer os testes do lab6", "333.333.333-33");

        List<String> resultado = this.bc.buscarAtividade("lab6");
        assertEquals("FZR-1", resultado.get(0));
        assertEquals("TST-2", resultado.get(1));
    }

    @Test
    void testaBuscaAtividadeErro() {
        assertThrows(IllegalArgumentException.class, () -> this.bc.buscarAtividade(""));
    }

    @Test
    void testaBuscaTarefa() {
        String esperada = "Estudar derivadas - STD-0-0\n- Estudar Calculo 1\nCalculo, Funcoes, Matematica\n(0 hora(s) executada(s))" + "\n===\n" + "Equipe:\n";
        this.at.cadastrarAtividade("Estudar Calculo 1", "Estudo sobre derivadas e integrais", "111.111.111-11");
        this.tc.cadastraTarefa("STD-0", "Estudar derivadas", new String[] {"Matematica", "Calculo", "Funcoes"});
        this.tc.cadastraTarefa("STD-0", "Estudar Integrais", new String[] {"Matematica", "Calculo", "Areas"});
        List<String> resultado = this.bc.buscarTarefas("Estudar derivadas");

        assertEquals(esperada, resultado.get(0));
    }

    @Test
    void testaBuscaTarefaErro() {
        assertThrows(IllegalArgumentException.class, () -> this.bc.buscarTarefas(""));
    }

    @Test
    void testaBuscaTarefas() {
        String esperada = "Estudar Integrais - STD-0-1\n- Estudar Calculo 1\nAreas, Calculo, Matematica\n(0 hora(s) executada(s))" + "\n===\n" + "Equipe:\n";

        this.at.cadastrarAtividade("Estudar Calculo 1", "Estudo sobre derivadas e integrais", "111.111.111-11");
        this.tc.cadastraTarefa("STD-0", "Estudar derivadas", new String[] {"Matematica", "Calculo", "Funcoes"});
        this.tc.cadastraTarefa("STD-0", "Estudar Integrais", new String[] {"Matematica", "Calculo", "Areas"});
        this.tc.cadastraTarefa("STD-0", "Estudar funcoes", new String[] {"Matematica", "Calculo", "Graficos"});
        List<String> resultado = this.bc.buscarTarefas("STD-0", "Estudar Integrais");

        assertEquals(esperada, resultado.get(0));
    }

    @Test
    void testeBuscaTarefasErro() {
        assertThrows(IllegalArgumentException.class, () -> this.bc.buscarTarefas("", ""));
        assertThrows(IllegalArgumentException.class, () -> this.bc.buscarTarefas("", "Estudar Matematica"));
        assertThrows(IllegalArgumentException.class, () -> this.bc.buscarTarefas("STD-0", ""));
    }

    @Test
    void testeBuscasMaisRecentes() {
        this.at.cadastrarAtividade("Estudar Calculo 1", "Estudo sobre derivadas e integrais", "111.111.111-11");
        this.at.cadastrarAtividade("Fazer o laboratorio de LP2", "Terminar a parte 2 do lab6", "222.222.222-22");
        this.tc.cadastraTarefa("STD-0", "Estudar derivadas", new String[] {"Matematica", "Calculo", "Funcoes"});

        List<String> resultadoBuscaPessoa = this.bc.exibirPessoas("Java");
        List<String> resultadoBuscaAtv = this.bc.buscarAtividade("lab6");
        List<String> resultadoBuscaTarefas = this.bc.buscarTarefas("Estudar derivadas");
        List<String> resultadoBuscaTarefasAtv = this.bc.buscarTarefas("STD-0", "Estudar Integrais");

        List<String> resultadoNBuscas = this.bc.buscasMaisRecentes(2);
        assertEquals(2, resultadoNBuscas.size());
    }

    @Test
    void testeGetBusca() {
        this.at.cadastrarAtividade("Estudar Calculo 1", "Estudo sobre derivadas e integrais", "111.111.111-11");
        this.at.cadastrarAtividade("Fazer o laboratorio de LP2", "Terminar a parte 2 do lab6", "222.222.222-22");

        List<String> resultadoBuscaPessoa = this.bc.exibirPessoas("Java");
        List<String> resultadoBuscaAtv = this.bc.buscarAtividade("lab6");

        List<String> resultado = this.bc.exibirHistoricoBusca(1);

        assertEquals("ATIVIDADE", resultado.get(0));
    }
}
