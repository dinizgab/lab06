package sapo.pessoa;

public class PessoaController {
    private PessoaService ps;

    public PessoaController(PessoaService ps) {
        this.ps = ps;
    }

    public void cadastraPessoa(String cpf, String nome, String[] habilidades) {
        // TODO - Provavelmente criar uma classe Validador para fazer as validacoes
        if(cpf.isBlank() || nome.isBlank()) return;

        ps.cadastraPessoa(cpf, nome, habilidades);
    }

    public String exibirPessoa(String cpf) {
        return ps.recuperaPessoa(cpf);
    }

    public void alterarNome(String cpf, String novoNome) {
        // TODO - Provavelmente criar uma classe Validador para fazer as validacoes
        if(novoNome.isBlank()) return;
        ps.alteraNome(cpf, novoNome);   
    }
}