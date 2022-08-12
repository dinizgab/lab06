package sapo.atividade;

import java.util.Map;

import sapo.pessoa.PessoaService;

public class AtividadeService {
	private PessoaService ps;

	public AtividadeService(PessoaService ps) {
		this.ps = ps;
	}

	
	// tarefa
	public String cadastraTarefa(String atividadeId, String nome, String[] habilidades) {
		return atividades.get(atividadeId).cadastraTarefa(nome, habilidades);
	}

	public void alterarNomeTarefa(String tarefaId, String novoNome) {
		recuperaAtividade(tarefaId).alteraNomeTarefa(tarefaId, novoNome);

	}

	public void alterarHabilidadesTarefa(String idTarefa, String[] habilidades) {
		recuperaAtividade(idTarefa).alterarHabilidadesTarefa(idTarefa, habilidades);
	}

	public void adicionarHorasTarefa(String idTarefa, int horas) {
		recuperaAtividade(idTarefa).adicionarHorasTarefa(idTarefa, horas);
	}

	public void removerHorasTarefa(String idTarefa, int horas) {
		recuperaAtividade(idTarefa).removerHorasTarefa(idTarefa, horas);

	}

	public void concluirTarefa(String idTarefa) {
		recuperaAtividade(idTarefa).concluirTarefa(idTarefa);

	}

	public void removerTarefa(String idTarefa) {
		recuperaAtividade(idTarefa).removerTarefa(idTarefa);

	}

	public String exibirTarefa(String idTarefa) {
		return recuperaAtividade(idTarefa).exibirTarefa(idTarefa);
	}

	public void associarPessoaTarefa(String cpf, String idTarefa) {
		recuperaAtividade(idTarefa).associarPessoaTarefa(idTarefa, ps.getPessoa(cpf));

	}

	public void removerPessoaTarefa(String cpf, String idTarefa) {
		recuperaAtividade(idTarefa).removerPessoaTarefa(cpf, idTarefa);

	}

	private String recuperaIdAtividade(String idTarefa) {
		int count = 0;
		String idAtividade = "";
		String[] caracteres = idTarefa.split("");
		for (int i = 0; i < caracteres.length; i++) {
			if (caracteres[i].equals("-")) {
				count++;
			}
			if (count < 2) {
				idAtividade += caracteres[i];
			}
		}

		return idAtividade;
	}

	private Atividade recuperaAtividade(String idTarefa) {
		return atividades.get(recuperaIdAtividade(idTarefa));
	}

}
