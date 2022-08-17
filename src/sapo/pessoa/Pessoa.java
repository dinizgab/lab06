package sapo.pessoa;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Pessoa {
    private final String cpf;
    private String nome;
    private String[] habilidades;
    private final List<Comentario> comentarios;
    public Pessoa(String cpf, String nome, String[] habilidades) {
        this.cpf = cpf;
        this.nome = nome;
        this.habilidades = habilidades;
        this.comentarios = new ArrayList<>();
    }

    public String getNome() {
        return this.nome;
    }
    public void alteraNome(String nome) {
        this.nome = nome;
    }
    public String getCpf() {
        return this.cpf;
    }

    public void alteraHabilidades(String[] habilidades) {
        this.habilidades = habilidades;
    }

    public void adicionaComentario(Comentario comentario) {
        this.comentarios.add(comentario);
    }

    public String getComentarios() {
        String listaComentarios = formataComentarios();
        return this.nome + " - " + this.cpf + "Comentários:\n" + listaComentarios;
    }

    private String formataComentarios() {
        String listaDeComentarios = "";
        Collections.sort(this.comentarios);
        for(Comentario comentario : this.comentarios) {
            listaDeComentarios += comentario.toString() + "\n";
        }

        return listaDeComentarios;
    }

    private String formataHabilidades() {
        Arrays.sort(this.habilidades);
        String habilidadesFormatadas = "";

        for(String habilidade : this.habilidades) {
            habilidadesFormatadas += habilidade;
        }
        return habilidadesFormatadas;
    }
    @Override
    public String toString() {
        String habilidades = formataHabilidades();
        return this.nome + " - " + this.cpf + "\n" + habilidades;
    }
}
