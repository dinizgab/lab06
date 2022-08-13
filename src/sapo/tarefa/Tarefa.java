package sapo.tarefa;


import java.util.Map;
import java.util.Map.Entry;

import sapo.atividade.Atividade;
import sapo.pessoa.Pessoa;

public class Tarefa {

    private String nome;
    private String[] habilidades;
    private Map<String, Pessoa> responsaveis;
    /**
     * status da atividade. quando o status é true, a atividade foi concluida. status false indica que
     * a atividade esta aberta.
     */
    private Boolean status;
    private int horas;
    private String codigo;
    private Atividade atividade;

    /**
     * cria uma tarefa definindo seu codigo, nome, habilidade e a atividade a qual esta relacionada.
     * @param codigo codigo da tarefa
     * @param nome nome da tarefa
     * @param habilidades habilidades recomendadas da tarefa
     * @param atividade atividade relacionada
     */
    public Tarefa(String codigo, String nome,  String[] habilidades, Atividade atividade){
    	this.nome = nome;
        this.habilidades = habilidades;
        this.codigo = codigo;
        this.atividade = atividade;
    }
   
    
    /**
     * define o nome da tarefa. 
     * @param nome nome da tarefa.
     */
	public void setNome(String nome) {
		if(!getStatus()) {
			this.nome = nome;
		}
	}

	/**
	 * define as habilidades recomendadas da tarefa.
	 * @param habilidades habilidades da tarefa.
	 */
	public void setHabilidades(String[] habilidades) {
		if(!getStatus()) {
			this.habilidades = habilidades;
		}	}
	
	/**
	 * recupera o código da tarefa.
	 * @return
	 */
	public String getCodigo() {
		return this.codigo;
	}
	
	/**
	 * recupera o status da tarefa.
	 * @return status da tarefa.
	 */
	public boolean getStatus() {
		return this.status;
	}
	
	/**
	 * conclui uma tarefa.
	 */
	public void concluirTarefa() {
		this.status = true;
	}
	
	public void adicionaHoras(int horas) {
		this.horas += horas;
	}
	
	public void removeHoras(int horas) {
		this.horas -= horas;
	}
	
	public void adicionaResponsavel(Pessoa pessoa) {
		this.responsaveis.put(pessoa.getCpf(), pessoa);	
	}
	
	public void removerResponsavel(String cpf) {
		this.responsaveis.remove(cpf);
	}

	
	@Override
	public String toString() {
		return this.nome + " - " + codigo + "/n" + atividade.getNome() + "/n" + atividade.getDescricao() + this.horas + " hora(s) executada(s)" 
	+ exibeHabilidades() + "===/n" + "Equipe: " + exibeEquipe() ;
	}
	
	private String exibeHabilidades() {
		String saida = "";
		for (int i = 0; i < habilidades.length; i++) {
			saida += habilidades[i] + "/n";
		}
		
		return saida;
	} 
	
	private String exibeEquipe() {
		String saida = "";
		for (Entry<String, Pessoa> pair : responsaveis.entrySet()) {
			saida += pair.getValue().getNome() + " - " + pair.getKey() + "/n";
		}
			
		return saida;
	}
	
    
    
    
	
}
