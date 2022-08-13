package sapo.tarefa;

import sapo.atividade.Atividade;
import sapo.atividade.AtividadeService;
import sapo.atividade.TarefaRepository;
import sapo.pessoa.PessoaService;

public class TarefaService {
	private AtividadeService as;
	private PessoaService ps;
	private TarefaRepository tr;
	
	
	
	public String cadastraTarefa(String id, String nome, String[] habilidades) {
		Atividade atividade = as.getAtividade(id);
		String codigo = id + "-" + atividade.getTarefas().size();
		Tarefa tarefa = new Tarefa(codigo, nome, habilidades, atividade);
		atividade.cadastraTarefa(tarefa);
		tr.cadastraTarefa(tarefa);
		return codigo;
	}

	public void alterarNomeTarefa(String codigo, String novoNome) {
		tr.alterarNomeTarefa(codigo, novoNome);
		
	}

	public void alterarHabilidadesTarefa(String codigo, String[] habilidades) {
		tr.alterarHabilidadesTarefa(codigo, habilidades);
		
	}

	public void adicionarHorasTarefa(String codigo, int horas) {
		tr.adicionarHorasTarefa(codigo, horas);		
	}

	public void removerHorasTarefa(String codigo, int horas) {
		tr.removerHorasTarefa(codigo, horas);
	}

	public void concluirTarefa(String codigo) {
		tr.concluirTarefa(codigo);
	}

	public void removerTarefa(String codigo) {
		as.getAtividade(recuperaIdAtividade(codigo)).removerTarefa(codigo);;
		tr.removerTarefa(codigo);		
	}

	public String exibirTarefa(String codigo) {
		return tr.exibirTarefa(codigo);
	}

	public void associarPessoaTarefa(String codigo, String cpf) {
		tr.associarPessoaTarefa(codigo, ps.getPessoa(cpf));
		
	}

	public void removerPessoaTarefa(String codigo ,String cpf) {
		tr.removerPessoaTarefa(codigo, cpf);
	}
	
	private String recuperaIdAtividade(String idTarefa) {
		int count = 0;
		String idAtividade = "";
		String[] caracteres = idTarefa.split("");
		for (int i = 0; i < caracteres.length; i++) {
			if (caracteres[i].equals("-")) { count++; }
			if (count < 2) { idAtividade += caracteres[i]; }
		}

		return idAtividade;
	}

}
