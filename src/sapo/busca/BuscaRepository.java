package sapo.busca;

import java.util.ArrayList;
import java.util.List;

public class BuscaRepository {
	List<List<String>> buscas;
	
	public BuscaRepository() {
		this.buscas = new ArrayList<>();
	}
	public void adicionaBusca(String tipo, List<String> pesquisa){
		List<String> p = new ArrayList<String>(pesquisa);
		p.add(0, tipo);
		buscas.add(p);
	}
	
	public List<String> getBusca(int index){
		return this.buscas.get(index);
	}
	
	public List<String> getBuscasMaisRecentes(int nBuscas) {
		List<String> saida = new ArrayList<>();
		for (int i = 0; i < nBuscas; i++) {
			if(!buscas.get(i).equals(null)) {
				saida.addAll(buscas.get(i));
			}
		}
		return saida;
	}
}
