package sapo;

import sapo.atividade.AtividadeController;
import sapo.atividade.AtividadeRepository;
import sapo.atividade.AtividadeService;
import sapo.pessoa.PessoaController;
import sapo.pessoa.PessoaService;
import sapo.tarefa.TarefaController;
import sapo.tarefa.TarefaRepository;

public class SapoFacade {
    private final PessoaController pc;
    private final AtividadeController ac;
    private final TarefaController tc;

    public SapoFacade() {
        TarefaRepository tr = new TarefaRepository();
        AtividadeRepository ar = new AtividadeRepository();
        PessoaService ps = new PessoaService();
        AtividadeService as = new AtividadeService(ps, ar);

        this.ac = new AtividadeController(as);
        this.tc = new TarefaController(as, ps, tr);
        this.pc = new PessoaController(ps, ac, tc);
    }
}
