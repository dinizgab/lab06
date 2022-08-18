package sapo.busca;

import java.util.List;

public class BuscaService {
	private BuscaRepository br;
	
	
	public BuscaService(BuscaRepository br) {
		this.br = br;
	}

	public List<String> busca(BuscaInterface busca) {
		List<String> pesquisa = busca.busca();
		br.adicionaBusca(busca.getTipo(), pesquisa);
		return pesquisa;
	}	
}
