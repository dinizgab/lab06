package sapo.tests;


import org.junit.jupiter.api.BeforeEach;
import sapo.SapoFacade;
import sapo.atividade.AtividadeController;
import sapo.pessoa.PessoaController;
import sapo.tarefa.TarefaController;
public class BaseTest {
	
	protected PessoaController pc;
	protected AtividadeController at;
	protected TarefaController tc;
	
	@BeforeEach
	public void Base() {
		SapoFacade facade = new SapoFacade();
		PessoaController pc = facade.getPessoaController();
		AtividadeController at = facade.getAtividadeController();
		TarefaController tc = facade.getTarefaController();
		
		
		
	}
	
}
