package sapo.busca;

public class ValidadorBusca {

	public static boolean argumentoValido(String arg) {
		return !(arg.isBlank() || arg == null);
	}
	

}
