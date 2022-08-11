package sapo.pessoa;

import java.util.ArrayList;
import java.util.List;

public class Pessoa {
    private String cpf;
    private String nome;
    private String[] habilidades;
    private List<Comentario> comentarios;
    public Pessoa(String cpf, String nome, String[] habilidades) {
        this.cpf = cpf;
        this.nome = nome;
        this.habilidades = habilidades;
        this.comentarios = new ArrayList<>() {
        }
    }

    public String getNome() {
        return this.nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getCpf() {
        return this.cpf;
    }

    public void setHabilidades(String[] habilidades) {
        this.habilidades = habilidades;
    }

    public void adicionaComentario(Comentario comentario) {
        this.comentarios.add(comentario);
    }

    public String getComentarios() {
        // TODO - Terminar a listagem de comentarios
        return "";
    }
    @Override
    public String toString() {
        return this.nome + " - " + this.cpf + "\n";
    }
}
