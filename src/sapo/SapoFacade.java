package sapo;

import sapo.atividade.AtividadeController;
import sapo.atividade.AtividadeService;
import sapo.pessoa.PessoaController;
import sapo.pessoa.PessoaService;
import sapo.tarefa.TarefaController;
import sapo.tarefa.TarefaService;

public class SapoFacade {
    private final PessoaController pc;
    private final AtividadeController ac;
    private final TarefaController tc;

    public SapoFacade() {
        PessoaService ps = new PessoaService();
        AtividadeService as = new AtividadeService(ps);
        TarefaService ts = new TarefaService(ps, as);

        this.pc = new PessoaController(ps);
        this.ac = new AtividadeController(as);
        this.tc = new TarefaController(ts);
    }
}
