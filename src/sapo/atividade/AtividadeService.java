package sapo.atividade;

import java.util.HashMap;
import java.util.Map;

import sapo.pessoa.Pessoa;
import sapo.pessoa.PessoaService;

public class AtividadeService {
  private PessoaService ps;
  private Map<String, Atividade> atividades;

  public AtividadeService(PessoaService ps) {
    this.ps = ps;
    this.atividades = new HashMap<>();
  }

  public String cadastrarAtividade(String nome, String descricao, String cpf) {
    Pessoa responsavel = ps.getPessoa(cpf);
    String codigoDaAtividade = gerarCodigo(nome);
    Atividade novaAtividade = new Atividade(codigoDaAtividade, nome, descricao, responsavel);
    atividades.put(codigoDaAtividade, novaAtividade);
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

    return codigo + "-" + atividades.size();
  }

  public void encerrarAtividade(String atividadeId) {
    atividades.get(atividadeId).encerrar();
  }

  public void desativarAtividade(String atividadeId) {
    atividades.get(atividadeId).desativar();
  }

  public void reabrirAtividade(String atividadeId) {
    atividades.get(atividadeId).reabrir();
  }

  public String exibirAtividade(String atividadeId) {
    return atividades.get(atividadeId).toString();
  }

  public void alterarDescricaoAtividade(String atividadeId, String descricao) {
    atividades.get(atividadeId).setDescricao(descricao);
  }

  public void alterarResponsavelAtividade(String atividadeId, String cpf) {
    Pessoa novoResponsavel = ps.getPessoa(cpf);
    atividades.get(atividadeId).setResponsavel(novoResponsavel);
  }

}
