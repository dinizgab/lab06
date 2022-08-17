package sapo.tarefa.heranca;

import sapo.pessoa.Pessoa;

import java.util.Set;

public interface TarefaInterface {
    public String getCodigo();

    public String getNome();

    public int getHoras();

    public Set<String> getHabilidades();

    public void setHabilidades(Set<String> habilidades);

    public void adicionaHoras(int horas);

    public void removeHoras(int horas);

    public boolean getStatus();

    public void adicionaResponsavel(Pessoa pessoa);

    public void removeResponsavel(String cpf);

    public void concluiTarefa();

    void setNome(String novoNome);
}
