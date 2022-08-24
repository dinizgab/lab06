package sapo.tarefa;

public class ValidadorTarefa {

  public static boolean argumentoValido(String arg) {
    return !(arg.isBlank() || arg == null);
  }

  public static boolean argumentoValido(String[] arg) {
    return !(arg == null);
  }

}
