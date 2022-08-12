package sapo.atividade;

import sapo.pessoa.PessoaService;

public class AtividadeService {
    private PessoaService ps;

    public AtividadeService(PessoaService ps) {
        this.ps = ps;
    }

    
    
    
    
    
    
    
    
    
    
    
    
   
    // tarefa
	public String cadastraTarefa(String atividadeId, String nome, String[] habilidades) {
		// TODO Auto-generated method stub
		return null;
	}

	public void alterarNomeTarefa(String tarefaId, String novoNome) {
		// TODO Auto-generated method stub
		
	}

	public void alterarHabilidadesTarefa(String idTarefa, String[] habilidades) {
		// TODO Auto-generated method stub
		
	}

	public void adicionarHorasTarefa(String idTarefa, int horas) {
		// TODO Auto-generated method stub
		
	}

	public void removerHorasTarefa(String idTarefa, int horas) {
		// TODO Auto-generated method stub
		
	}

	public void concluirTarefa(String idTarefa) {
		// TODO Auto-generated method stub
		
	}

	public void removerTarefa(String idTarefa) {
		// TODO Auto-generated method stub
		
	}

	public String exibirTarefa(String idTarefa) {
		// TODO Auto-generated method stub
		return null;
	}

	public void associarPessoaTarefa(String cpf, String idTarefa) {
		// TODO Auto-generated method stub
		
	}

	public void removerPessoaTarefa(String cpf, String idTarefa) {
		// TODO Auto-generated method stub
		
	}
	
	public void recuperaIdAtividade(String idTarefa) {
		// TODO
	}
	
	

}
