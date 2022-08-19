package sapo.busca;

import java.util.List;

import sapo.atividade.AtividadeRepository;
import sapo.pessoa.PessoaService;
import sapo.tarefa.TarefaController;

public class BuscaController {

	private BuscaService bs;
	private ValidadorBusca vb;
	private PessoaService ps;
	private AtividadeRepository ar;
	private TarefaController tc;
	
	
	public BuscaController(BuscaService bs, PessoaService ps, AtividadeRepository ar, TarefaController tc){
		this.bs = bs;
		this.ps = ps;
		this.ar = ar;
		this.tc = tc;
		this.vb = new ValidadorBusca();
	}

	public List<String> exibirPessoas(String consulta){
		return bs.busca(new BuscaPessoa(consulta.split(""), ps.getPessoas()));
	}
	
	public List<String> buscarAtividade(String consulta){
		return bs.busca(new BuscaAtividade(consulta.split(""), ar.getAtividades()));
	}
	
	public List<String> buscarTarefas(String nome){
		return bs.busca(new BuscaTarefa(tc.getTarefas(), nome));
	}
	
	public List<String> buscaTarefas(String id, String nome){
		// TO DO
		return null;
	}
	
	public List<String> sugerirTarefas(String cpf){
		return bs.busca(new BuscaSugestao(ps.getPessoa(cpf), tc.getTarefas()));
	}
	
	public List<String> buscasMaisRecentes(int nBuscas){
		return bs.buscasMaisRecentes(nBuscas);
	}
	
	public List<String> exibirHistóricoBusca(int indexBusca){
		return bs.getBusca(indexBusca);
	}

}
