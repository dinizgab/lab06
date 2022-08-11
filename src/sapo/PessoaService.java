package sapo;

import java.util.HashMap;
import java.util.Map;

public class PessoaService {
    Map<String, Pessoa> pessoaRepository;

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
        Pessoa p = pessoaRepository.get(cpf);
        p.setNome(novoNome);
    }
}
