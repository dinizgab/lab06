package sapo.tarefa;


import sapo.tarefa.heranca.TarefaAbstract;

import java.util.Map;

public class ValidadorTarefa {
    public void validaCiclo(Map<String, TarefaAbstract> tarefasGerenciadas, TarefaAbstract tarefaAdicionada) {
        for (TarefaAbstract t : tarefasGerenciadas.values()) {
            if (t.equals(tarefaAdicionada))
                throw new IllegalArgumentException("CICLO DETECTADO! A tarefa adicionada já gerencia essa tarefa");
        }
    }
    
	public static boolean argumentoValido(String arg) {
		return !(arg.isBlank() || arg == null);
	}
	
	public static boolean argumentoValido(String[] arg) {
		return !(arg == null);
	}
	
	
}
