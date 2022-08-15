package sapo;

import sapo.atividade.AtividadeController;
import sapo.atividade.AtividadeService;
import sapo.pessoa.PessoaController;
import sapo.pessoa.PessoaService;
import sapo.tarefa.TarefaController;
import sapo.tarefa.TarefaRepository;
import sapo.tarefa.TarefaService;

public class SapoFacade {
    private final PessoaController pc;
    private final AtividadeController ac;
    private final TarefaController tc;

    public SapoFacade() {
        TarefaRepository tr = new TarefaRepository();
        PessoaService ps = new PessoaService();
        AtividadeService as = new AtividadeService(ps);
        TarefaService ts = new TarefaService(as, ps, tr);

        this.pc = new PessoaController(ps);
        this.ac = new AtividadeController(as);
        this.tc = new TarefaController(ts);
    }
}
