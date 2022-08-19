package sapo.tarefa;

import sapo.atividade.Atividade;
import sapo.atividade.AtividadeService;
import sapo.pessoa.PessoaService;
import sapo.tarefa.heranca.Tarefa;
import sapo.tarefa.heranca.TarefaAbstract;
import sapo.tarefa.heranca.TarefaGerencial;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class TarefaController {
    private AtividadeService as;
    private PessoaService ps;
    private TarefaRepository tr;

    /**
     * Constroi o tarefaService
     *
     * @param as Service de atividade
     * @param ps Service de pessoa
     * @param tr Repositório de tarefa
     */
    public TarefaController(AtividadeService as, PessoaService ps, TarefaRepository tr) {
        this.as = as;
        this.ps = ps;
        this.tr = tr;
    }

    /**
     * Cadastra uma tarefa e retorna seu codigo, o codigo é formado pela junção do
     * Id da Atividade com a ordem de cadastro de tarefas na atividade em questão. A
     * tarefa é armazenada na atividade em especifico e no repositório de tarefas.
     *
     * @param atividadeID          Id da atividade
     * @param nome        nome da Tarefa
     * @param habilidades habilidades relacionadas a tarefa
     * @return codigo da tarefa cadastrada
     */
    public String cadastraTarefa(String atividadeID, String nome, String[] habilidades) {
        Atividade atividade = as.getAtividade(atividadeID);
        String codigo = atividadeID + "-" + atividade.getTarefas().size();
        Set<String> habilidadesSet = new HashSet<>(Arrays.asList(habilidades));

        Tarefa t = new Tarefa(nome, codigo, atividade, habilidadesSet);

        atividade.adicionarTarefa(t);
        this.tr.adicionaTarefa(t);
        return codigo;
    }

    public String cadastraTarefaGerencial(String atividadeID, String nome, String[] habilidades, String[] IDTarefas) {
        Atividade atividade = as.getAtividade(atividadeID);
        String codigo = atividadeID + "-" + atividade.getTarefas().size();

        HashMap<String, TarefaAbstract> tarefaMap = criaMapTarefas(IDTarefas);
        Set<String> habilidadesSet = new HashSet<>(Arrays.asList(habilidades));

        TarefaGerencial tg = new TarefaGerencial(nome, codigo, atividade, habilidadesSet, tarefaMap);
        atividade.adicionarTarefa(tg);
        this.tr.adicionaTarefa(tg);
        return codigo;
    }

    private HashMap<String, TarefaAbstract> criaMapTarefas(String[] IDTarefas) {
        HashMap<String, TarefaAbstract> tarefasMap = new HashMap<>();

        for (String ID : IDTarefas) {
            TarefaAbstract t = tr.getTarefa(ID);
            tarefasMap.put(t.getCodigo(), t);
        }
        return tarefasMap;
    }

    /**
     * altera o nome de uma tarefa a partir do seu codigo.
     *
     * @param codigo   codigo da tarefa.
     * @param novoNome novo nome da tarefa.
     */
    public void alterarNomeTarefa(String codigo, String novoNome) {
        tr.alterarNomeTarefa(codigo, novoNome);
    }

    /**
     * altera as habilidades referentes a uma tarefa a partir do seu código.
     *
     * @param codigo      codigo da tarefa.
     * @param habilidades habilidades referentes a tarefa.
     */
    public void alterarHabilidadesTarefa(String codigo, String[] habilidades) {
        Set<String> habilidadesSet = new HashSet<>(Arrays.asList(habilidades));
        tr.alterarHabilidadesTarefa(codigo, habilidadesSet);

    }

    /**
     * adiciona horas gastas na atividade.
     *
     * @param codigo codigo da atividade
     * @param horas  horas gastas.
     */
    public void adicionarHorasTarefa(String codigo, int horas) {
        tr.adicionarHorasTarefa(codigo, horas);
    }

    /**
     * remove horas gastas na atividade.
     *
     * @param codigo codigo da atividade.
     * @param horas  horas a serem removidas.
     */
    public void removerHorasTarefa(String codigo, int horas) {
        tr.removerHorasTarefa(codigo, horas);
    }

    /**
     * conclui uma tarefa.
     *
     * @param codigo codigo da tarefa.
     */
    public void concluirTarefa(String codigo) {
        tr.concluiTarefa(codigo);
    }

    /**
     * remove uma tarefa do sistema. A tarefa é removida no repositório e na
     * Atividade.
     *
     * @param codigo codigo da tarefa.
     */
    public void removerTarefa(String codigo) {
        as.getAtividade(recuperaIdAtividade(codigo)).removerTarefa(codigo);
        tr.removerTarefa(codigo);
    }

    /**
     * exibe uma tarefa.
     *
     * @param codigo codigo da tarefa.
     * @return a representação textual de uma tarefa.
     */
    public String exibirTarefa(String codigo) {
        return tr.exibirTarefa(codigo);
    }

    /**
     * associa uma pessoa a uma tarefa.
     *
     * @param cpf    cpf da pessoa.
     * @param codigo codigo da tarefa.
     */
    public void associarPessoaTarefa(String codigo, String cpf) {
        tr.associarPessoaTarefa(codigo, ps.getPessoa(cpf));
    }

    /**
     * remove uma pessoa de uma tarefa.
     *
     * @param codigo codigo da tarefa.
     * @param cpf    cpf da pessoa.
     */
    public void removerPessoaTarefa(String codigo, String cpf) {
        tr.removerPessoaTarefa(codigo, cpf);
    }

    public void adicionaNasGerenciais(String idGerencial, String idTarefa) {
        tr.adicionaNasGerenciais(idGerencial, idTarefa);
    }

    public void removeDasGerenciais(String idGerencial, String idTarefa) {
        tr.removeDasGerenciais(idGerencial, idTarefa);
    }

    public int totalDeTarefasGerenciadas(String idGerencial) {
        return tr.contaTarefasNasGerenciais(idGerencial);
    }

    /**
     * recupera o Id de uma atividade a partir do código de uma tarefa.
     *
     * @param codigo codigo da tarefa
     * @return Id da Atividade
     */
    private String recuperaIdAtividade(String codigo) {
        String[] parts = codigo.split("-");
        String id = parts[0] + "-" + parts[1];
        return id;
    }
    
    public List<TarefaAbstract> getTarefas(){
    	return tr.getTarefas();
    }
}
