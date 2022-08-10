package sapo;

public class PessoaController {
    private PessoaService ps;

    public PessoaController() {
        this.ps = new PessoaService();
    }

    public void cadastraPessoa(String cpf, String nome, String[] habilidades) {
        if(cpf.isBlank() || nome.isBlank()) return;

        ps.cadastraPessoa(cpf, nome, habilidades);
    }
}
