package sapo.tarefa;

import sapo.atividade.AtividadeService;
import sapo.pessoa.PessoaService;

public class TarefaService {
    private AtividadeService as;
    private PessoaService ps;

    public TarefaService(PessoaService ps, AtividadeService as) {
        this.as = as;
        this.ps = ps;
    }
}
