package sapo.busca;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import sapo.pessoa.Pessoa;

public class BuscaPessoa extends BuscaAbstract {
	private String[] termos;
	private Map<String, Pessoa> pessoas;
	
	public BuscaPessoa(String[] termos, Map<String, Pessoa> pessoas){
		super("PESSOA");
		this.termos = termos;
		this.pessoas = pessoas;
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
		
		
		return ordenaResultado(resultado);
	}

	private List<String> ordenaResultado(List<String> resultado) {
		String[] array = resultado.toArray(new String[resultado.size()]);
        Arrays.sort(array, String.CASE_INSENSITIVE_ORDER);
		return Arrays.asList(array);
	}

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
