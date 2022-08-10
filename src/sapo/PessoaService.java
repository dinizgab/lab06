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
}
