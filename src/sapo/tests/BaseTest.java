package sapo.tests;


import org.junit.jupiter.api.BeforeEach;
import sapo.SapoFacade;
import sapo.atividade.AtividadeController;
import sapo.pessoa.PessoaController;
import sapo.tarefa.TarefaController;
class BaseTest {
	
	protected PessoaController pc;
	protected AtividadeController at;
	protected TarefaController tc;
	protected SapoFacade facade;
	
	@BeforeEach
	void Base() {
		facade = new SapoFacade();
		pc = facade.getPessoaController();
		at = facade.getAtividadeController();
		tc = facade.getTarefaController();

	}
	
}
