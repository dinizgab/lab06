package sapo;

public class SapoFacade {
    private PessoaController pc;
    private AtividadeController ac;
    private TarefaController tc;

    public SapoFacade() {
        this.pc = new PessoaController();
        this.ac = new AtividadeController();
        this.tc = new TarefaController();
    }
}
