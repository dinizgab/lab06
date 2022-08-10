package sapo;

public class PessoaController {
    private PessoaService ps;

    public PessoaController() {
        this.ps = new PessoaService();
    }

    public void cadastraPessoa(String cpf, String nome, String[] habilidades) {
        // TODO - Provavelmente criar uma classe Validador para fazer as validacoes
        if(cpf.isBlank() || nome.isBlank()) return;

        ps.cadastraPessoa(cpf, nome, habilidades);
    }

    public String exibirPessoa(String cpf) {
        return ps.recuperaPessoa(cpf);
    }
}
