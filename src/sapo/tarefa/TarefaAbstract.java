package sapo.tarefa;

import sapo.atividade.Atividade;
import sapo.pessoa.Pessoa;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public abstract class TarefaAbstract {
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
    protected String getCodigo() {
        return this.codigo;
    }

    /**
     * adiciona horas a uma tarefa.
     *
     * @param horas horas a serem adicionadas.
     */
    protected void adicionaHoras(int horas) {
        this.horas += horas;
    }

    /**
     * remove horas de uma terefa.
     *
     * @param horas horas a serem removidas.
     */
    protected void removeHoras(int horas) {
        this.horas -= horas;
    }

    /**
     * adiciona uma pessoa responsável a tarefa.
     *
     * @param pessoa pessoa a ser adicionada
     */
    protected void adicionaResponsavel(Pessoa pessoa) {
        this.responsaveis.put(pessoa.getCpf(), pessoa);
    }

    /**
     * remove uma pessoa responsável a partir do seu cpf.
     *
     * @param cpf cpf da pessoa a ser removida.
     */
    protected void removeResponsavel(String cpf) {
        this.responsaveis.remove(cpf);
    }

    private String exibeEquipe() {
        String saida = "";
        for (Map.Entry<String, Pessoa> pair : responsaveis.entrySet()) {
            saida += pair.getValue().getNome() + " - " + pair.getKey() + "\n";
        }

        return saida;
    }

    private String exibeHabilidades() {
        String saida = "";
        for (String habilidade : habilidades) {
            saida += habilidade + "\n";
        }

        return saida;
    }
}
