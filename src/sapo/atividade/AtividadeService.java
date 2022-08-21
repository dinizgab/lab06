package sapo.atividade;

import sapo.pessoa.Pessoa;
import sapo.pessoa.PessoaService;

public class AtividadeService {
    private PessoaService ps;
    private AtividadeRepository ar;

    public AtividadeService(PessoaService ps, AtividadeRepository ar) {
        this.ps = ps;
        this.ar = ar;
    }

    public String cadastrarAtividade(String nome, String descricao, String cpf) {
        Pessoa responsavel = ps.getPessoa(cpf);
        String codigoDaAtividade = gerarCodigo(nome);
        Atividade novaAtividade = new Atividade(codigoDaAtividade, nome, descricao, responsavel);
        ar.add(codigoDaAtividade, novaAtividade);
        return codigoDaAtividade;
    }

    private String gerarCodigo(String nome) {
        String codigo = "";
        for (char caractere : nome.toCharArray()) {
            if (codigo.length() == 3)
                break;

            String letra = "" + caractere;
            if ("aeiou".contains(letra))
                continue;

            codigo += letra.toUpperCase();
        }

        if (codigo.length() != 3) {
            for (int i = 0; i < 3 - codigo.length(); i++) {
                codigo += "X";
            }
        }

        return codigo + "-" + ar.size();
    }

    public void encerrarAtividade(String atividadeId) {
        ar.get(atividadeId).encerrar();
    }

    public void desativarAtividade(String atividadeId) {
        ar.get(atividadeId).desativar();
    }

    public void reabrirAtividade(String atividadeId) {
        ar.get(atividadeId).reabrir();
    }

    public String exibirAtividade(String atividadeId) {
        return ar.get(atividadeId).toString();
    }

    public void alterarDescricaoAtividade(String atividadeId, String descricao) {
        ar.get(atividadeId).setDescricao(descricao);
    }

    public void alterarResponsavelAtividade(String atividadeId, String cpf) {
        Pessoa novoResponsavel = ps.getPessoa(cpf);
        ar.get(atividadeId).setResponsavel(novoResponsavel);
    }

    public Atividade getAtividade(String codigo) {
        return ar.get(codigo);
    }

    public void removeResponsavelAtividadeLGPD(String cpf) {
        ar.removeRsponsavel(cpf);
    }
}
