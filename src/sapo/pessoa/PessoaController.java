package sapo.pessoa;

import sapo.funcao.FuncaoAluno;
import sapo.funcao.FuncaoProfessor;

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
    ps.cadastraPessoa(new Pessoa(cpf, nome, habilidades, null));
  }

  public void cadastraAluno(String cpf, String nome, String[] habilidades, String matricula, int periodo) {
    this.validador.validacao(cpf);
    this.validador.validacao(nome);
    ps.cadastraPessoa(new Pessoa(cpf, nome, habilidades, new FuncaoAluno(matricula, periodo)));
  }

  public void cadastraProfessor(String cpf, String nome, String[] habilidades, String siape, String[] disciplinas) {
    this.validador.validacao(cpf);
    this.validador.validacao(nome);
    ps.cadastraPessoa(new Pessoa(cpf, nome, habilidades, new FuncaoProfessor(siape, disciplinas)));
  }

  public void definirFuncaoProfessor(String cpf, String siape, String[] disciplinas) {
    this.validador.validacao(cpf);
    this.validador.validacao(siape);
    ps.definirFuncaoProfessor(cpf, siape, disciplinas);
  }

  public void definirFuncaoAluno(String cpf, String matr, int periodo) {
    this.validador.validacao(cpf);
    this.validador.validacao(matr);
    ps.definirFuncaoAluno(cpf, matr, periodo);
  }

  public void removerFuncao(String cpf) {
    ps.removerFuncao(cpf);
  }

  public int pegarNivel(String cpf) {
    return ps.pegarNivel(cpf);
  }

  public String[] listarPessoas() {
    return ps.listarPessoas();
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
