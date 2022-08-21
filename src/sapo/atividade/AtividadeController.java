package sapo.atividade;

public class AtividadeController {
    private AtividadeService as;

    public AtividadeController(AtividadeService as) {
        this.as = as;
    }

    public String cadastrarAtividade(String nome, String descricao, String cpf) {
        return this.as.cadastrarAtividade(nome, descricao, cpf);
    }

    public void encerrarAtividade(String atividadeId) {
        this.as.encerrarAtividade(atividadeId);
    }

    public void desativarAtividade(String atividadeId) {
        this.as.desativarAtividade(atividadeId);
    }

    public void reabrirAtividade(String atividadeId) {
        this.as.reabrirAtividade(atividadeId);
    }

    public String exibirAtividade(String atividadeId) {
        return this.as.exibirAtividade(atividadeId);
    }

    public void alterarDescricaoAtividade(String atividadeId, String descricao) {
        this.as.alterarDescricaoAtividade(atividadeId, descricao);
    }

    public void alterarResponsavelAtividade(String atividadeId, String cpf) {
        this.as.alterarResponsavelAtividade(atividadeId, cpf);
    }

    public void removerPessoaAtividaceLGPD(String cpf) {
        as.removeResponsavelAtividadeLGPD(cpf);
    }
}
