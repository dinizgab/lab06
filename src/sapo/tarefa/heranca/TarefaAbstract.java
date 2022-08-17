package sapo.tarefa.heranca;

import sapo.atividade.Atividade;
import sapo.pessoa.Pessoa;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public abstract class TarefaAbstract implements TarefaInterface{
    protected String nome;
    protected String codigo;
    protected Set<String> habilidades;
    protected Map<String, Pessoa> responsaveis;
    protected int horas = 0;
    protected boolean concluida;
    protected Atividade atividade;

    public TarefaAbstract(String nome, String codigo, Atividade atividade) {
        this.nome = nome;
        this.codigo = codigo;
        this.atividade = atividade;
    }

    /**
     * recupera o código da tarefa.
     *
     * @return
     */
    public String getCodigo() {
        return this.codigo;
    }

    public String getNome() {
        return this.nome;
    }

    /**
     * define o nome da tarefa.
     *
     * @param nome nome da tarefa.
     */
    public void setNome(String nome) {
        if (this.concluida) return;
        this.nome = nome;
    }

    /**
     * adiciona horas a uma tarefa.
     *
     * @param horas horas a serem adicionadas.
     */
    public void adicionaHoras(int horas) {
        this.horas += horas;
    }

    /**
     * remove horas de uma terefa.
     *
     * @param horas horas a serem removidas.
     */
    public void removeHoras(int horas) {
        this.horas -= horas;
    }

    /**
     * recupera o status da tarefa.
     *
     * @return status da tarefa.
     */
    public boolean getStatus() {
        return this.concluida;
    }

    public int getHoras() {
        return this.horas;
    }

    public Set<String> getHabilidades() {
        return this.habilidades;
    }

    /**
     * define as habilidades recomendadas da tarefa.
     *
     * @param habilidades habilidades da tarefa.
     */
    public void setHabilidades(Set<String> habilidades) {
        if (!this.concluida) return;
        this.habilidades = habilidades;
    }

    /**
     * adiciona uma pessoa responsável a tarefa.
     *
     * @param pessoa pessoa a ser adicionada
     */
    public void adicionaResponsavel(Pessoa pessoa) {
        this.responsaveis.put(pessoa.getCpf(), pessoa);
    }

    /**
     * remove uma pessoa responsável a partir do seu cpf.
     *
     * @param cpf cpf da pessoa a ser removida.
     */
    public void removeResponsavel(String cpf) {
        this.responsaveis.remove(cpf);
    }

    /**
     * conclui uma tarefa.
     */
    public void concluiTarefa() {
        this.concluida = true;
    }

    protected String exibeEquipe() {
        String saida = "";
        for (Map.Entry<String, Pessoa> pair : responsaveis.entrySet()) {
            saida += pair.getValue().getNome() + " - " + pair.getKey() + "\n";
        }

        return saida;
    }

    protected String exibeHabilidades() {
        String saida = "";
        for (String habilidade : habilidades) {
            saida += habilidade + "\n";
        }

        return saida;
    }
}
