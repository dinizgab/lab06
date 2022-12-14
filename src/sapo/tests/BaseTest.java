package sapo.tests;

import org.junit.jupiter.api.BeforeEach;
import sapo.SapoFacade;
import sapo.atividade.AtividadeController;
import sapo.busca.BuscaController;
import sapo.pessoa.PessoaController;
import sapo.tarefa.TarefaController;

public class BaseTest {

  protected PessoaController pc;
  protected AtividadeController at;
  protected TarefaController tc;
  protected BuscaController bc;
  protected SapoFacade facade;

  @BeforeEach
  void Base() {
    facade = new SapoFacade();
    pc = facade.getPessoaController();
    at = facade.getAtividadeController();
    tc = facade.getTarefaController();
    bc = facade.getBuscaController();
  }
}
