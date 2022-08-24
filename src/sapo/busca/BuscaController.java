package sapo.busca;

import java.util.List;

import sapo.atividade.AtividadeRepository;
import sapo.pessoa.PessoaService;
import sapo.tarefa.TarefaController;

/**
 * Controller da funcionalidade de buscas do sistema
 * @author Sabrina Barbosa
 *
 */
public class BuscaController {

	private BuscaService bs;
	private PessoaService ps;
	private AtividadeRepository ar;
	private TarefaController tc;
	
	/**
	 * Cria o controller de buscas
	 * @param bs Service de Busca
	 * @param ps Service de Pessoa
	 * @param ar Repositorio de atividade
	 * @param tc Controller de Tarefa
	 */
	public BuscaController(BuscaService bs, PessoaService ps, AtividadeRepository ar, TarefaController tc){
		this.bs = bs;
		this.ps = ps;
		this.ar = ar;
		this.tc = tc;
	}

	/**
	 * Constrói um BuscaPessoa para encontrar pessoas que tenham relação com a consulta dada. 
	 * @param consulta consulta contendo as chaves de busca
	 * @return lista de nomes das pessoas encontradas na busca em ordem alfabetica de nome;
	 */
	public List<String> exibirPessoas(String consulta){
		if(!ValidadorBusca.argumentoValido(consulta)) {
			throw new IllegalArgumentException("A consulta não pode ser vazia ou nula");
		}
		return bs.busca(new BuscaPessoa(consulta.split(" "), ps.getPessoas()));
	}
	
	/**
	 * Constrói um BuscaAtividade para encontrar atividades que tenham relação com a consulta dada. 
	 * @param consulta consulta contendo as chaves de busca.
	 * @return lista de ID's das atividades encontradas na busca em oderm alfabetica de ID.
	 */
	public List<String> buscarAtividade(String consulta){
		if(!ValidadorBusca.argumentoValido(consulta)) {
			throw new IllegalArgumentException("A consulta não pode ser vazia ou nula");
		}
		return bs.busca(new BuscaAtividade(consulta.split(" "), ar.getAtividades()));
	}
	
	/**
	 * Constrói um BuscaTarefa para encontrar tarefas que tenham relação com a consulta dada.
	 * @param nome nome da tarefa.
	 * @return lista das versões textuais das tarefas encontradas na busca.
	 */
	public List<String> buscarTarefas(String nome){
		if(!ValidadorBusca.argumentoValido(nome)) {
			throw new IllegalArgumentException("O nome da tarefa não pode ser vazia ou nula");
		}
		return bs.busca(new BuscaTarefa(tc.getTarefas(), nome));
	}
	
	/**
	 * busca tarefas por nome limitando a busca de forma que só retorne as tarefas relacionadas a uma atividade.
	 * @param id id da atividade
	 * @param nome nome da tarefa
	 * @return lista das versões textuais das tarefas encontradas na busca.
	 */
	public List<String> buscarTarefas(String id, String nome){
		if(!ValidadorBusca.argumentoValido(id) || (!ValidadorBusca.argumentoValido(nome))) {
			throw new IllegalArgumentException("Nem o id da atividade nem o nome da tarefa podem ser vazias ou nulas");
		}
		return bs.buscaTarefasEmAtividade(ar.get(id), nome);
	}
	
	/**
	 * Constrói um BuscaTarefa para retornar uma sugestão de tarefas para uma pessoa específica. 
	 * @param cpf cpf da pessoa
	 * @return codigos das tarefas ordenadas por similaridade com as habilidades da pessoa.
	 */
	public List<String> sugerirTarefas(String cpf){
		if(!ValidadorBusca.argumentoValido(cpf)) {
			throw new IllegalArgumentException("o cpf da pessoa não pode ser vazio ou nulo");
		}
		return bs.busca(new BuscaSugestao(ps.getPessoa(cpf), tc.getTarefas()));
	}
	
	/**
	 * retorna as n buscas mais recentes feitas.
	 * @param nBuscas numero de buscas
	 * @return buscas realizadas.
	 */
	public List<String> buscasMaisRecentes(int nBuscas){
		return bs.buscasMaisRecentes(nBuscas);
	}
	
	/**
	 * retorna uma busca específica a partir do seu index
	 * @param indexBusca index da busca
	 * @return busca realizada
	 */
	public List<String> exibirHistóricoBusca(int indexBusca){
		return bs.getBusca(indexBusca);
	}

}
