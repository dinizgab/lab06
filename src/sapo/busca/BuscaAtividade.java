package sapo.busca;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import sapo.atividade.Atividade;

public class BuscaAtividade extends BuscaAbstract{
	private String[] termos;
	private List<Atividade> atividades;
	
	public BuscaAtividade(String[] termos, List<Atividade> atividades) {
		super("ATIVIDADE");
		this.termos = termos;
		this.atividades = atividades;
	}

	public List<String> busca() {
		List<Atividade> atividadesbusca = new ArrayList<>();
		
		for (Atividade atividade : atividades) {
			for (String termo : termos) {
				if(comparaNome(atividade, termo) || comparaCodigo(atividade, termo) || comparaDecricao(atividade, termo)) {
					if(!atividadesbusca.contains(atividade)) {
						atividadesbusca.add(atividade);
					}
				}
			}
		}			
		List<String> resultado = ordenaAtividades(atividadesbusca);
		return resultado;
	}

	private List<String> ordenaAtividades(List<Atividade> atividades) {
		Collections.sort(atividades);
		List<String> resultado = new ArrayList<>();
		for (Atividade atividade : atividades) {
			resultado.add(atividade.toString());
		}
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
