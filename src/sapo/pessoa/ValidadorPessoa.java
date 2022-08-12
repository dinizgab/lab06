package sapo.pessoa;

public class ValidadorPessoa {
    public void validacao(String campo) {
        if (campo.isBlank()) {
            throw new IllegalArgumentException("O campo " + campo + " nao pode ser vazio");
        }
    }
}
