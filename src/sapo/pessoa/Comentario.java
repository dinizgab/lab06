package sapo.pessoa;

import java.util.Date;

public class Comentario {
    private Pessoa autor;
    private String descricao;
    private Date data;

    Comentario(Pessoa autor, String descricao) {
        this.autor = autor;
        this.descricao = descricao;
        this.data = new Date();
    }

    @Override
    public String toString() {
        return this.descricao + " (" + this.autor.getNome() + ")";
    }
}
