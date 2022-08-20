package sapo.pessoa;

import java.util.HashMap;
import java.util.Map;

public class PessoaService {
    private Map<String, Pessoa> pessoaRepository;

    public PessoaService() {
        this.pessoaRepository = new HashMap<>();
    }

    public void cadastraPessoa(Pessoa pessoa) {
        pessoaRepository.put(pessoa.getCpf(), pessoa);
    }

    public String recuperaPessoa(String cpf) {
        return pessoaRepository.get(cpf).toString();
    }

    public void alteraNome(String cpf, String novoNome) {
        pessoaRepository.get(cpf).alteraNome(novoNome);
    }

    public void alteraHabilidades(String cpf, String[] habilidades) {
        pessoaRepository.get(cpf).alteraHabilidades(habilidades);
    }

    public void removerPessoa(String cpf) {
        // TODO - Algoritmo de apagar a pessoa em todo o sistema ao se apagar a pessa
        pessoaRepository.remove(cpf);
    }

    public void adicionaComentario(String cpf, String descricao, String autorCPF) {
        Pessoa p = pessoaRepository.get(cpf);
        Pessoa autor = pessoaRepository.get(autorCPF);

        p.adicionaComentario(new Comentario(autor, descricao));
    }

    public String listaComentarios(String cpf) {
        return pessoaRepository.get(cpf).listarComentarios();
    }

    public Pessoa getPessoa(String cpf) {
        return pessoaRepository.get(cpf);
    }

    public Map<String, Pessoa> getPessoas() {
        return new HashMap<>(this.pessoaRepository);
    }
}
