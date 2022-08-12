package sapo.tarefa;

import sapo.atividade.AtividadeService;

public class TarefaController {
    private AtividadeService as;

    public TarefaController(AtividadeService as) {
        this.as = as;
    }
    
    public String cadastrarTarefa(String atividadeId, String nome, String[] habilidades) {
    	return as.cadastraTarefa(atividadeId, nome, habilidades);
    }
    
    public void alterarNomeTarefa(String tarefaId, String novoNome){
    	as.alterarNomeTarefa(tarefaId, novoNome);
    }
    
    public void alterarHabilidadesTarefa(String idTarefa, String[] habilidades) {
    	as.alterarHabilidadesTarefa(idTarefa, habilidades);
	}
    public void adicionarHorasTarefa(String idTarefa, int horas) {
    	as.adicionarHorasTarefa(idTarefa, horas);
    }
    
    public void removerHorasTarefa(String idTarefa, int horas) {
    	as.removerHorasTarefa(idTarefa, horas);
    }
    
    public void concluirTarefa(String idTarefa) {
    	as.concluirTarefa(idTarefa);
    }
    
    public void removerTarefa(String idTarefa) {
    	as.removerTarefa(idTarefa);
    }
    
    public String exibirTarefa(String idTarefa) {
		return as.exibirTarefa(idTarefa);
    }
    
    public void associarPessoaTarefa(String cpf, String idTarefa) {
    	as.associarPessoaTarefa(cpf, idTarefa);
    }
    
    public void removerPessoaTarefa(String cpf, String idTarefa) {
    	as.removerPessoaTarefa(cpf, idTarefa); 
    }
}
