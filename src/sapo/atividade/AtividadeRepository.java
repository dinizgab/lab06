package sapo.atividade;

import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.List;

public class AtividadeRepository {
    private Map<String, Atividade> atividades;

    public AtividadeRepository() {
        this.atividades = new HashMap<>();
    }

    public void add(String codigo, Atividade at) {
        this.atividades.put(codigo, at);
    }

    public void remove(String codigo) {
        this.atividades.remove(codigo);
    }

    public int size() {
        return this.atividades.size();
    }

    public Atividade get(String codigo) {
        return this.atividades.get(codigo);
    }

    public List<Atividade> getAtividades() {
        return new ArrayList<>(this.atividades.values());
    }
}
