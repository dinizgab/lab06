package sapo.busca;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import sapo.atividade.Atividade;

public class BuscaAtividade extends BuscaAbstract{
	private String[] termos;
	private List<Atividade> atividades;
	
	public BuscaAtividade(String[] termos, List<Atividade> atividades) {
		super("ATIVIDADE");
		this.termos = termos;
		this.atividades = atividades;
	}

	/**
	 * Encontra as atividades que tem relação com a busca. A relação existe se o nome da atividade for igual a chave
	 * de busca, se a o id completo da atividade, a parte textual ou a parte númerica for igual a chave ou se a 
	 * descrição da atividade for igual a chave. Ignora-se a diferença entre as letras minusculas e maiusculas.
	 * @return  lista de ID's das atividades encontradas na busca em oderm alfabetica de ID;
	 */
	public List<String> busca() {
		List<String> resultado = new ArrayList<>();
		
		for (Atividade atividade : atividades) {
			for (String termo : termos) {
				if(comparaNome(atividade, termo) || comparaCodigo(atividade, termo) || comparaDecricao(atividade, termo)) {
					if(!resultado.contains(atividade.getId())) {
						resultado.add(atividade.getId());
					}
				}
			}
		}
		
		Collections.sort(resultado);
		return resultado;
	}

	private boolean comparaDecricao(Atividade atividade, String termo){
		return (atividade.getDescricao().equalsIgnoreCase(termo));
	}

	private boolean comparaCodigo(Atividade atividade, String termo) {
		String codigo = atividade.getId();
		String[] parts = codigo.split("-");
		if(codigo.equalsIgnoreCase(termo) || parts[0].equalsIgnoreCase(termo) || parts[1].equalsIgnoreCase(termo)) {
			return true;
		}	
		return false;
	}

	private boolean comparaNome(Atividade atividade, String termo) {
		return (atividade.getNome().equalsIgnoreCase(termo));
	}
}
