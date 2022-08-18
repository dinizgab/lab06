package sapo.busca;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import sapo.pessoa.Pessoa;

public class BuscaPessoa implements BuscaInterface {
	private String tipo;
	private String[] termos;
	private Map<String, Pessoa> pessoas;
	
	public BuscaPessoa(String[] termos, Map<String, Pessoa> pessoas){
		this.termos = termos;
		this.tipo = "PESSOA";
		this.pessoas = pessoas;
	}
	
	public String getTipo(){
		return this.tipo;
	}

	public List<String> busca() {
		List<String> resultado = new ArrayList<>(); 
		
		for(Map.Entry<String, Pessoa> pair : pessoas.entrySet()) {
			Pessoa pessoa = pair.getValue();
			for (String termo : termos) {
				if(comparacpf(pessoa, termo) || comparaNome(pessoa, termo) || comaparaHabilidade(pessoa, termo)) {
					if(!resultado.contains(pessoa.getNome())) {
						resultado.add(pessoa.getNome());
					}
				}
			}
		}
		
		
		Collections.sort(resultado);
		return resultado;
	}

	//analisar uma implementacao melhor
	private boolean comaparaHabilidade(Pessoa pessoa, String termo) {
		for (String habilidade : pessoa.getHabilidades()) {
			if(habilidade.equalsIgnoreCase(termo)){
				return true;
			}
		}
		return false;
	}

	private boolean comparaNome(Pessoa pessoa, String termo) {
		return pessoa.getNome().equalsIgnoreCase(termo);
	}

	private boolean comparacpf(Pessoa pessoa, String termo) {
		return pessoa.getCpf().equalsIgnoreCase(termo);
	}
	
	
}
