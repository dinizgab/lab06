package sapo.pessoa;

public class PessoaController {
    private PessoaService ps;
    private ValidadorPessoa validador;

    public PessoaController(PessoaService ps) {
        this.ps = ps;
        this.validador = new ValidadorPessoa();
    }

    public void cadastraPessoa(String cpf, String nome, String[] habilidades) {
        this.validador.validacao(cpf);
        this.validador.validacao(nome);
        ps.cadastraPessoa(new Pessoa(cpf, nome, habilidades));
    }

    public String exibirPessoa(String cpf) {
        return ps.recuperaPessoa(cpf);
    }

    public void alterarNome(String cpf, String novoNome) {
        this.validador.validacao(novoNome);
        ps.alteraNome(cpf, novoNome);   
    }

    public void alterarHabilidadesPessoa(String cpf, String[] novasHabilidades) {
        ps.alteraHabilidades(cpf, novasHabilidades);
    }

    public void removerPessoa(String cpf) {
        ps.removerPessoa(cpf);
    }

    public void adicionarComentario(String cpf, String comentario, String autorCPF) {
        ps.adicionaComentario(cpf, comentario, autorCPF);
    }

    public String listarComentarios(String cpf) {
        return ps.listaComentarios(cpf);
    }
}
