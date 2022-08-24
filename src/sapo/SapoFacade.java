package sapo;

import sapo.atividade.AtividadeController;
import sapo.atividade.AtividadeRepository;
import sapo.atividade.AtividadeService;
import sapo.busca.BuscaController;
import sapo.busca.BuscaRepository;
import sapo.busca.BuscaService;
import sapo.pessoa.PessoaController;
import sapo.pessoa.PessoaService;
import sapo.tarefa.TarefaController;
import sapo.tarefa.TarefaRepository;

public class SapoFacade {
    private final PessoaController pc;
    private final AtividadeController ac;
    private final TarefaController tc;
    private final BuscaController bc;

    public SapoFacade() {
        TarefaRepository tr = new TarefaRepository();
        AtividadeRepository ar = new AtividadeRepository();
        BuscaRepository br = new BuscaRepository();
        PessoaService ps = new PessoaService();
        AtividadeService as = new AtividadeService(ps, ar);
        BuscaService bs = new BuscaService(br);

        this.ac = new AtividadeController(as);
        this.tc = new TarefaController(as, ps, tr);
        this.pc = new PessoaController(ps, ac, tc);
        this.bc = new BuscaController(bs, ps, ar, tc);
    }

	public PessoaController getPessoaController() {
		return pc;
	}

	public AtividadeController getAtividadeController() {
		return ac;
	}

	public TarefaController getTarefaController() {
		return tc;
	}

    public BuscaController getBuscaController() { return bc;
    }
}
