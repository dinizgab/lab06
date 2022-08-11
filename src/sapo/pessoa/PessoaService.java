package sapo.pessoa;

import java.util.HashMap;
import java.util.Map;

public class PessoaService {
    private Map<String, Pessoa> pessoaRepository;

    public PessoaService() {
        this.pessoaRepository = new HashMap<>();
    }

    public void cadastraPessoa(String cpf, String nome, String[] habilidades) {
        Pessoa p = new Pessoa(cpf, nome, habilidades);
        pessoaRepository.put(p.getCpf(), p);
    }

    public String recuperaPessoa(String cpf) {
        Pessoa p = pessoaRepository.get(cpf);

        return p.toString();
    }

    public void alteraNome(String cpf, String novoNome) {
        pessoaRepository.get(cpf).setNome(novoNome);
    }

    public void alteraHabilidades(String cpf, String[] habilidades) {
        pessoaRepository.get(cpf).setHabilidades(habilidades);
    }

    public void removerPessoa(String cpf) {
        // TODO - Algoritmo de apagar a pessoa em todo o sistema ao se apagar a pessa
        pessoaRepository.remove(cpf);
    }

    public void adicionaComentario(String cpf, String descricao, String autorCPF) {
        Pessoa p = pessoaRepository.get(cpf);
        Pessoa autor = pessoaRepository.get(autorCPF);

        Comentario comentario = new Comentario(autor, descricao);
        p.adicionaComentario(comentario);
    }

    public String listaComentarios(String cpf) {
        // TODO - Terminar a listagem de comentarios
        Pessoa p = pessoaRepository.get(cpf);

    }
}
