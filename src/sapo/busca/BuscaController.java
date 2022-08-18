package sapo.busca;

import java.util.List;

public class BuscaController {
	private BuscaService bs;
	private ValidadorBusca vb;
	
	
	public BuscaController(BuscaService bs){
		this.bs = bs;
		this.vb = new ValidadorBusca();
	}
	
	public List<String> exibirPessoas(String consulta){
		return null;
	}
	
	public List<String> buscarAtividade(String consulta){
		return null;
	}
	
	public List<String> buscarTarefas(String nome){
		return null;
	}
	
	public List<String> buscaTarefas(String id, String nome){
		return null;
	}
	
	
	public List<String> sugerirTarefas(String cpf){
		return null;
	}
	
	
	public List<String> buscasMaisRecentes(int nBuscas){
		return null;
	}
	
	
	public List<String> exibirHistóricoBusca(int indexBusca){
		return null;
	}

}
