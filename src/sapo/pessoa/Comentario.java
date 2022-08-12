package sapo.pessoa;

import java.util.Date;

public class Comentario  implements  Comparable<Comentario> {
    private Pessoa autor;
    private String descricao;
    private Date data;

    Comentario(Pessoa autor, String descricao) {
        this.autor = autor;
        this.descricao = descricao;
        this.data = new Date();
    }

    public Date getData() {
        return this.data;
    }

    @Override
    public int compareTo(Comentario c) {
        return this.getData().compareTo(c.getData());
    }

    @Override
    public String toString() {
        return this.descricao + " (" + this.autor.getNome() + ")";
    }
}
