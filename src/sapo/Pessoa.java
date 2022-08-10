package sapo;

public class Pessoa {
    private String cpf;
    private String nome;
    private String[] habilidades;
    public Pessoa(String cpf, String nome, String[] habilidades) {
        this.cpf = cpf;
        this.nome = nome;
        this.habilidades = habilidades;
    }

    public String getCpf() {
        return this.cpf;
    }

    @Override
    public String toString() {
        // TODO - Formatar as habilidadades da pessoa noa toString
        return this.nome + " - " + this.cpf;
    }
}
