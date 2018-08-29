package vijnana.utilidades.component.utilidades;


import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class ValidacionPatrones {

	private static final String PATTERN_EMAIL = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
			+ "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

	public static boolean validarPatronEmail(String textoEmail)  {
		try {
			Pattern pattern = Pattern.compile(PATTERN_EMAIL);
			
//			textoEmail = eliminarEspacioInicioFinal(textoEmail);
			
			Matcher matcher = pattern.matcher(textoEmail);

			return matcher.matches();
		} catch (Exception e) {
			return false;
		}

	}
	
	public static String stringInvertir(String Formateada){
		StringBuilder builder=new StringBuilder(Formateada);
		String sCadenaInvertida=builder.reverse().toString();
		return sCadenaInvertida;
	}



}
