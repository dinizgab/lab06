package sapo.funcao;

import java.util.Map;

import sapo.tarefa.heranca.TarefaAbstract;

public interface Funcao {
    public String toString();

    public abstract int calcNivel(Map<String, TarefaAbstract> tarefas, String[] habilidades);
}
