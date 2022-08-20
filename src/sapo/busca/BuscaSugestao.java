package sapo.busca;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import sapo.pessoa.Pessoa;
import sapo.tarefa.heranca.TarefaAbstract;

public class BuscaSugestao extends BuscaAbstract{
	private Pessoa pessoa;
	private List<TarefaAbstract> tarefas;
	
	public BuscaSugestao(Pessoa pessoa, List<TarefaAbstract> tarefas){
		super("SUGESTAO");
		this.pessoa = pessoa;
		this.tarefas = tarefas;
	}

	/**
	 * Ordena as tarefas existentes no sistema de acordo com as habilidades que cada tarefa tem com as habilidades da
	 * pessoa. A ordem é da tarefa que mais tem habilidade em comum com a pessoa até a que tem menos habilidades em 
	 * comum. Em caso de empate de número de habilidades em comum o desempate é feito por menor número de pessoas rela
	 * cionadas a tarefa e, em caso de empate novamente, o desempate é feito por ordem alfabetica de código da tarefa.
	 * 
	 * @return codigos das tarefas;
	 */
	@Override
	public List<String> busca() {
		Map<Integer, List<TarefaAbstract>> mapa = new HashMap<>(); // num de habilidades em comum -> tarefas 
		Set<String> habilidadesPessoa = new HashSet<String>(Arrays.asList(pessoa.getHabilidades()));
		for (TarefaAbstract tarefa: tarefas) {
			Set<String> habilidadesTarefa = tarefa.getHabilidades();
			habilidadesTarefa.retainAll(habilidadesPessoa);
			Integer numHabilidadesEmComum = habilidadesTarefa.size();
			if(!mapa.containsKey(numHabilidadesEmComum)) {
				mapa.put(numHabilidadesEmComum, new ArrayList<TarefaAbstract>());
			}
			mapa.get(numHabilidadesEmComum).add(tarefa);
		}
		
		List<TarefaAbstract> tarefasOrdenadas = ordenaHabilidades(mapa);
		List<String> resultadoBusca = new ArrayList<>();
		for (TarefaAbstract tarefa : tarefasOrdenadas) {
			resultadoBusca.add(tarefa.getCodigo());
		}
		return resultadoBusca;
	}
	
	
	private List<TarefaAbstract> ordenaHabilidades(Map<Integer, List<TarefaAbstract>> mapa){
		List<TarefaAbstract> resultado = new ArrayList<TarefaAbstract>();
		ArrayList<Integer> chaves = (new ArrayList<Integer>(mapa.keySet()));
		Collections.sort(chaves, Collections.reverseOrder());
		for (Integer key : chaves){
			resultado.addAll(desempataMenosPessoas(mapa.get(key)));
		} 
			
		return resultado;
	}
	
	private List<TarefaAbstract> desempataMenosPessoas(List<TarefaAbstract> tarefas){
		Collections.sort(tarefas, new Comparator<TarefaAbstract>() {
		    @Override
		    public int compare(TarefaAbstract t1, TarefaAbstract t2) {
		        int comparacaoPorQtdPessoas = t1.getResponsaveis().size() - t2.getResponsaveis().size();
		        if(comparacaoPorQtdPessoas != 0) {
		        	return comparacaoPorQtdPessoas;
		        }else {
		        	return t1.getCodigo().compareTo(t2.getCodigo());
		        }
		    }
		});
		
		return tarefas;
	}
	


	
	
}
