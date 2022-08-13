package sapo.tarefa;


public class TarefaController {
    private TarefaService ts;

    public TarefaController(TarefaService ts) {
        this.ts = ts;
    }
    
    public String cadastrarTarefa(String id, String nome, String[] habilidades) {
    	return ts.cadastraTarefa(id, nome, habilidades);
    }
    
    public void alterarNomeTarefa(String codigo, String novoNome){
    	ts.alterarNomeTarefa(codigo, novoNome);
    }
    
    public void alterarHabilidadesTarefa(String codigo, String[] habilidades) {
    	ts.alterarHabilidadesTarefa(codigo, habilidades);
	}
    public void adicionarHorasTarefa(String codigo, int horas) {
    	ts.adicionarHorasTarefa(codigo, horas);
    }
    
    public void removerHorasTarefa(String codigo, int horas) {
    	ts.removerHorasTarefa(codigo, horas);
    }
    
    public void concluirTarefa(String codigo) {
    	ts.concluirTarefa(codigo);
    }
    
    public void removerTarefa(String codigo) {
    	ts.removerTarefa(codigo);
    }
    
    public String exibirTarefa(String codigo) {
		return ts.exibirTarefa(codigo);
    }
    
    public void associarPessoaTarefa(String cpf, String codigo) {
    	ts.associarPessoaTarefa(cpf, codigo);
    }
    
    public void removerPessoaTarefa(String cpf, String idTarefa) {
    	ts.removerPessoaTarefa(cpf, idTarefa); 
    }
}
