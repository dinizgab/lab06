package sapo.busca;

import java.util.List;

import sapo.atividade.AtividadeService;
import sapo.pessoa.PessoaService;
import sapo.tarefa.TarefaController;

public class BuscaController {

	private BuscaService bs;
	private ValidadorBusca vb;
	private PessoaService ps;
	private AtividadeService as;
	private TarefaController tc;
	
	
	public BuscaController(BuscaService bs, PessoaService ps){
		this.bs = bs;
		this.ps = ps;
		this.vb = new ValidadorBusca();
	}

	public List<String> exibirPessoas(String consulta){
		return bs.busca(new BuscaPessoa(consulta.split(""), ps.getPessoas()));
	}
	
	public List<String> buscarAtividade(String consulta){
		return bs.busca(new BuscaAtividade(consulta.split(""), as.getAtividaes()));
	}
	
	public List<String> buscarTarefas(String nome){
		return bs.busca(new BuscaTarefa(tc.getTarefas(), nome));
	}
	
	public List<String> buscaTarefas(String id, String nome){
		return null;
	}
	
	public List<String> sugerirTarefas(String cpf){
		return bs.busca(new BuscaSugestao(ps.getPessoa(cpf), tc.getTarefas()));
	}
	
	public List<String> buscasMaisRecentes(int nBuscas){
		return null;
	}
	
	
	public List<String> exibirHistóricoBusca(int indexBusca){
		return null;
	}

}
