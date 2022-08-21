package sapo.tarefa;

import java.util.*;

import sapo.pessoa.Pessoa;
import sapo.tarefa.heranca.Tarefa;
import sapo.tarefa.heranca.TarefaAbstract;
import sapo.tarefa.heranca.TarefaGerencial;

public class TarefaRepository {
    private Map<String, TarefaAbstract> tarefas;

    /**
     * Constroi um repositorio de tarefa, guardando as tarefas em um mapa onde a chave é o codigo da tarefa;
     */
    public TarefaRepository() {
        this.tarefas = new HashMap<>();
    }

    /**
     * adiciona uma tarefa ao mapa de tarefas
     *
     * @param tarefa tarefa
     */
    public void adicionaTarefa(TarefaAbstract tarefa) {
        tarefas.put(tarefa.getCodigo(), tarefa);
    }

    public TarefaAbstract getTarefa(String id) {
        return this.tarefas.get(id);
    }

    /**
     * altera o nome de uma tarefa a partir do seu codigo. o nome só pode ser
     * alterado se a atividade não estiver concluída.
     *
     * @param codigo   codigo da tarefa.
     * @param novoNome novo nome da tarefa.
     */
    public void alterarNomeTarefa(String codigo, String novoNome) {
        TarefaAbstract tarefa = tarefas.get(codigo);
        tarefa.setNome(novoNome);
    }

    /**
     * altera as habilidades referentes a uma tarefa. as habilidades só podem ser
     * alteradas se a atividade não estiver concluída.
     *
     * @param codigo      codigo da tarefa.
     * @param habilidades habilidades referentes a tarefa.
     */
    public void alterarHabilidadesTarefa(String codigo, Set<String> habilidades) {
        Tarefa tarefa = (Tarefa) tarefas.get(codigo);
        tarefa.setHabilidades(habilidades);
    }

    /**
     * adiciona horas gastas na atividade.
     *
     * @param codigo codigo da atividade
     * @param horas  horas gastas.
     */
    public void adicionarHorasTarefa(String codigo, int horas) {
        tarefas.get(codigo).adicionaHoras(horas);
    }

    /**
     * remove horas gastas na atividade.
     *
     * @param codigo codigo da atividade.
     * @param horas  horas a serem removidas.
     */
    public void removerHorasTarefa(String codigo, int horas) {
        tarefas.get(codigo).removeHoras(horas);

    }

    /**
     * conclui uma tarefa.
     *
     * @param codigo codigo da tarefa.
     */
    public void concluiTarefa(String codigo) {
        tarefas.get(codigo).concluiTarefa();

    }

    /**
     * remove uma tarefa do mapa de tarefas.
     *
     * @param codigo codigo da tarefa.
     */
    public void removerTarefa(String codigo) {
        tarefas.remove(codigo);

    }

    /**
     * exibe uma tarefa.
     *
     * @param codigo codigo da tarefa.
     * @return a representação textual de uma tarefa.
     */
    public String exibirTarefa(String codigo) {
        return tarefas.get(codigo).toString();
    }

    /**
     * associa uma pessoa a uma terefa.
     *
     * @param codigo codigo da tarefa.
     * @param pessoa pessoa a ser associada.
     */
    public void associarPessoaTarefa(String codigo, Pessoa pessoa) {
        tarefas.get(codigo).adicionaResponsavel(pessoa);
    }

    /**
     * remove uma pessoa de uma tarefa.
     *
     * @param codigo codigo da tarefa.
     * @param cpf    cpf da pessoa.
     */
    public void removerPessoaTarefa(String codigo, String cpf) {
        tarefas.get(codigo).removeResponsavel(cpf);
    }

    public void adicionaNasGerenciais(String idGerencial, String idTarefa) {
        TarefaAbstract t = this.tarefas.get(idTarefa);
        TarefaGerencial tg = (TarefaGerencial) this.tarefas.get(idGerencial);
        tg.adicionaTarefaGerenciada(t);
    }

    public void removeDasGerenciais(String idGerencial, String idTarefa) {
        TarefaGerencial tg = (TarefaGerencial) this.tarefas.get(idGerencial);
        tg.removeTarefaGerenciada(idTarefa);
    }

    public int contaTarefasNasGerenciais(String idGerencial) {
        TarefaGerencial tg = (TarefaGerencial) this.tarefas.get(idGerencial);
        return tg.totalDeTarefas();
    }

    public List<TarefaAbstract> getTarefas() {
        return new ArrayList<>(this.tarefas.values());
    }

    public void removerPessoaTarefaLGPD(String cpf) {
        for (TarefaAbstract t : this.tarefas.values()) {
            t.getResponsaveis().remove(cpf);
        }
    }
}
